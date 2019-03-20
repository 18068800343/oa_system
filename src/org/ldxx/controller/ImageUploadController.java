package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("kindeditor")
public class ImageUploadController {
	
	/*@RequestMapping("/upload")//上传图片
	public void upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 //设置Response响应的编码
        resp.setContentType("text/html; charset=UTF-8");


        //获取一个Response的Write对象
        PrintWriter writer = resp.getWriter();


        //文件保存目录路径
        String savePath = req.getRealPath("/") + "attached/";
        System.out.println(savePath);

        //文件保存目录URL
        String saveUrl = req.getContextPath() + "/attached/";
        System.out.print(saveUrl);

        //定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");


        //最大文件大小
        long maxSize = 1000000;


        //判断是否是一个文件
        if (!ServletFileUpload.isMultipartContent(req)) {
            writer.println(getError("请选择文件。"));
            return;
        }
        //检查目录
        File uploadDir = new File(savePath);
        if (!uploadDir.isDirectory()) {
            writer.println(getError("上传目录不存在。"));
            return;
        	uploadDir.mkdirs();
        }
        //检查目录写权限
        if (!uploadDir.canWrite()) {
            writer.println(getError("上传目录没有写权限。"));
            return;
        }

        String dirName = req.getParameter("dir");
        if (dirName == null) {
            dirName = "image";
        }
        if (!extMap.containsKey(dirName)) {
            writer.println(getError("目录名不正确。"));
            return;
        }


        //创建文件夹
        savePath += dirName + "/";
        saveUrl += dirName + "/";
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        savePath += ymd + "/";
        saveUrl += ymd + "/";
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        DefaultMultipartHttpServletRequest servletRequest = (DefaultMultipartHttpServletRequest) req;
        Iterator<String> itr = servletRequest.getFileNames();
        //Iterator itr = items.iterator();
        while (itr.hasNext()) {
            //FileItem item = (FileItem) itr.next();
        	//String fileName = item.getName();
        	MultipartFile item = servletRequest.getFile(itr.next());
        	String fileName = item.getOriginalFilename();
            //long fileSize = item.getSize();
            //if (!((FileItem) item).isFormField()) {
                //检查文件大小
                if (item.getSize() > maxSize) {
                    writer.println(getError("上传文件大小超过限制。"));
                    return;
                }
                //检查扩展名
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
                    writer.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
                    return;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
                try {
                    File uploadedFile = new File(savePath, newFileName);
                    //item.write(uploadedFile);
                    item.transferTo(uploadedFile);
                } catch (Exception e) {
                    writer.println(getError("上传文件失败。"));
                    return;
                }

                JSONObject obj = new JSONObject();
                obj.put("error", 0);
                obj.put("url", saveUrl + newFileName);
                writer.println(obj.toString());
           // }
        }


        //将writer对象中的内容输出
        writer.flush();
        //关闭writer对象
        writer.close();
	}
	
	
	
	 @RequestMapping("/Manager")//上传文件
	    public void fileManager(HttpServletRequest request, HttpServletResponse response){
	        PrintWriter out = null;
	        try {
	            out = response.getWriter();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        //根目录路径
	        String rootPath = request.getRealPath("/") + "attached/";
	        //根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/
	        String rootUrl  = request.getContextPath() + "/attached/";
	        //图片扩展名
	        String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

	        //要打开的文件夹
	        String dirName = request.getParameter("dir");
	        if (dirName != null) {
	            if(!Arrays.<String>asList(new String[]{"image", "flash", "media", "file"}).contains(dirName)){
	                out.println("无效的目录");
	                return;
	            }
	            rootPath += dirName + "/";
	            rootUrl += dirName + "/";
	            File saveDirFile = new File(rootPath);
	            if (!saveDirFile.exists()) {
	                saveDirFile.mkdirs();
	            }
	        }
	        //根据path参数，设置各路径和URL
	        String path = request.getParameter("path") != null ? request.getParameter("path") : "";
	        String currentPath = rootPath + path;
	        String currentUrl = rootUrl + path;
	        String currentDirPath = path;
	        String moveupDirPath = "";
	        if (!"".equals(path)) {
	            String str = currentDirPath.substring(0, currentDirPath.length() - 1);
	            moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
	        }

	        //排序形式，name or size or type
	        String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

	        //不允许使用..移动到上一级目录
	        if (path.indexOf("..") >= 0) {
	            out.println("Access is not allowed.");
	            return;
	        }
	        //最后一个字符不是/
	        if (!"".equals(path) && !path.endsWith("/")) {
	            out.println("Parameter is not valid.");
	            return;
	        }
	        //目录不存在或不是目录
	        File currentPathFile = new File(currentPath);
	        if(!currentPathFile.isDirectory()){
	            out.println("Directory does not exist.");
	            return;
	        }

	        //遍历目录取的文件信息
	        List<Hashtable> fileList = new ArrayList<Hashtable>();
	        if(currentPathFile.listFiles() != null) {
	            for (File file : currentPathFile.listFiles()) {
	                Hashtable<String, Object> hash = new Hashtable<String, Object>();
	                String fileName = file.getName();
	                if(file.isDirectory()) {
	                    hash.put("is_dir", true);
	                    hash.put("has_file", (file.listFiles() != null));
	                    hash.put("filesize", 0L);
	                    hash.put("is_photo", false);
	                    hash.put("filetype", "");
	                } else if(file.isFile()){
	                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	                    hash.put("is_dir", false);
	                    hash.put("has_file", false);
	                    hash.put("filesize", file.length());
	                    hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
	                    hash.put("filetype", fileExt);
	                }
	                hash.put("filename", fileName);
	                hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
	                fileList.add(hash);
	            }
	        }

	        if ("size".equals(order)) {
	            Collections.sort(fileList, new SizeComparator());
	        } else if ("type".equals(order)) {
	            Collections.sort(fileList, new TypeComparator());
	        } else {
	            Collections.sort(fileList, new NameComparator());
	        }
	        JSONObject result = new JSONObject();
	        result.put("moveup_dir_path", moveupDirPath);
	        result.put("current_dir_path", currentDirPath);
	        result.put("current_url", currentUrl);
	        result.put("total_count", fileList.size());
	        result.put("file_list", fileList);

	        response.setContentType("application/json; charset=UTF-8");
	        out.println(result.toString());
	    }

	
	
	 //一个私有的方法，用于响应错误信息
    private String getError(String message) {
        JSONObject obj = new JSONObject();
        obj.put("error", 1);
        obj.put("message", message);
        return obj.toString();
    }
    
    public class NameComparator implements Comparator {
    	public int compare(Object a, Object b) {
    		Hashtable hashA = (Hashtable)a;
    		Hashtable hashB = (Hashtable)b;
    		if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
    			return -1;
    		} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
    			return 1;
    		} else {
    			return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
    		}
    	}
    }
    public class SizeComparator implements Comparator {
    	public int compare(Object a, Object b) {
    		Hashtable hashA = (Hashtable)a;
    		Hashtable hashB = (Hashtable)b;
    		if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
    			return -1;
    		} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
    			return 1;
    		} else {
    			if (((Long)hashA.get("filesize")) > ((Long)hashB.get("filesize"))) {
    				return 1;
    			} else if (((Long)hashA.get("filesize")) < ((Long)hashB.get("filesize"))) {
    				return -1;
    			} else {
    				return 0;
    			}
    		}
    	}
    }
    public class TypeComparator implements Comparator {
    	public int compare(Object a, Object b) {
    		Hashtable hashA = (Hashtable)a;
    		Hashtable hashB = (Hashtable)b;
    		if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
    			return -1;
    		} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
    			return 1;
    		} else {
    			return ((String)hashA.get("filetype")).compareTo((String)hashB.get("filetype"));
    		}
    	}
    }*/
}
