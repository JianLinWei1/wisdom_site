package com.jian.util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;
import com.biology.entity.LjFeature;
import com.biology.face.FaceApi;
import com.biology.face.FaceApiImpl;

public class FileUtil {
  static Logger  logger  =  LoggerFactory.getLogger(FileUtil.class);
  
  private static FileUtil fileUtil;
  private FileUtil(){
	  
  }
  public static synchronized FileUtil getInstance(){
	  if(fileUtil == null)
		  return new FileUtil();
	  return fileUtil;
  }
	
	/**
	 * 获取文件夹路径 
	 * @Title: getMidkirs   
	 * @Description: TODO   
	 * @param: @param path
	 * @param: @return
	 * @param: @throws FileNotFoundException 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public   String getMidkirs(String path) throws FileNotFoundException{
		 File  file;
		try{
			  //file  =new File(ResourceUtils.getFile("classpath:").getPath() +"/upload/" +path) ;
			  file = new File("D:/upload/"+path);
			 if(!file.exists())
				 file.mkdirs();
			 return file.getPath();
		}catch(Exception e){
			logger.debug("获取文件目录："+e.getMessage());
		    file  = new File(System.getProperty("user.dir")+"/upload/"+path);
		    if(!file.exists())
		    	file.mkdirs();
		    return file.getPath();
		}
	}
	
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 添加照片到文件夹
	 * @Title: addPicture2Midkirs   
	 * @Description: TODO   
	 * @param: @param file
	 * @param: @param name
	 * @param: @param path 方便不同的数据分开文件夹存放
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public   String   addPicture2Midkirs(byte[] pic , String name , String path ) throws IOException{
		name = name+"_"+UuidUtil.getUUID()+".jpg";
		String path2 = getMidkirs(path);
		File file  =  new File(path2+"/"+name);
		if(!file.exists())
			file.createNewFile();
		OutputStream outputStream  = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		bufferedOutputStream.write(pic,0,pic.length);
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		
		return file.toURI().toString().substring(file.toURI().toString().indexOf(path)-1);
		
	}
	
	/**
	 * @throws IOException 
	 * 从文件夹获取照片
	 * @Title: getPicture2Byte   
	 * @Description: TODO   
	 * @param: @param filename
	 * @param: @param path
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: byte[]      
	 * @throws
	 */
	public    byte[]  getPicture2Byte(String filename) throws IOException{
		String path = getMidkirs(filename) ;
		File  file  = new File(path);
		if(file.exists()){
		InputStream inputStream = new FileInputStream(file);
		byte[]  buf   = new byte[inputStream.available()];
		inputStream.read(buf);
		inputStream.close();
		return buf;
		}
		
		return null;
	}
	
	
	/**
	 * 带去空格
	 * @Title: Base642Byte   
	 * @Description: TODO   
	 * @param: @param base64
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: byte[]      
	 * @throws
	 */
	public  byte[]  Base642Byte(String base){
		if(StringUtils.isEmpty(base))
			return null;
		base =  base.replaceAll("[\\s*\t\n\r]", "");
		if(base.contains("data:image/jpeg;base64,"))
			base = base.replace("data:image/jpeg;base64,", "");
		if(base.contains("data:image/png;base64,"))
			base = base.replace("data:image/png;base64,", "");
		Base64.Decoder decoder  = Base64.getDecoder();
		if(StringUtils.isNotEmpty(base))
			return decoder.decode(base);
		return null;
		
	}
	
	public  String  Base642NoHead(String base){
		if(StringUtils.isEmpty(base))
			return null;
		base =  base.replaceAll("[\\s*\t\n\r]", "");
		if(base.contains("data:image/jpeg;base64,"))
			base = base.replace("data:image/jpeg;base64,", "");
		if(base.contains("data:image/png;base64,"))
			base = base.replace("data:image/png;base64,", "");
		
		return base;
		
	}
	
	/**
	 * 
	 * @Title: img_base64_head   
	 * @Description: TODO   
	 * @param: @param base
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public   String  img_base64_head(byte[] base){
		Base64.Encoder  encoder  = Base64.getEncoder();
		if(base != null)
			return "data:image/jpeg;base64," + encoder.encodeToString(base) ;
		return null;
		
	}
	
	
	public  String  getJsonFile(String filename){
		try{
		File file = new File(getMidkirs("config/")+"/"+filename);
		String str  =FileUtils.readFileToString(file, "utf-8");
		return str;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 将特征值存文件
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月11日下午6:22:34
	 * @param feature
	 * @param name
	 * @param path "/"
	 * @return
	 * @throws IOException
	 */
	public String addFeature2File(byte[] feature ,String name , String path) throws IOException{
		name = name+"_"+UuidUtil.getUUID();
		String path2 = getMidkirs(path);
		File file  =  new File(path2+"/"+name);
		if(!file.exists())
			file.createNewFile();
		OutputStream outputStream  = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		bufferedOutputStream.write(feature,0,feature.length);
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		return file.toURI().toString().substring(file.toURI().toString().indexOf(path)-1);
	}
	
	/**
	 * 根据人脸位置裁剪图片
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月15日上午11:31:10
	 * @param faceImg
	 * @param top_left_x
	 * @param top_left_y
	 * @param w
	 * @param h
	 * @return
	 * @throws IOException 
	 */
	public String cutImgByFacePosition(String faceImg ,int top_left_x , int top_left_y  , int w ,int h) throws IOException{
		InputStream  inputStream = new ByteArrayInputStream(Base642Byte(faceImg));
		ImageInputStream  iis  = ImageIO.createImageInputStream(inputStream);
		ImageReader  ir  = ImageIO.getImageReadersBySuffix("jpg").next();
		ir.setInput(iis, true);
		ImageReadParam  irp  = ir.getDefaultReadParam();
		
		Rectangle   rec   = new Rectangle(top_left_x,top_left_y,w ,h);
		irp.setSourceRegion(rec);
		BufferedImage  bf =ir.read(0, irp);
		ByteArrayOutputStream  bytearray  = new ByteArrayOutputStream();
		ImageIO.write(bf, "jpg", bytearray);
		return img_base64_head(bytearray.toByteArray());
		
	}
	/**
	 * 20010101-20110101 转换成都智慧工地平台身份证有效期需要的格式 
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月16日下午4:15:11
	 * @param idBeginDate
	 * @param idEndDate
	 * @return
	 */
	public  String  stringFormat(String  idBeginDate , String idEndDate){
		idBeginDate = idBeginDate.replace("-", "");
		idEndDate = idEndDate.replace("-", "");
		return idBeginDate+"-"+idEndDate;
		
	}
	
	public static void main(String[] args) {
		FileUtil.getInstance().Base642NoHead("2     2");
	}
}
