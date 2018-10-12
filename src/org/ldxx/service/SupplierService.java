package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Supplier;

public interface SupplierService {

	public int addSupplier(Supplier supplier);
	
	public int deleteSupplier(String id);
	
	public int updateSupplier(Supplier supplier);
	
	public List<Supplier> selectAllSupplier();
	
	public List<Supplier> selectIdAndName();
	
	public Supplier selectOneSupplier(String id);
}
