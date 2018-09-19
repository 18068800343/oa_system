package org.ldxx.util;

import javax.servlet.http.HttpServletRequest;

public class BasePathUtil {

	public static String getBasePath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath; 
	}
}
