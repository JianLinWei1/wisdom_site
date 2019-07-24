package com.jian.service.facecam;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ha.facecamera.configserver.pojo.CaptureCompareData;
import com.jian.entity.LjCardInfo;
import com.jian.entity.LjDevice;
import com.jian.entity.LjWorkerInfo;
import com.jian.service.LjDeviceService;
import com.jian.service.WorkerService;
import com.jian.util.DateUtil;
import com.jian.util.DesUtil;
import com.jian.util.FileUtil;
import com.jian.util.ResultUtil;

@Component
@Order(2)
public class CdZjUtil implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger("住建局接口：");
	private static CdZjUtil cdZjUtil;

	private CdZjUtil() {

	}

	public static synchronized CdZjUtil getInstance() {
		if (cdZjUtil == null)
			return new CdZjUtil();
		return cdZjUtil;
	}

	@Autowired
	private WorkerService workerService;
	@Autowired
	private LjDeviceService deviceService;

	private ExecutorService service = Executors.newFixedThreadPool(2);

	String REGISTURI = "http://118.122.92.139:6961/Regist.Asfx";
	String GETADDPERSON = "http://118.122.92.139:6965/httperver/Service/DevivePacketWebSvr.assx/GetAddPerson";
	String FEEDBACK = "http://118.122.92.139:6965/httperver/Service/DevivePacketWebSvr.assx/FeedBack";
	String DELPERSON = "http://118.122.92.139:6965/httperver/Service/DevivePacketWebSvr.assx/GetDelPerson";
	String UPLOAD = "http://118.122.92.139:6965/httperver/Service/DevivePacketWebSvr.assx/UploadAttendance";

	String TEST_DEVMAC_1 = "smz-cjkjg "; // 采集设备测试
	String TEST_DEVMAC_1_DESKEY = "l8iTgWXT";
	String TEST_DEVMAC_2 = "smz-a03";// 进场设备
	String TEST_DEVMAC_2_DESKEY = "kYaAeAp3";
	String TEST_DEVMAC_3 = "smz-b03";// 出场设备
	String TEST_DEVMAC_3_DESKEY = "T9ZkzM1n";

	RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60 * 1000)
			.setConnectionRequestTimeout(60 * 1000).setSocketTimeout(60 * 1000).setRedirectsEnabled(true).build();

	/***
	 * 人脸注册上传
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午1:59:15
	 * @param info
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean Regist(LjWorkerInfo info, LjDevice device) throws UnsupportedEncodingException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(REGISTURI);
		post.setConfig(requestConfig);
		post.setHeader("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());

		List<BasicNameValuePair> parameters = new ArrayList<>();

		String idPhoto = URLEncoder.encode((FileUtil.getInstance().Base642NoHead(info.getIdPhoto())), "UTF-8");
		String photo = URLEncoder.encode((FileUtil.getInstance().Base642NoHead(info.getVisiblePhoto())), "UTF-8");

		parameters.add(new BasicNameValuePair("Idno", info.getIdCard()));
		parameters.add(new BasicNameValuePair("Name", info.getName().replace("[\\s*\t\n\r]", "")));
		parameters.add(new BasicNameValuePair("gender", String.valueOf(info.getGender())));
		parameters.add(new BasicNameValuePair("nation", info.getNation()));
		parameters.add(new BasicNameValuePair("birthday", formatBirth(info.getBirthday())));
		parameters.add(new BasicNameValuePair("address", info.getAddress()));
		parameters.add(new BasicNameValuePair("idissue", info.getIdissue()));
		parameters.add(new BasicNameValuePair("idperiod",
				FileUtil.getInstance().stringFormat(info.getIdBeginDate(), info.getIdEndDate())));
		parameters.add(new BasicNameValuePair("idphoto", idPhoto));
		parameters.add(new BasicNameValuePair("photo", photo));
		parameters.add(new BasicNameValuePair("userType", String.valueOf(1)));
		parameters.add(new BasicNameValuePair("dev_mac", device.getDeviceSeril()));
		parameters.add(new BasicNameValuePair("RegType", String.valueOf(3)));

		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, Consts.UTF_8);
			post.setEntity(new StringEntity(EntityUtils.toString(entity).replaceAll("[\\s*\t\n\r]", "")));

			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			logger.info(response.getStatusLine().getStatusCode() + str);

			JSONObject json = JSONObject.parseObject(str);
			response.close();
			if (json.getIntValue("errcode") == 0)
				return true;

		} catch (ClientProtocolException e) {
			logger.error(e.getLocalizedMessage(), e);

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return false;

	}

	public String formatBirth(String str) {
		StringBuffer buffer = new StringBuffer(str);
		buffer.insert(4, "-");
		buffer.insert(7, "-");
		return buffer.toString();
	}

	/**
	 * 获取下发人员
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午2:01:31
	 */
	public void getIssuedPersonThread() {
		service.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {

						logger.info("*******获取市平台下发人脸********");
						List<LjDevice> devices = deviceService.getDevices();
						for (LjDevice d : devices) {
							getIssuedPerson(d.getDeviceSeril() ,d.getDeviceKey());
							delPerson(d.getDeviceSeril() , d.getDeviceKey());
						}
						Thread.sleep(1 * 60 * 1000);

					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}

			}
		});

	}

	public void getIssuedPerson(String device , String  devKey) {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(GETADDPERSON + "?sn=" + TEST_DEVMAC_2);
		get.setConfig(requestConfig);
		get.addHeader("Content-type", "application/json");

		try {
			CloseableHttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
				String str = EntityUtils.toString(response.getEntity(), Charset.forName("utf-8"));
				str = str.replace("<string>", "");
				str = str.replace("</string>", "");

				JSONObject json = JSONObject.parseObject(str);

				int code = json.getIntValue("Result");
				if (code == 0) {
					String content = json.getString("Content");
					String decryptContent = DesUtil.getInstance().decrypt(content, Charset.forName("utf-8"),
							devKey);
					logger.info("解密后：" + decryptContent);
					JSONArray json2 = JSONArray.parseArray(decryptContent);
					json2.forEach(data -> {
						LjWorkerInfo info = new LjWorkerInfo();

						JSONObject object = (JSONObject) data;
						info.setUserId(object.getString("user_id"));
						info.setName(object.getString("name"));
						String id_card = object.getString("id_card");
						if (StringUtils.isNotEmpty(id_card)) {
							info.setIdCard(id_card);
						} else {
							LjCardInfo cardInfo = workerService.getLjCardInfoByName(info.getName());
							if (cardInfo != null)
								info.setIdCard(cardInfo.getIdCard());
							else
								info.setIdCard(info.getUserId());

						}

						info.setVisiblePhoto(object.getString("face_template"));
						info.setBelongId(deviceService.getDeviceBySeril(device).getBelongId());
						LjCardInfo info2 = info;
						ResultUtil r = workerService.insertWorkerInfoCd(info, info2, device);
						if (r.getCode() == 0) {
							logger.info("获取人员添加成功-" + info.getName());
							feedBack(2, "添加成功", device);
						} else {
							logger.info("添加到失败-" + info.getName() + r.getMsg());
							feedBack(3, r.getMsg(), device);
						}

					});

				}

			}
			response.close();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * 反馈
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月22日下午4:02:21
	 * @param type
	 * @param msg
	 * @param sn
	 */
	public void feedBack(int type, String msg, String sn) {
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet post = new HttpGet(FEEDBACK + "?type=" + type + "&sn=" + sn + "&msg=" + msg);
			post.setConfig(requestConfig);

			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			logger.info(str);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 删除
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月22日下午4:18:29
	 * @param device
	 */
	public void delPerson(String device ,String devKey) {
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet get = new HttpGet(DELPERSON + "?sn=" + device);
			get.setConfig(requestConfig);
			CloseableHttpResponse response = client.execute(get);
			String str = EntityUtils.toString(response.getEntity());
			str = str.replace("<string>", "");
			str = str.replace("</string>", "");
			JSONObject json = JSONObject.parseObject(str);

			int code = json.getIntValue("Result");
			if (code == 0) {
				String content = json.getString("Content");
				System.out.println(content);

				String decryptContent = DesUtil.getInstance().decrypt(content, Charset.forName("utf-8"),
						devKey);
				logger.info("删除人员解密后：" + decryptContent);
				JSONArray json2 = JSONArray.parseArray(decryptContent);
				json2.forEach(data -> {
					JSONObject object = (JSONObject) data;
					ResultUtil r = workerService.delWorkerInfoCd(device, object.getString("user_id"));
					if (r.getCode() == 0) {
						logger.info("删除人员成功-");
						feedBack(0, "领军智能删除成功  ", device);
					} else {
						logger.info("删除人员失败-");
						feedBack(1, "领军智能删除失败" + r.getMsg(), device);
					}

				});

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 上传识别结果
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月22日下午4:53:00
	 * @param data
	 * @return
	 */
	public boolean uploadResult(CaptureCompareData data) {
		try {
			JSONObject json1 = new JSONObject();
			json1.put("sn", data.getSn());
			json1.put("user_id", data.getPersonID());
			json1.put("recog_time", DateUtil.Date2yMdHms(data.getCaptureTime()));
			json1.put("recog_type", "iris");
			JSONArray jsona = new JSONArray();
			jsona.add(json1);
			JSONObject json = new JSONObject();
			json.put("Count", 1);
			json.put("logs", jsona);
			String content = DesUtil.getInstance().encrypt(json.toString(), Charset.forName("utf-8"),
					data.getSn());
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost(UPLOAD + "?sn=" + data.getSn() + "&content=" + content);
			post.setConfig(requestConfig);

			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			logger.info("上传：" + str);
			str = str.replace("<string>", "");
			str = str.replace("</string>", "");
			JSONObject res = JSONObject.parseObject(str);
			if (res.getIntValue("Result") == 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}

	}

	@Override
	public void run(String... args) throws Exception {
		getIssuedPersonThread();
	}

}
