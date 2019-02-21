package org.ldxx.controller;

import java.io.IOException;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.service.AccessoryService;
import org.ldxx.util.ceshi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/accessory")
@Controller
public class AccessoryController {

	@Autowired
	private AccessoryService service;
	
	@RequestMapping("/addAccessory")
	@ResponseBody
	public int addAccessory(List<Accessory> accessory){
		int i=service.addAccessory(accessory);
		return i;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(String id){
		int i=service.deleteAccessory(id);
		return i;
	}
	
	@RequestMapping("/deleteAccessoryByIdAndName")
	@ResponseBody
	public int deleteAccessoryByIdAndName(Accessory accessory){
		int i=service.deleteAccessoryByIdAndName(accessory);
		return i;
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> accessory=service.selectAccessoryById(id);
		return accessory;
	}
	
	@RequestMapping("/selectAccessoryByIdAndType")
	@ResponseBody
	public List<Accessory> selectAccessoryByIdAndType(String id,String type){
		List<Accessory> accessory=service.selectAccessoryByIdAndType(id, type);
		return accessory;
	}
	
}
