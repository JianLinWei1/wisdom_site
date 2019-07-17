package com.jian.service.facecam;





import java.text.MessageFormat;
import java.util.ArrayList;

import java.util.Collections;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ha.facecamera.configserver.ConfigServer;
import com.ha.facecamera.configserver.ConfigServerConfig;
import com.ha.facecamera.configserver.ConnectStateInvokeCondition;
import com.ha.facecamera.configserver.DataServer;
import com.ha.facecamera.configserver.DataServerConfig;
import com.ha.facecamera.configserver.pojo.AppConfig;

import com.ha.facecamera.configserver.pojo.Face;
import com.ha.facecamera.configserver.pojo.Gateopening;
import com.ha.facecamera.configserver.pojo.Version;
import com.jian.entity.LjDevice;
import com.jian.entity.SysAdmin;
import com.jian.service.LjDeviceService;
import com.jian.service.SysAdminService;
import com.jian.util.FaceUtil;
import com.jian.util.FileUtil;
import com.jian.util.LjDeviceUtil;
import com.jian.util.UuidUtil;


/**
 * 摄像机设备工具类
 * @ClassName:  FaceCamreaUtil   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年3月21日 下午5:21:23   
 *
 */

@Component
@Order(0)
public class FaceCamreaUtil  implements CommandLineRunner{

	static Logger logger = LoggerFactory.getLogger(FaceCamreaUtil.class);
   private static  FaceCamreaUtil camreaUtil;
     private FaceCamreaUtil(){
		
	}
	
	private static  ConfigServer configServer = new ConfigServer();
	private ExecutorService service = Executors.newFixedThreadPool(6);
	/*ThreadPoolExecutor  executor*/
	private static List<String>  deviceList =  Collections.synchronizedList(new ArrayList<>());
	private static  int  TIME_OUT = 6000;
    
	@Autowired
	private SysAdminService  sysAdminSer;
	@Autowired
	private LjDeviceService  deviceSer;
	
	
	@Value("${configPort}")
	public int configPort;
	@Value("${dataPort}")
	public int dataPort;
	

	public  static  synchronized  FaceCamreaUtil getInstance(){
		if(camreaUtil == null){
			return  new FaceCamreaUtil();
		}
		return camreaUtil;
	}
	
	

	public  void startFaceCamrea( ) {
		boolean ret = configServer.start(configPort, new ConfigServerConfig());
		if (ret) {
			logger.info("******" + "启动配置服务器成功" + "******");
			configServer.onCameraConnected((val) -> {
				AppConfig appConfig = configServer.getAppConfig(val);
				Version appVersion = configServer.getVersion(val);
				logger.info("版本："+appVersion.toJson());
				LjDevice  device = new LjDevice();
				
				/*if ( StartCamreaServerUtil.ljAdminSer == null &&  configServer.disconnectCameraBySn(appVersion.getSn(), 0)){
					logger.error(appVersion.getSn() + "已断开");
					return;
				}*/
				// 验证登录
				SysAdmin admin = new SysAdmin();
				admin.setUserName(appConfig.getRegUserName());
				admin.setPassword(appConfig.getRegPassword());
				if (sysAdminSer.deviceLogin(admin)) {
					logger.info(appVersion.getSn() + "登录成功！");
					device.setDeviceSeril(appVersion.getSn());
					device.setDeviceName(appConfig.getAddrName());
					device.setDeviceType(LjDeviceUtil.lj_6.getDeviceTypeNum());
					device.setBelongId(sysAdminSer.getSysAdminByUsername(admin.getUserName()).getBelongId());
					device.setDeviceNo(appConfig.getDeviceNo());
					if (deviceSer.getDeviceBySeril(device.getDeviceSeril()) != null)
						deviceSer.updateDevice(device);
					else{
					/*	device.setIoType(1);*/
						deviceSer.insertDevice(device);
					}
				} else {
					if (configServer.disconnectCameraBySn(appVersion.getSn(), 0))
					logger.error(appVersion.getSn() + "已断开");
				}
			});
			startDataServer();
			/*getFaceByDevice();
			StreamServerEndpoint.configServer = configServer;
			StreamServerEndpoint.streamDataReceiver = new StreamDataReceiver();
			configServer.onStreamDataReceived(StreamServerEndpoint.streamDataReceiver);*/
			configServer.onCameraDisconnected((val) -> {
				logger.error("设备下线：" + val);
			});
		} else {
			logger.info("启动配置服务器失败");
		}
	}
	
	

