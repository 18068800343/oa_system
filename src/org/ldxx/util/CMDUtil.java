package org.ldxx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CMDUtil {
	
	
	public static String buildSqlBack(){
		String path = null;
		String date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		System.out.println(date);
		String basePath = new File(PropertiesUtil.getPropertiesByName("rootDir")).getPath()+File.separator;
		File file = new File(basePath, "backup");
		if(!file.exists()){
			file.mkdirs();
		}
		File backFile = new File(file, date+".sql");
		String op = ConfigInfo.dataBase+backFile.getAbsolutePath();
//		String op = "D:\\mysql-5.6.28-winx64\\bin\\mysqldump htbmssecond >d:\\qq q.sql";
		try {
			Process process = Runtime.getRuntime().exec("cmd.exe /c "+op);
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "GBK"));
			String line;
			  while((line = reader.readLine())!= null){
				   //System.out.println("111");
			  }
			  is.close();
			  if(process.exitValue()==0){
				  path = backFile.getAbsolutePath().replace(basePath, "");
			  }
		} catch (Exception e) {
			path = null;
			e.printStackTrace();
			
		}
		return path;
	}
	
	public static void main(String[] args){
		//buildSqlBack();
		//System.out.println(buildCard("G15320981L0080"));
		//buildCheck(prj_id, id, chk_type, direction, span)
		//CMDUtil.buildReport("5ae12893ba70494d880f13f8123d2911", "f76580f37a1c47db9443bee730be63e1", "bridge", "regular", "[{'arg':'1+5+2+3+6+4'},{'span':'1-2'}]");
		
	}}
