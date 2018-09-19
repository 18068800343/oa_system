package org.ldxx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownLoad {
	
	@RequestMapping("/FileDownLoad")
	public void DownLoad(String filePath,String fileName,HttpServletResponse resp) throws IOException{
		File f=new File(filePath);
		//第一步：设置响应类型
	    resp.setContentType("application/force-download");//应用程序强制下载
	    //第二读取文件
	    InputStream in = new FileInputStream(filePath);
	    //设置响应头，对文件进行url编码
	    fileName = URLEncoder.encode(fileName, "UTF-8");
	    resp.setHeader("Content-Disposition", "attachment;filename="+fileName);   
	    resp.setContentLength(in.available());
	    
	    //第三步：老套路，开始copy
	    OutputStream out = resp.getOutputStream();
	    byte[] b = new byte[1024];
	    int len = 0;
	    while((len = in.read(b))!=-1){
	      out.write(b, 0, len);
	    }
	    out.flush();
	    out.close();
	    in.close();
		
	}

}