	/**
	 * 开启摄像机数据链路
	 * @Title: startDataServer   
	 * @Description: TODO   
	 * @param:  
	 * @author: JianLinWei     
	 * @return: void      
	 * @throws
	 */
	public   void  startDataServer(){
		DataServer dataServer = new DataServer();
		DataServerConfig  config = new DataServerConfig();
		config.connectStateInvokeCondition = ConnectStateInvokeCondition.DevicenoOrSnKnown;
		boolean  ret =  dataServer.start(dataPort, config); 
		if(ret){
			logger.info("******" + "启动数量链路服务器成功" + "******");
			dataServer.onCameraConnected((val)->{
				System.out.println("+++aaaa:"+val);
			});
			dataServer.onAuthing((time, username,  password)->{
				/*LjAdmin  sa  = ljAdminSer.getLjAdminByUsername(username);
				Util.judgeRegPassword(time, "", password);*/
			    
				return true;
			});
			
			dataServer.onCaptureCompareDataReceived((data)->{
				try{
				LjDevice device  = null;
				if(StringUtils.isNotEmpty(data.getSn()))
					device  = deviceSer.getDeviceBySeril(data.getSn());
				else
			        device = deviceSer.getDeviceByNo(data.getCameraID());
				if(device == null)
					return;
				
//				logger.info("接收设备："+data.toJson());
				//logger.info(MessageFormat.format("插入成功:图片>{0}>记录号{1}>设备号{2}", record.getVerifyPhoto(),data.getSequenceID(),device.getDeviceSeril()));
				}catch(Exception e){
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				}
			});
			
		}else{
			logger.info("******" + "启动数量链路服务器失败" + "******");
		}
	}
	
	
	/**
	 * 遍历设备从设备上获取人员信息 进行撞库操作 @Title: getFaceByDevice @Description:
	 * TODO @param: @author: JianLinWei @return: void @throws
	 *//*
	public void getFaceByDevice() {
		try {
			service.execute(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(30*1000);
						} catch (InterruptedException e) {
							logger.error("撞库操作", e);
						}
						if(deviceList.size() <= 0)
							continue;
						Iterator<String> iterator = deviceList.iterator();
						while (iterator.hasNext()) {
							if(deviceList.size() <= 0)
								continue;
							String deviceID =iterator.next(); 
							if(!configServer.getCameraOnlineState(deviceID)){
								    //ConcurrentModificationException 可解决
									iterator.remove();
							}
							//因SDK对MultiFace的版本的此接口不支持,暂时不使用
							String[] faceIds = configServer.getAllPersonID(deviceID, TIME_OUT);
							//暂时使用listFace接口 并按默认20条数据每页 250页数据筛选出 未通过服务器注册的人员
							for (int i = 1; i <= 250; i++) {
								ListFaceCriteria criteria = new ListFaceCriteria();
								criteria.setPageNo(i);
								criteria.setGetFeatureData(false);
								criteria.setGetImageData(true);
								FacePage facePage  = configServer.listFace(deviceID, criteria, TIME_OUT);
								if(facePage == null || facePage.getFaces() == null)
									break;
								List<Face>  faces = Arrays.asList(facePage.getFaces());
								for(Face face : faces){
									if(!faceCamreaSer.judgeIdIsBeing(face.getId())){
										faceCamreaSer.insertFaceCamPersonByDevice(face, deviceID);
									}
								}
							}
						}
						
					}

				}
			});

		} catch (Exception e) {
			logger.error("撞库操作", e);
		}
	}

	*/
	
	/**
	 * 设备是否在线
	 * @Title: isOnline   
	 * @Description: TODO   
	 * @param: @param deviceseril
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: boolean      
	 * @throws
	 */
	public  boolean  isOnline(String  deviceseril){
		return configServer.getCameraOnlineState(deviceseril);
	}
	
	
	
	public   boolean  addFace(Face face , String deviceseril){
		
		return configServer.addFace(deviceseril, face, TIME_OUT);
	}

    
	
	
	
	public  boolean delFace(String deviceseril , String id){
		return  configServer.deleteFace(deviceseril, id, TIME_OUT);
	}
	

	
	
    
	public  boolean  openGate(String deviceseril){
		Gateopening  gateopening = new Gateopening();
		gateopening.setDirection((byte)2);
		gateopening.setPort((byte)1);
		gateopening.setControltype((byte)1);
		gateopening.setEmpid("2019042312203127720");
		
		return configServer.setGateopen(deviceseril, gateopening, TIME_OUT);
	}
	/**
	 * 检测人脸照片是否符合摄像机要求
	 * @Title: getCamreaFeature   
	 * @Description: TODO   
	 * @param: @param imageContent
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: boolean      
	 * @throws
	 */
	public   boolean  getCamreaFeature(byte[]  imageContent){
		
		return configServer.inspectImage(imageContent);
	}
	 
  

    /**
	 * 因系统中存在小区、公司考勤、访客 等模块 , 当项目中使用人脸摄像机时  
	 * 无法对抓拍数据进行本系统业务层的分类(因为SDK只有一个上传入口)
	 * 则该方法对上传的数据进行分类筛选,列如是小区业主的抓拍记录则将数据插入到小区出入记录,
	 * 注意：1,对ID进行后缀区分0 访客  1员工 2 小区住户   弊端：破坏了系统的主键真实性 统一性 没有闭环,上项目需要关闭同步人员线程
	 *   2,对接收到的ID 进行模块查询 存在则分给那个模块   弊端 ：对数据库会造成影响，速度会慢一点
	 * @Title: filterCamrea   
	 * @Description: TODO   
	 * @param: @param record 
	 * @author: JianLinWei     
	 * @return: void      
	 * @throws
	 *//*
	
	public    void  filterCamreaRecord1(FaceCamreaRecord record){
		if(record.getPersonId().substring(record.getPersonId().length()-1).equals("0"))
			visitorSer.insertVisitorInfo(record);
		if(record.getPersonId().substring(record.getPersonId().length()-1).equals("1")){
			record.setPersonId(record.getPersonId().substring(0, record.getPersonId().length()-1));
			attenceSer.insertCamreaToAttence(record);
		} 
		  
	}*/
	
	/**
	 * 获取错误
	 * @Title: getErrorMsg   
	 * @Description: TODO   
	 * @param: @param deviceseril
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public   String  getErrorMsg(){
		
		return configServer.getLastErrorMsg();
	}



	@Override
	public void run(String... args) throws Exception {
		startFaceCamrea();
	}
}
