package org.ldxx.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyFile {
	
	/** 
	* 复制单个文件 到指定文件夹下
	* @param oldPath String 原文件路径 如：E:\apache-tomcat-8.0.36\webapps\oa_file\4ef548b6636a\a.txt 
	* @param newPath String 复制后路径 如：E:\apache-tomcat-8.0.36\webapps\oa_file\4ef548b6636a
	* @return boolean 
	*/ 
	public static void copyFile(String oldPath, String newPath){
		// 源文件
        File source = new File(oldPath);
        // 要复制去的文件夹地址
        File target = new File(newPath);
		try {
			FileUtils.copyFileToDirectory(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
