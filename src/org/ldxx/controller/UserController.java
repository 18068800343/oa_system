package org.ldxx.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.User;
import org.ldxx.bean.outRemain;
import org.ldxx.dao.UserDao;
import org.ldxx.service.UserService;
import org.ldxx.util.BeanUtil;
import org.ldxx.util.CMDUtil;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Decoder;

//import sun.misc.BASE64Encoder;

/**
 * 人员用户管理
 * @author hp
 *
 */
@RequestMapping("user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private UserDao userDao;
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String,Object> addUser(User user,@RequestParam("file") MultipartFile [] file) throws Exception{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		user.setUserId(id);
		int count=userservice.countuserCode();
		user.setUserCode(uuid.getUserCode(count+1));
		
		String path = "D:"+File.separator+"oa"+File.separator+"user"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("行业相关证书");
				list.add(accessory);
			}
			user.setAccessory(list);
		}
		
		int i = userservice.countOfusername(user.getUsername());
		if(i>0){/*用户名已存在*/
			i= -2;
		}
		
		String workId = user.getWorkId();
		int j=0;
		if(null!=workId&&!"".equals(workId.trim())){
			 j = userservice.countOfworkId(workId);
		}
		if(j>0){/*工号已存在*/
			i= -3;
		}
		
		String recordNo = user.getRecordNo();
		int k=0;
		if(null!=recordNo&&!"".equals(recordNo.trim())){
			 k= userservice.countOfrecordNo(recordNo);
		}
		
		
		if(k>0){/*档案号已存在*/
			i= -4;
		}
		if(i>=0&&j>=0&&k>=0){
			i = userservice.addUser(user);
		}
		map.put("result", i);
		map.put("user", user);
		return map;
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public int deleteUser(String userId){
		return userservice.deleteUser(userId);
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(User user,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		String id = user.getUserId();
		String path = "D:"+File.separator+"oa"+File.separator+"user"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("行业相关证书");
				list.add(accessory);
			}
			user.setAccessory(list);
		}
		
		int i = userservice.countOfusernameEdit(user.getUsername(),user.getUserId());
		if(i>0){/*用户名已存在*/
			i= -2;
		}
		int j = userservice.countOfworkIdEdit(user.getWorkId(),user.getUserId());
		if(j>0){/*工号已存在*/
			i= -3;
		}
		int k = userservice.countOfrecordNoEdit(user.getRecordNo(),user.getUserId());
		if(k>0){/*档案号已存在*/
			i= -4;
		}
		if(i>=0&&j>=0&&k>=0){
			i= userservice.updateUser(user);
		}
		map.put("result", i);
		map.put("user", user);
		return map;
	}

	@RequestMapping("/selectAllUser")
	@ResponseBody
	public String selectAllUser(HttpServletResponse response) throws IOException{
		List<User> list= userservice.selectAllUser();
		net.sf.json.JSONArray json = new net.sf.json.JSONArray();
		 json.addAll(list);
		 String str = json.toString();
		 str = str.replaceAll("password", "mima");
		 return str;
		
	}
	//解决网络上传输数据会导致只传输一半，前台接收不完整的问题。后台先base64编码，前台再base64解码，参考前台代码页面personneManagement。html
	@RequestMapping("/selectAllUser3")
	@ResponseBody
	public String selectAllUser3(HttpServletResponse response) throws IOException{
		List<User> list= userservice.selectAllUser();
		//JSONArray json= new JSONArray(list);
		net.sf.json.JSONArray json = new net.sf.json.JSONArray();
		json.addAll(list);
		String str = json.toString();
		
		byte[] buf=str.getBytes("utf8");		
	 
		String encodeStr3 = org.apache.commons.codec.binary.Base64.encodeBase64String(buf);
		
		//下面方法服务器会报错
		//BASE64Encoder base64 = new BASE64Encoder();
		//String encodeStr3 = base64.encode(buf);	    
	    
	    return encodeStr3;
        
       			
	}
	
	
	
	@RequestMapping("/selectUserById")
	@ResponseBody
	public User selectUserById(String userId){
		return userservice.selectUserById(userId);
	}
	
	@RequestMapping("/getHDSpace")
	@ResponseBody
	public Map<String, String> getHDSpace(String pan){
		return CMDUtil.getHDSpace(pan);
	}
	
	@RequestMapping("/selectUserByomId")
	@ResponseBody
	public String selectUserByomId(String omId){
	 List<User> list = userservice.selectUserByomId(omId);
	 net.sf.json.JSONArray json = new net.sf.json.JSONArray();
	 json.addAll(list);
	 String str = json.toString();
	 str = str.replaceAll("password", "mima");	 
	 return str;
	}
	
	@RequestMapping("/selectUserByomIdYY")
	@ResponseBody
	public List<User> selectUserByomIdYY(String omId,String type){
		String iString = "1";
		if("3".equals(type)){
			List<User> list = userservice.selectUserByomId(omId);
			return list;
		}else{
			if("1".equals(type)){
				String names[] = {"主任工程师","部门经理"};
				return userservice.selectUserByomIdByJobFirstNames(names);
			}else{
				String names[] = {"总工程师"};
				return userservice.selectUserByomIdByJobFirstNames(names);
			}
		}
	}
	
	@RequestMapping("/selectUserAndRoles")
	@ResponseBody
	public String selectUserAndRoles() throws UnsupportedEncodingException{
		List<User> list =userservice.selectUserAndRoles();
		net.sf.json.JSONArray json = new net.sf.json.JSONArray();
		 json.addAll(list);
		 String str = json.toString();
		 
		 byte[] buf=str.getBytes("utf8");		
		String encodeStr3 = org.apache.commons.codec.binary.Base64.encodeBase64String(buf);
		 return encodeStr3;
		
	}
	
	@RequestMapping("/selectFgldByRoleName")
	@ResponseBody
	public List<User> selectFgldByRoleName(){
		List<User> list = userDao.selectFgldByRoleName("分管领导");
		for(User user:list){
			String userRole = user.getUserRole();
			String flowOmNo = BeanUtil.getOmNoByUserRole(userRole, "r02*.");
			user.setFlowOmNo(flowOmNo);
		}
		return list;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/updatePasswordById")
	@ResponseBody
	public int updatePasswordById(String userId,String password){
		String old_password = password.split(",")[0];
		String new_password = password.split(",")[1];
		User user = userservice.selectUserById(userId);
		int i=0;
		if(!user.getPassword().equals(old_password)){
			i=-1;
		}else if(user.getPassword().equals(new_password)){
			i=-2;
		}else{
			i=userservice.updatePasswordById(userId,new_password);
		}
		return i;
	}
	
	@RequestMapping("/selectGCSByDept")
	@ResponseBody
	public List<User> selectGCSByDept(String omId){
		String name="%主任工程师%";
		List<User> list=userservice.selectGCSByDept(omId,name);
		return list;
	}
	
	@RequestMapping("/testUrl")
	@ResponseBody
	public String testUrl(@RequestBody String str){
		JSONObject json = JSON.parseObject(str);
		String name = json.getString("str");
		String strs = URLDecoder.decode(name);
		String ur = str;
		return ur;
	}
	
	
	public static String getFromBASE64(String str) {
	  if (str == null)
	   return null;
	  BASE64Decoder decoder = new BASE64Decoder();
	  try {
	   byte[] b = decoder.decodeBuffer(str);
	   return new String(b);
	  } catch (Exception e) {
	   return null;
	  }
	  
	}
	
	//BASE64编码
	public static String getBASE64(String str) {
	  if (str == null)
	   return null;
	  return (new sun.misc.BASE64Encoder()).encode(str.getBytes());
	}
	
	public static void main(String[] args) {
	  String strs = getBASE64("张三");
		String str = getFromBASE64(strs);
		System.out.println(str);
	}
}
