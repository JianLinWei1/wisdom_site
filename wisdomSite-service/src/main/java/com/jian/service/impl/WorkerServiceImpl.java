package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ha.facecamera.configserver.pojo.CaptureCompareData;
import com.ha.facecamera.configserver.pojo.Face;
import com.jian.dao.LjCardInfoMapper;
import com.jian.dao.LjDeviceMapper;
import com.jian.dao.LjStrangerCaptureMapper;
import com.jian.dao.LjWorkTypeMapper;
import com.jian.dao.LjWorkerCaptureMapper;
import com.jian.dao.LjWorkerInfoMapper;
import com.jian.dao.StrangerCaptureViewMapper;
import com.jian.dao.WorkerCaptureViewMapper;
import com.jian.dao.WorkerCardInfoViewMapper;
import com.jian.entity.LjCardInfo;
import com.jian.entity.LjCardInfoExample;
import com.jian.entity.LjDevice;
import com.jian.entity.LjDeviceExample;
import com.jian.entity.LjStrangerCapture;
import com.jian.entity.LjWorkType;
import com.jian.entity.LjWorkTypeExample;
import com.jian.entity.LjWorkerCapture;
import com.jian.entity.LjWorkerCaptureExample;
import com.jian.entity.LjWorkerInfo;
import com.jian.entity.LjWorkerInfoExample;
import com.jian.entity.StrangerCaptureView;
import com.jian.entity.StrangerCaptureViewExample;
import com.jian.entity.StrangerCaptureViewExample.Criterion;
import com.jian.entity.SysAdmin;
import com.jian.entity.WorkerCaptureView;
import com.jian.entity.WorkerCaptureViewExample;
import com.jian.entity.WorkerCardInfoView;
import com.jian.entity.WorkerCardInfoViewExample;
import com.jian.entity.WorkerCardInfoViewExample.Criteria;
import com.jian.service.WorkerService;
import com.jian.service.facecam.CdZjUtil;
import com.jian.service.facecam.FaceCamreaUtil;
import com.jian.util.ActionUtil;
import com.jian.util.DevMacUtil;
import com.jian.util.FaceUtil;
import com.jian.util.FileUtil;
import com.jian.util.HwUtil;
import com.jian.util.LjDeviceUtil;
import com.jian.util.ResultUtil;
import com.jian.util.ShiroUtil;
import com.jian.util.UuidUtil;

