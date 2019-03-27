package org.ldxx.util;

import javax.servlet.http.HttpServletRequest;

public class BasePathUtil {

	public static String getBasePath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath; 
	}
	
	public static void main(String[] args) {
		System.out.println(984400-909500);
	}
}
