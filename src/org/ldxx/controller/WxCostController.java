package org.ldxx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.WxCost;
import org.ldxx.service.WxCostService;
import org.ldxx.util.ImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("wx")
public class WxCostController {

	@Autowired
	private WxCostService wxService;
	
	@RequestMapping("/addWxCost")
	@ResponseBody
	public Map<String,Object> addWxCost(@RequestParam("file2") MultipartFile file2,HttpServletResponse response,HttpSession session) throws IOException{
		Map<String,Object> map=new HashMap<>();
		InputStream is=file2.getInputStream();
		ImportData imp=new ImportData();
		List<WxCost> list=imp.readXls3(is);
		int i=wxService.addWxCost(list);
		map.put("result", i);
		map.put("wx", list);
		return map;
	}
	
	@RequestMapping("/selectWxCost")
	@ResponseBody
	public List<WxCost> selectWxCost(){
		List<WxCost> list=wxService.selectAllWxCost();
		return list;
	}
	
}
