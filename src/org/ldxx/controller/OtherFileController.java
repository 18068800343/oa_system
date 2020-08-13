package org.ldxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.ldxx.bean.OtherFile;
import org.ldxx.bean.User;
import org.ldxx.service.OtherFileService;
import org.ldxx.util.TimeUUID;
import com.alibaba.fastjson.JSONObject;
@Controller
@RequestMapping("otherFile")
public class OtherFileController {

	@Autowired
	private OtherFileService ofService;
	
	@RequestMapping("/addFileUpload")
	@ResponseBody
	public Map<String,Object> addOtherFile(@RequestParam(value="file") MultipartFile [] file,String fileJson,HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		TimeUUID tu=new TimeUUID();
		int result;
		JSONObject jsonObject=JSONObject.parseObject(fileJson);
		OtherFile oFile=(OtherFile)JSONObject.toJavaObject(jsonObject, OtherFile.class);
		
		//获取tomcat项目路径
//		String path = request.getSession().getServletContext().getRealPath("/")+"otherfile";
		String id = tu.getTimeUUID();
		oFile.setFileId(id);
		//如果时间为空，则取当前时间的年月 
		if(null==oFile.getFileDate()||"".equals(oFile.getFileDate()))
		{
			int year,month,day;
			String yearAndMonth;
			Calendar cal=Calendar.getInstance();   
			year=cal.get(Calendar.YEAR);   
			month=cal.get(Calendar.MONTH)+1;
			day=cal.get(Calendar.DATE);
			yearAndMonth=year+"-"+(month>9?month:"0"+month)+"-"+day;
			oFile.setFileDate(yearAndMonth);
		}
		String webApps=tu.getWebAppFile();
		String path=webApps+id;
		File filePath=new File(path);
		//路径文件夹不存在的话创建路径中所有文件夹
		if(!filePath.exists())
		{
			filePath.mkdirs();
		}
		
		//如果自定的文件名为空，则将原文件名设定为新文件
		String fileName =file[0].getOriginalFilename();
		String suffix = "."+fileName.substring(fileName.lastIndexOf(".") + 1);
		
		if(null==oFile.getFileName()||"".equals(oFile.getFileName())){
			oFile.setFileName(fileName);
		}else{
			oFile.setFileName(oFile.getFileName()+suffix);
		}
		File newFile = new File(filePath+"\\"+oFile.getFileName());
		oFile.setFileUrl(newFile.getAbsolutePath());
		//从session中获取并设置用户ID
		User user = (User)request.getSession().getAttribute("user");
		if(null==user){
			result=-2; //没有取到用户信息
			map.put("result", result);
			return map;
		}
		oFile.setFileUser(user.getUserId());
		try {
			//写入文件
			file[0].transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		result = ofService.insertOtherFile(oFile);
		oFile.setFileUser(user.getuName());
		map.put("result", result);
		map.put("OtherFile", oFile);
		String otherFileUrl = oFile.getFileUrl().split("webapps")[1].replaceAll("\\\\", "/");
		map.put("otherFileUrl", otherFileUrl);
		return map;
	}
	
	@RequestMapping("/showFileList")
	@ResponseBody
	public List<OtherFile> selectAllOtherFile(HttpServletRequest request){
//	Map<String,Object> map=new HashMap<>();
//		User user = (User)request.getSession().getAttribute("user");
		String requestUrl = request.getRequestURL()+"";
		//获取访问的网址路径：
		//例如：http://127.0.0.1:8080/oa_system/otherFile/showFileList
		//转换之后的数据http://127.0.0.1:8080
		//OtherFile转换之前 D:\\work\\apache-tomcat-8.5.27\\webapps\\oa_file\\421a2ab34e0c\\aaa.xml
		//OtherFile转换后的url  /oa_file/421a2ab34e0c/aaa.xml
		requestUrl = requestUrl.split("/")[0]+"//"+requestUrl.split("/")[2];
		List<OtherFile> list=ofService.selectAllOhterFile();
		String url;
		for(int i=0;i<list.size();i++){
			url=list.get(i).getFileUrl();
			list.get(i).setFileUrl(url.split("webapps")[1].replaceAll("\\\\", "/"));				
		}

//		map.put("list", list);
//		map.put("username", user.getuName());
		return list;
	}
	
	@RequestMapping("/deleteFile")
	@ResponseBody
	public int deleteOtherFile(String fileId){
		int status=0;
		OtherFile of = ofService.selectOtherFileById(fileId);
		File file = new File(of.getFileUrl());
		status =ofService.deleteOtherFileById(fileId);
		file.delete();
		//删除文件所在的目录，如果有文件则不删除文件夹
		File filedir = file.getParentFile();
		File[] listFiles = filedir.listFiles();  
		if(listFiles.length > 0){  
			return status;
		} else {  
			file.getParentFile().delete();
		}  
		return status;
	}
}



