package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;

public interface AccessoryService {

	public int addAccessory(List<Accessory> accessory);
	
	public int deleteAccessory(String id);
	
	public List<Accessory> selectAccessoryById(String id);
	
	public int deleteAccessoryByIdAndName(Accessory accessory);
	
	public List<Accessory> selectAccessoryByIdAndType(String id,String type);
	
}
