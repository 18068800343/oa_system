package org.ldxx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;



public class PropertiesUtil {
	
	/**
	 * 通过名称获取properties文件value
	 * @author 不想要晴天
	 * @param String name
	 * @return String value
	 */
	public static String getPropertiesByName(String name){
		String value = "";
		String path = new PropertiesUtil().getClass().getResource("/").toString().substring(6);
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		File file = new File(path, "config.properties");
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(inStream);
			inStream.close();
			value = properties.getProperty(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * 获取Properties文件所有键值对
	 * @author 不想要晴天
	 * @return Map<String, String>
	 */
	public static Map<String, String> getPropertiesAll(){
		Map<String, String> map = new HashMap<String,String>();
		String path = new PropertiesUtil().getClass().getResource("/").toString().substring(6);
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		File file = new File(path, "config.properties");
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(inStream);
			inStream.close();
			for(Object obj:properties.keySet()){
				String key = (String)obj;
				map.put(key, properties.getProperty(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
