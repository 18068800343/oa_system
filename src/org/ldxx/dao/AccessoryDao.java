package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;

public interface AccessoryDao {
	
	public int addAccessory(@Param("accessory")List<Accessory> accessory);
	
	public int deleteAccessory(@Param("id")String id);
	
	public List<Accessory> selectAccessoryById(@Param("id")String id);
	
	public int deleteAccessoryByIdAndName(@Param("accessory")Accessory accessory);
	
	public int deleteAccessoryByIdAndAType(@Param("accessory")Accessory accessory);
	
	public List<Accessory> selectAccessoryByIdAndType(@Param("id")String id,@Param("type")String type);
	
	public int fileCount(@Param("id")String id);
	
	public Accessory getAccessByIdAndName(@Param("id")String id,@Param("acName")String acName);
    
}