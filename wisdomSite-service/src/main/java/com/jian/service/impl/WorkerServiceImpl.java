package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ha.facecamera.configserver.pojo.Face;
import com.jian.dao.LjCardInfoMapper;
import com.jian.dao.LjDeviceMapper;
import com.jian.dao.LjWorkTypeMapper;
import com.jian.dao.LjWorkerInfoMapper;
import com.jian.dao.WorkerCardInfoViewMapper;
import com.jian.entity.LjCardInfo;
import com.jian.entity.LjDevice;
import com.jian.entity.LjDeviceExample;
import com.jian.entity.LjWorkType;
import com.jian.entity.LjWorkTypeExample;
import com.jian.entity.LjWorkerCapture;
import com.jian.entity.LjWorkerInfo;
import com.jian.entity.LjWorkerInfoExample;
import com.jian.entity.SysAdmin;

import com.jian.entity.WorkerCardInfoView;
import com.jian.entity.WorkerCardInfoViewExample;
import com.jian.entity.WorkerCardInfoViewExample.Criteria;
import com.jian.service.WorkerService;
import com.jian.service.facecam.FaceCamreaUtil;
import com.jian.util.ActionUtil;
import com.jian.util.CdZjUtil;
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
				if (CdZjUtil.getInstance().Regist(info))
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
			SysAdmin sa = ShiroUtil.getSysAdmin();
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
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil insertCaptureInfo(LjWorkerCapture capture) {
		
		return null;
	}

}
