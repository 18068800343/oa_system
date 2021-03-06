package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Supplier;

public interface SupplierDao {

	public int addSupplier(@Param("supplier")Supplier supplier);
	
	public int deleteSupplier(@Param("id")String id);
	
	public int updateSupplier(@Param("supplier")Supplier supplier);
	
	public List<Supplier> selectAllSupplier();
	
	public List<Supplier> selectIdAndName();
	
	public Supplier selectOneSupplier(@Param("id")String id);
	
	public List<Supplier> selectSupplierByType(@Param("type")String type);
}
