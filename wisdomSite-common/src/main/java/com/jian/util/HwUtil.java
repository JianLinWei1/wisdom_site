package com.jian.util;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jian.entity.LjCardInfo;

/**
 * 华为接口调用
 * 
 * @ClassName: HwUtil
 * @Description:TODO
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date: 2019年6月28日 下午3:17:50
 *
 */
public class HwUtil {
	Logger logger = LoggerFactory.getLogger(FileUtil.class);

	// private ConcurrentMap<String, String> concurrentMap;

	private static HwUtil hwUtil;

	private HwUtil() {

	}

	public static synchronized HwUtil getInstance() {
		if (hwUtil == null)
			return new HwUtil();

		return hwUtil;
	}

	String PROJECTID = "a5e69fc20ccc4baba9e2c816672025b6";
	String URISCHEME = "https://face.cn-north-1.myhuaweicloud.com";
	String FACESETNAME = "jian_face_lib";

	RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60 * 1000)
			.setConnectionRequestTimeout(60 * 1000).setSocketTimeout(60 * 1000).setRedirectsEnabled(true).build();

	/**
	 * 获取token @Title: getHwToken @Description: TODO @param: @return @author:
	 * JianLinWei @return: String @throws
	 */
	public String getHwToken() {
		// String time = concurrentMap.get("time");
		//
		// if(StringUtils.isNotEmpty(time) &&( System.currentTimeMillis() -
		// Integer.valueOf(concurrentMap.get("time"))) < 12*60*60*1000)
		// return concurrentMap.get("X-Auth-Token");
		String url = "https://iam.cn-north-1.myhuaweicloud.com/v3/auth/tokens";
		String jsonStr = FileUtil.getInstance().getJsonFile("GETHWTOKEN.json");
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		post.setEntity(new StringEntity(jsonStr, Charset.forName("utf-8")));
		try {
			CloseableHttpResponse response = client.execute(post);
			StatusLine statusline = response.getStatusLine();
			int responsecode = statusline.getStatusCode();
			if (responsecode == 201) {
				HttpEntity entity = response.getEntity();
				String str = EntityUtils.toString(entity, "utf-8");
				System.out.println(str);
			}
			Header[] headers = response.getHeaders("X-Subject-Token");
			// concurrentMap.put("X-Auth-Token", headers[0].getValue());
			// concurrentMap.put("time",
			// String.valueOf(System.currentTimeMillis()));
			return headers[0].getValue();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 人脸检测 @Title: HwFaceDetect @Description: TODO @param: @param
	 * base64Img @param: @return @author: JianLinWei @return: ResultUtil @throws
	 */
	public ResultUtil HwFaceDetect(String base64Img) {
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-detect";
		System.out.println(url);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		String token = getHwToken();
		post.setHeader("X-Auth-Token", token);
		JSONObject json = new JSONObject();
		json.put("image_base64", base64Img);
		json.put("attributes", "0");
		post.setEntity(new StringEntity(json.toJSONString(), Charset.forName("utf-8")));
		try {
			CloseableHttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200)
				return new ResultUtil(-100, "网络请求异常" + response.getStatusLine().getStatusCode());

			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			json = JSON.parseObject(str);
			JSONArray faces = json.getJSONArray("faces");
			if (faces.size() <= 0)
				return new ResultUtil(-101, "未检测到人脸");
			if (faces.size() > 1)
				return new ResultUtil(-102, "检测到多张人脸");
			JSONObject face1 = faces.getJSONObject(0).getJSONObject("attributes").getJSONObject("headpose");
			if (face1 == null)
				return ResultUtil.ok();
			float pitch_angle = face1.getFloat("pitch_angle");
			float roll_angle = face1.getFloat("roll_angle");
			float yaw_angle = face1.getFloat("yaw_angle");
			if (pitch_angle < -15 || pitch_angle > 15 || roll_angle < -15 || roll_angle > 15 || yaw_angle < -15
					|| yaw_angle > 15)
				return new ResultUtil(-103, "请摆正人脸姿势");

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResultUtil.ok();

	}
	/**
	 * 获取人脸位置
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月15日上午11:17:33
	 * @param base64Img
	 * @return
	 */
	public ResultUtil HwFaceDetectPosition(String base64Img) {
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-detect";
		System.out.println(url);
		ResultUtil util = new ResultUtil();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		String token = getHwToken();
		post.setHeader("X-Auth-Token", token);
		JSONObject json = new JSONObject();
		json.put("image_base64", base64Img);
		
		post.setEntity(new StringEntity(json.toJSONString(), Charset.forName("utf-8")));
		try {
			CloseableHttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200)
				return new ResultUtil(-100, "网络请求异常" + response.getStatusLine().getStatusCode());

			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			json = JSON.parseObject(str);
			JSONArray faces = json.getJSONArray("faces");
			if (faces.size() <= 0)
				return new ResultUtil(-101, "未检测到人脸");
			if (faces.size() > 1)
				return new ResultUtil(-102, "检测到多张人脸");
			JSONObject face1 = faces.getJSONObject(0).getJSONObject("bounding_box");
			util.setCode(0);
			util.setData(face1.toString());
            return util;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResultUtil.error();

	}

	/**
	 * 添加人脸到人脸库 @Title: HwAddFaceToLibrary @Description: TODO @param: @param
	 * base64Img @param: @param ImgId @param: @return @author:
	 * JianLinWei @return: ResultUtil @throws
	 */
	public ResultUtil HwAddFaceToLibrary(String base64Img, String ImgId) {
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-sets/" + FACESETNAME + "/faces";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		String token = getHwToken();
		post.setHeader("X-Auth-Token", token);
		JSONObject json = new JSONObject();
		json.put("image_base64", base64Img);
		json.put("external_image_id", ImgId);
		post.setEntity(new StringEntity(json.toString(), Charset.forName("utf-8")));
		try {
			CloseableHttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200)
				return new ResultUtil(-100, "网络请求异常");
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			return ResultUtil.ok();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return new ResultUtil(-100, "网络请求异常");
		} catch (IOException e) {
			e.printStackTrace();
			return new ResultUtil(-100, "网络请求异常");
		}
	}

	/**
	 * 通过定义的图片ID 删除人脸
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月10日下午2:04:00
	 * @param ImgId
	 */
	public void HwDelFaceByExternalImgId(String ImgId) {
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-sets/" + FACESETNAME + "/faces?external_image_id=" + ImgId;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpDelete delete = new HttpDelete(url);
		delete.setConfig(requestConfig);
		delete.setHeader("Content-type", "application/json");
		String token = getHwToken();
		delete.setHeader("X-Auth-Token", token);

		try {
			CloseableHttpResponse response = client.execute(delete);
			if (response.getStatusLine().getStatusCode() == 200)
				System.out.println("ok");
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void CreateFaceLibrary() {
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-sets";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		String token = getHwToken();
		post.setHeader("X-Auth-Token", token);
		JSONObject json = new JSONObject();
		json.put("face_set_name", "jian_face_lib");
		post.setEntity(new StringEntity(json.toString(), Charset.forName("utf-8")));
		try {
			CloseableHttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			System.out.println(str);
			// {"face_set_info":{"face_number":0,"face_set_id":"Lb2zcCTE","face_set_name":"jian_face_lib","create_date":"2019-07-02
			// 03:50:12","face_set_capacity":100000}}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取人脸库数据
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月10日下午2:04:31
	 */
	public void HwGetFacesByLibrary() {
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-sets/" + FACESETNAME + "/faces?offset=0&limit=1000";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig);
		get.setHeader("Content-type", "application/json");
		String token = getHwToken();
		get.setHeader("X-Auth-Token", token);

		try {
			CloseableHttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			System.out.println(str);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResultUtil HwGetFaceByImg(String imgBase) {
		ResultUtil util = new ResultUtil();
		String url = URISCHEME + "/v1/" + PROJECTID + "/face-sets/" + FACESETNAME + "/search";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		post.setHeader("X-Auth-Token", getHwToken());
		JSONObject json = new JSONObject();
		json.put("image_base64", imgBase);
		post.setEntity(new StringEntity(json.toString(), Charset.forName("utf-8")));
		try {
			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			System.out.println(str);
			JSONObject jsonRes = JSONObject.parseObject(str);
			JSONArray array = jsonRes.getJSONArray("faces");
			Map<Float, String> map = new HashMap<>();
			array.forEach(value -> {
				JSONObject jsonOb = (JSONObject) value;
				if (jsonOb.getFloat("similarity") > 0.90) {
					map.put(jsonOb.getFloat("similarity"), jsonOb.getString("external_image_id"));
				}
			});
			Set set = map.keySet();
			Object[] floats = set.toArray();
			Arrays.sort(floats);
			if (floats.length > 0) {
				util.setCode(0);
				util.setMsg(map.get(floats[0]));
				return util;
			} else {
				util.setCode(-1);
				util.setMsg("未识别到管理员");
				return util;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
			return ResultUtil.error();
		}

		return ResultUtil.error();

	}

	/**
	 * 活体检测 动作点头
	 * 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月11日上午10:55:57
	 * @param str
	 * @return
	 */
	public ResultUtil HwLiveDetect(String str) {
		String url = URISCHEME + "/v1/" + PROJECTID + "/live-detect";
		ResultUtil util = new ResultUtil();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		post.setHeader("X-Auth-Token", getHwToken());

		JSONObject json = new JSONObject();
		json.put("video_base64", str);
		json.put("actions", "3");
		post.setEntity(new StringEntity(json.toString(), Charset.forName("utf-8")));

		try {
			CloseableHttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			String str2 = EntityUtils.toString(entity);
			System.out.println(str2);
			JSONObject jsonRes = JSONObject.parseObject(str2);
			if (!jsonRes.getJSONObject("video-result").getBoolean("alive")) {
				util.setCode(-1);
				util.setMsg("活体检测失败");
				return util;
			}
			return ResultUtil.ok(jsonRes.getJSONObject("video-result").getString("picture"));
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return ResultUtil.ok();
	}

	/**
	 * 识别身份证正面照
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月15日上午11:11:15
	 * @param fontImg
	 * @return
	 */
	public ResultUtil HwIDCardOCRFront(String fontImg) {
		LjCardInfo cardInfo = new LjCardInfo();
		ResultUtil util  = new ResultUtil();
		String url = "https://ocr.cn-north-1.myhuaweicloud.com/v1.0/ocr/id-card";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		post.setHeader("X-Auth-Token", getHwToken());

		JSONObject json1 = new JSONObject();
		json1.put("image", fontImg);
		json1.put("side", "front");
		post.setEntity(new StringEntity(json1.toString(), Charset.forName("utf-8")));
		// front
		try {
			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			if (response.getStatusLine().getStatusCode() == 200) {
				System.out.println(str);
				JSONObject jsonObject = JSONObject.parseObject(str).getJSONObject("result");
				cardInfo.setIdCard(jsonObject.getString("number"));
				cardInfo.setName(jsonObject.getString("name"));
				cardInfo.setBirthday(jsonObject.getString("birth"));
				if (StringUtils.equals("男", jsonObject.getString("sex")))
					cardInfo.setGender(1);
				else
					cardInfo.setGender(2);
				cardInfo.setNation(jsonObject.getString("ethnicity"));
				cardInfo.setAddress(jsonObject.getString("address"));
				
				ResultUtil util2 = HwFaceDetectPosition(fontImg);
				
				if(util2.getCode() == 0){
					JSONObject jsonObject2 = JSONObject.parseObject(util2.getData().toString());
					int top_left_x = jsonObject2.getIntValue("top_left_x");
					int top_left_y = jsonObject2.getIntValue("top_left_y");
					int w  = jsonObject2.getIntValue("width");
					int h = jsonObject2.getIntValue("height");
					String  idPhoto = FileUtil.getInstance().cutImgByFacePosition(fontImg, top_left_x-25, top_left_y-25, w+50, h+50);
					cardInfo.setIdPhoto(idPhoto);
				}
					
				util.setCode(0);
				util.setData(cardInfo);
				return util;

			} else {
				return ResultUtil.error("服务器响应识别");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("服务器异常");
		}

	}
	
	/**
	 * 识别身份证背面
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月15日上午11:39:30
	 * @param backImg
	 * @return
	 */
	public ResultUtil HwIDCardOCRBack(String backImg) {
		LjCardInfo cardInfo = new LjCardInfo();
		ResultUtil util  = new ResultUtil();
		String url = "https://ocr.cn-north-1.myhuaweicloud.com/v1.0/ocr/id-card";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		post.setHeader("Content-type", "application/json");
		post.setHeader("X-Auth-Token", getHwToken());

		JSONObject json1 = new JSONObject();
		json1.put("image", backImg);
		json1.put("side", "back");
		post.setEntity(new StringEntity(json1.toString(), Charset.forName("utf-8")));
		// front
		try {
			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			if (response.getStatusLine().getStatusCode() == 200) {
				System.out.println(str);
				JSONObject jsonObject = JSONObject.parseObject(str).getJSONObject("result");
				cardInfo.setIdissue(jsonObject.getString("issue"));
				cardInfo.setIdBeginDate(jsonObject.getString("valid_from"));
				cardInfo.setIdEndDate(jsonObject.getString("valid_to"));
				
				util.setCode(0);
				util.setData(cardInfo);
				return util;

			} else {
				return ResultUtil.error("服务器响应失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error("服务器异常");
		}

	}

	static class test {
		public static void main(String[] args) {
			HwUtil.getInstance().HwDelFaceByExternalImgId("admin");
		}
	}
}