@Service
public class WorkerServiceImpl implements WorkerService {
	private Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);
	@Resource
	private LjWorkTypeMapper workTypeMapper;
	@Resource
	private LjWorkerInfoMapper wokerInfoMapper;
	@Resource
	private LjCardInfoMapper cardInfoMapper;
	@Resource
	private LjDeviceMapper deviceMapper;
	@Resource
	private WorkerCardInfoViewMapper workerCardInfoMapper;
	@Resource
	private LjWorkerCaptureMapper  captureMapper;
	@Resource
	private LjStrangerCaptureMapper strangerMapper;
	@Resource
	private WorkerCaptureViewMapper  captureViewMapper;
	@Resource
	private StrangerCaptureViewMapper strangerViewMapper;

	@Override
	public ResultUtil insertWorkType(LjWorkType workType) {
		try {
			SysAdmin sa = ShiroUtil.getSysAdmin();
			workType.setBelongId(sa.getBelongId());
			workType.setId(UuidUtil.getUUID());
			workType.setVersion(System.currentTimeMillis());
			workType.setAction(ActionUtil.insert.getCode());
			workTypeMapper.insert(workType);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil listWorkType(int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		LjWorkTypeExample example = new LjWorkTypeExample();
		example.createCriteria().andBelongIdEqualTo(sa.getBelongId());
		List<LjWorkType> list = workTypeMapper.selectByExample(example);
		PageInfo<LjWorkType> info = new PageInfo<>(list);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int) info.getTotal());
		util.setData(list);
		return util;
	}

	@Override
	public ResultUtil updateWorkType(LjWorkType workType) {
		try {
			SysAdmin sa = ShiroUtil.getSysAdmin();
			workType.setVersion(System.currentTimeMillis());
			workType.setAction(ActionUtil.update.getCode());
			workType.setBelongId(sa.getBelongId());
			workTypeMapper.updateByPrimaryKey(workType);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil delWorkType(String id) {
		try {
			workTypeMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil insertWorkerInfo(LjWorkerInfo info, LjCardInfo info2) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		try {
			String idphoto_url = null;
			if (StringUtils.isNotEmpty(info2.getIdPhoto())) {
				byte[] idPhoto = FileUtil.getInstance().Base642Byte(info2.getIdPhoto());
				idphoto_url = FileUtil.getInstance().addPicture2Midkirs(idPhoto, info2.getIdCard(), "idphoto/");
			}
			byte[] visiblePhoto = FileUtil.getInstance().Base642Byte(info2.getVisiblePhoto());
			String visiblePhoto_url = FileUtil.getInstance().addPicture2Midkirs(visiblePhoto, info2.getIdCard(),
					"images/");
			String msg = FaceUtil.DetectFace(visiblePhoto);
			if (StringUtils.isNotEmpty(msg))
				return ResultUtil.error(msg);
			byte[] feature = FaceUtil.getFeature(visiblePhoto);
			String feature_url = FileUtil.getInstance().addFeature2File(feature, info2.getIdCard(), "feature/");
			if (!FaceCamreaUtil.getInstance().getCamreaFeature(visiblePhoto))
				return new ResultUtil(-1, "人脸检测不通过");

			info2.setAction(ActionUtil.insert.getCode());
			info2.setVersion(System.currentTimeMillis());

			info2.setVisiblePhotoFeature(feature_url);
			info2.setBelongId(sa.getBelongId());
			if (StringUtils.isNotEmpty(info2.getIdPhoto())) {
				LjDevice device = new LjDevice();
				device.setDeviceNo(DevMacUtil.getSn());
				if (CdZjUtil.getInstance().Regist(info ,device))
					info.setUpload(1);
				else
					info.setUpload(-1);
			}

			ResultUtil resultUtil = addWokerInfoToCamrea(info);
			if (resultUtil.getCode() != 0)
				msg = resultUtil.getMsg();

			info2.setIdPhoto(idphoto_url);
			info2.setVisiblePhoto(visiblePhoto_url);
			if (cardInfoMapper.selectByPrimaryKey(info2.getIdCard()) == null)
				cardInfoMapper.insertSelective(info2);
			else
				cardInfoMapper.updateByPrimaryKeySelective(info2);

			info.setAction(ActionUtil.insert.getCode());
			info.setVersion(System.currentTimeMillis());
			info.setBelongId(sa.getBelongId());
			if (wokerInfoMapper.selectByPrimaryKey(info.getIdCard()) == null)
				wokerInfoMapper.insertSelective(info);
			else
				wokerInfoMapper.updateByPrimaryKeySelective(info);
			if (StringUtils.isNotEmpty(msg)) {
				return new ResultUtil(-2, msg);
			}
			return ResultUtil.ok();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}

	}

	@Override
	public ResultUtil listWorkTypeAll() {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		LjWorkTypeExample example = new LjWorkTypeExample();
		example.createCriteria().andBelongIdEqualTo(sa.getBelongId());
		List<LjWorkType> list = workTypeMapper.selectByExample(example);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setData(list);
		return util;
	}

	@Override
	public ResultUtil uploadIdCardImg(String fontImg, String backImg) {
		ResultUtil util = HwUtil.getInstance().HwIDCardOCRFront(fontImg);
		ResultUtil util2 = HwUtil.getInstance().HwIDCardOCRBack(backImg);
		if (util2.getCode() == 0 && util.getCode() == 0) {
			LjCardInfo cardInfo = (LjCardInfo) util.getData();
			LjCardInfo cardInfo2 = (LjCardInfo) util2.getData();
			cardInfo.setIdissue(cardInfo2.getIdissue());
			cardInfo.setIdBeginDate(cardInfo2.getIdBeginDate());
			cardInfo.setIdEndDate(cardInfo2.getIdEndDate());
			util.setData(cardInfo);
			return util;
		}
		return ResultUtil.error();
	}

	@Override
	public ResultUtil addWokerInfoToCamrea(LjWorkerInfo info) {
		try {
			String msg = "";
			SysAdmin sa  = ShiroUtil.getSysAdmin();
			
			LjDeviceExample example = new LjDeviceExample();
			example.createCriteria().andBelongIdEqualTo(sa.getBelongId());
			example.createCriteria().andDeviceTypeEqualTo(LjDeviceUtil.lj_6.getDeviceTypeNum());
			List<LjDevice> devices = deviceMapper.selectByExample(example);

			Face face = new Face();
			face.setId(info.getIdCard());
			face.setName(info.getName());
			face.setRole(1);
			byte[][] jpgFileContent = new byte[1][];
			jpgFileContent[0] = FileUtil.getInstance().Base642Byte(info.getVisiblePhoto());
			face.setJpgFileContent(jpgFileContent);

			for (LjDevice d : devices) {
				if (StringUtils.isNotEmpty(info.getIdPhoto())
						&& !FaceCamreaUtil.getInstance().addFace(face, d.getDeviceSeril())) {
					msg += d.getDeviceSeril() + "_" + d.getDeviceName() + "_"
							+ FaceCamreaUtil.getInstance().getErrorMsg();
				}
				if (StringUtils.isEmpty(info.getIdPhoto())) {
					FaceCamreaUtil.getInstance().delFace(d.getDeviceSeril(), info.getIdCard());
					FaceCamreaUtil.getInstance().addFace(face, d.getDeviceSeril());
				}
			}

			if (StringUtils.isNotEmpty(msg))
				return new ResultUtil(-2, msg);
			else
				return ResultUtil.ok();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
	}

	@Override
	public ResultUtil listWorkerInfo(int page, int limit) {
		SysAdmin admin = ShiroUtil.getSysAdmin();
		WorkerCardInfoViewExample example = new WorkerCardInfoViewExample();
		PageHelper.startPage(page, limit);
		example.createCriteria().andActionNotEqualTo(ActionUtil.delete.getCode());
		example.createCriteria().andBelongIdEqualTo(admin.getBelongId());
		List<WorkerCardInfoView> views = workerCardInfoMapper.selectByExample(example);
		PageInfo<WorkerCardInfoView> info = new PageInfo<>(views);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int) info.getTotal());
		util.setData(views);
		return util;
	}

	@Override
	public ResultUtil listWokerInfoByIdcard(String idcard, int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		WorkerCardInfoViewExample example = new WorkerCardInfoViewExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andBelongIdEqualTo(sa.getBelongId());
		criteria.andActionNotEqualTo(ActionUtil.delete.getCode());
		criteria.andIdCardLike("%"+idcard+"%");
		List<WorkerCardInfoView>  views =  workerCardInfoMapper.selectByExample(example);
		PageInfo<WorkerCardInfoView> info = new PageInfo<>(views);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(views);
		return util;
	}

	@Override
	public ResultUtil listWokerInfoByName(String name, int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		WorkerCardInfoViewExample example = new WorkerCardInfoViewExample();
		PageHelper.startPage(page, limit);
         Criteria criteria = example.createCriteria();
		
		criteria.andBelongIdEqualTo(sa.getBelongId());
		criteria.andActionNotEqualTo(ActionUtil.delete.getCode());
		criteria.andNameLike("%"+name+"%");
		List<WorkerCardInfoView>  views =  workerCardInfoMapper.selectByExample(example);
		PageInfo<WorkerCardInfoView> info = new PageInfo<>(views);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(views);
		return util;
	}

	@Override
	public ResultUtil delWokerInfoByIdCard(String idCard) {
		
		LjWorkerInfo  info = new LjWorkerInfo();
		info.setIdCard(idCard);
		info.setAction(ActionUtil.delete.getCode());
		info.setVersion(System.currentTimeMillis());
		try{
			
			wokerInfoMapper.updateByPrimaryKeySelective(info);
			LjDeviceExample example = new LjDeviceExample();
			com.jian.entity.LjDeviceExample.Criteria criteria = example.createCriteria();
			criteria.andBelongIdEqualTo(ShiroUtil.getSysAdmin().getBelongId());
			criteria.andDeviceTypeEqualTo(LjDeviceUtil.lj_6.getDeviceTypeNum());
			List<LjDevice>  devices = deviceMapper.selectByExample(example);
			for(LjDevice d :devices){
			FaceCamreaUtil.getInstance().delFace(d.getDeviceSeril(), idCard);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil insertCaptureInfo(CaptureCompareData  data ,String belongId) {
		try{
			LjWorkerCapture capture = new LjWorkerCapture();
			capture.setBelongId(belongId);
			String capturePhoto = FileUtil.getInstance().addPicture2Midkirs(data.getEnvironmentImageData(), data.getPersonID(), "record/");
			capture.setCapturePhoto(capturePhoto);
			capture.setCaptureTime(data.getCaptureTime());
			capture.setDeviceSeril(data.getSn());
			capture.setIdCard(data.getPersonID());
			capture.setMatchScore(data.getMatchScore());
			capture.setUuid(UuidUtil.getUUID());
			LjWorkerInfo  info = getLjWorkerInfoByUserId(data.getPersonID());
			if(info != null)
				data.setPersonID(info.getUserId());
			if(CdZjUtil.getInstance().uploadResult(data))
			      capture.setUpload(1);
			else
				capture.setUpload(-1);
			 captureMapper.insertSelective(capture);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil insertStrangerInfo(CaptureCompareData  data ,String belongId) {
		try{
			LjStrangerCapture capture = new LjStrangerCapture();
			capture.setBelongId(belongId);
			String capturePhoto = FileUtil.getInstance().addPicture2Midkirs(data.getEnvironmentImageData(), "stranger", "stranger/");
			capture.setCapturePhoto(capturePhoto);
			capture.setCaptureTime(data.getCaptureTime());
			capture.setqValue((int)data.getqValue());
			capture.setUuid(UuidUtil.getUUID());
			capture.setDeviceSeril(data.getSn());
			strangerMapper.insertSelective(capture);
			
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil listCaptureInfos(int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		WorkerCaptureViewExample captureExample = new WorkerCaptureViewExample();
		captureExample.setOrderByClause("capture_time  DESC");
		com.jian.entity.WorkerCaptureViewExample.Criteria criteria = captureExample.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		
		List<WorkerCaptureView>  captureViews = captureViewMapper.selectByExample(captureExample);
		PageInfo<WorkerCaptureView>  info = new PageInfo<>(captureViews);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(captureViews);
		return util;
	}

	@Override
	public ResultUtil listCaptureInfosReloadByIdcard(String idCard, int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		WorkerCaptureViewExample captureViewExample = new WorkerCaptureViewExample();
		captureViewExample.setOrderByClause("capture_time  DESC");
		com.jian.entity.WorkerCaptureViewExample.Criteria criteria = captureViewExample.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		criteria.andIdCardLike("%"+idCard+"%");
		List<WorkerCaptureView>  views = captureViewMapper.selectByExample(captureViewExample);
		PageInfo<WorkerCaptureView> info = new PageInfo<>(views);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount((int)info.getTotal());
		resultUtil.setData(views);
		return resultUtil;
	}

	@Override
	public ResultUtil listCaptureInfosReloadByName(String name, int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		WorkerCaptureViewExample captureViewExample = new WorkerCaptureViewExample();
		captureViewExample.setOrderByClause("capture_time  DESC");
		com.jian.entity.WorkerCaptureViewExample.Criteria criteria = captureViewExample.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		criteria.andNameLike("%"+name+"%");
		List<WorkerCaptureView>  views = captureViewMapper.selectByExample(captureViewExample);
		PageInfo<WorkerCaptureView> info = new PageInfo<>(views);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount((int)info.getTotal());
		resultUtil.setData(views);
		return resultUtil;
	}

	@Override
	public ResultUtil delCaptureInfoByUUID(String uuid) {
		try{
			captureMapper.deleteByPrimaryKey(uuid);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil listStrangerCaptures(int page, int limt) {
		SysAdmin sa  = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limt);
		StrangerCaptureViewExample  example = new StrangerCaptureViewExample();
		example.setOrderByClause("capture_time  DESC");
		com.jian.entity.StrangerCaptureViewExample.Criteria criteria = example.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		List<StrangerCaptureView> captureViews = strangerViewMapper.selectByExample(example);
		PageInfo<StrangerCaptureView>  info = new PageInfo<>(captureViews);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(captureViews);
		return util;
	}

	@Override
	public ResultUtil delStrangerCaptureByUUID(String uuid) {
		try{
			strangerMapper.deleteByPrimaryKey(uuid);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return ResultUtil.ok();
	}

	

	@Override
	public ResultUtil insertWorkerInfoCd(LjWorkerInfo info, LjCardInfo info2 ,String device) {
		try {
			
			byte[] visiblePhoto = FileUtil.getInstance().Base642Byte(info2.getVisiblePhoto());
			
			String msg = FaceUtil.DetectFace(visiblePhoto);
			if (StringUtils.isNotEmpty(msg))
				return ResultUtil.error(msg);
			byte[] feature = FaceUtil.getFeature(visiblePhoto);
			String feature_url = FileUtil.getInstance().addFeature2File(feature, info2.getIdCard(), "feature/");
			if (!FaceCamreaUtil.getInstance().getCamreaFeature(visiblePhoto))
				return new ResultUtil(-1, "人脸检测不通过");
			String visiblePhoto_url = FileUtil.getInstance().addPicture2Midkirs(visiblePhoto, info2.getIdCard(),
					"images/");

			info2.setAction(ActionUtil.insert.getCode());
			info2.setVersion(System.currentTimeMillis());

			info2.setVisiblePhotoFeature(feature_url);
			info2.setBelongId(info.getBelongId());
			info.setUpload(2);

			ResultUtil resultUtil = addWorkerInfoToCamCd(info , device);
			if (resultUtil.getCode() != 0)
				msg = resultUtil.getMsg();

			
			info2.setVisiblePhoto(visiblePhoto_url);
			if (cardInfoMapper.selectByPrimaryKey(info2.getIdCard()) == null)
				cardInfoMapper.insertSelective(info2);
			else
				cardInfoMapper.updateByPrimaryKeySelective(info2);

			info.setAction(ActionUtil.insert.getCode());
			info.setVersion(System.currentTimeMillis());
			info.setBelongId(info.getBelongId());
			if (wokerInfoMapper.selectByPrimaryKey(info.getIdCard()) == null)
				wokerInfoMapper.insertSelective(info);
			else
				wokerInfoMapper.updateByPrimaryKeySelective(info);
			if (StringUtils.isNotEmpty(msg)) {
				return new ResultUtil(-2, msg);
			}
			return ResultUtil.ok();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
	}

	@Override
	public ResultUtil addWorkerInfoToCamCd(LjWorkerInfo info, String device) {
		try {
			String msg = "";
//			LjDeviceExample example = new LjDeviceExample();
//			example.createCriteria().andBelongIdEqualTo(info.getBelongId());
//			example.createCriteria().andDeviceTypeEqualTo(LjDeviceUtil.lj_6.getDeviceTypeNum());
//			List<LjDevice> devices = deviceMapper.selectByExample(example);

			Face face = new Face();
			face.setId(info.getIdCard());
			face.setName(info.getName());
			face.setRole(1);
			byte[][] jpgFileContent = new byte[1][];
			jpgFileContent[0] = FileUtil.getInstance().Base642Byte(info.getVisiblePhoto());
			face.setJpgFileContent(jpgFileContent);
         
			
				if (!FaceCamreaUtil.getInstance().addFace(face, device)) {
					msg += device+ "_" + FaceCamreaUtil.getInstance().getErrorMsg();
				}
				
		

			if (StringUtils.isNotEmpty(msg))
				return new ResultUtil(-2, msg);
			else
				return ResultUtil.ok();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
	}

	@Override
	public ResultUtil delWorkerInfoCd(String device, String uerid) {
		LjWorkerInfoExample example  = new LjWorkerInfoExample();
		com.jian.entity.LjWorkerInfoExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(uerid);
		List<LjWorkerInfo>  infos = wokerInfoMapper.selectByExample(example);
		if(infos.size() > 0 &&  FaceCamreaUtil.getInstance().delFace(device, infos.get(0).getIdCard())){
			return ResultUtil.ok();
			
		}else{
			return  new ResultUtil(-1, FaceCamreaUtil.getInstance().getErrorMsg());
		}
		
	}

	@Override
	public LjWorkerInfo getLjWorkerInfoByUserId(String userid) {
		LjWorkerInfoExample example  = new LjWorkerInfoExample();
		com.jian.entity.LjWorkerInfoExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userid);
		List<LjWorkerInfo>  infos = wokerInfoMapper.selectByExample(example);
		if(infos.size() > 0)
			return infos.get(0);
		
		return null;
	}

	@Override
	public LjCardInfo getLjCardInfoByName(String name) {
		LjCardInfoExample example = new LjCardInfoExample();
		com.jian.entity.LjCardInfoExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<LjCardInfo> cardInfos = cardInfoMapper.selectByExample(example);
		if(cardInfos.size() > 0)
			return cardInfos.get(0);
		return null;
	}

}
