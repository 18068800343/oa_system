package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Eva;
import org.ldxx.bean.Supplier;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.SupplierDao;
import org.ldxx.service.SupplierService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private EnterpriseDao eDao;
	
	@Autowired
	private SupplierDao sDao;
	
	@Transactional
	@Override
	public int addSupplier(Supplier supplier) {
		TimeUUID uuid=new TimeUUID();
		List<Enterprise> enterprise=supplier.getEnterprise();
		String id=uuid.getTimeUUID();
		supplier.setSpId(id);
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(id);
		}
		int i=sDao.addSupplier(supplier);
		if(i>0){
			if(enterprise.size()!=0&&enterprise!=null){
				i=eDao.addEnterprise(enterprise);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteSupplier(String id) {
		int i=eDao.deleteEnterprise(id);
		if(i>0){
			i=sDao.deleteSupplier(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateSupplier(Supplier supplier) {
		int i=eDao.deleteEnterprise(supplier.getSpId());
		List<Enterprise> enterprise=supplier.getEnterprise();
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(supplier.getSpId());
		}
		if(i>0){
			i=sDao.updateSupplier(supplier);
			if(i>0){
				if(enterprise.size()!=0){
					i=eDao.addEnterprise(enterprise);
				}
			}
		}
		return i;
	}

	@Override
	public List<Supplier> selectAllSupplier() {
		return sDao.selectAllSupplier();
	}

	@Transactional
	@Override
	public Supplier selectOneSupplier(String id) {
		Supplier supplier=sDao.selectOneSupplier(id);
		List<Enterprise> enterprise=eDao.selectEnterpriseById(id);
		supplier.setEnterprise(enterprise);
		
/*		List<Eva> eva=new ArrayList<>();
		Eva a=new Eva();
		eva.add(a);
		supplier.setEnterpriseEva(eva);*/
		
		return supplier;
	}

	@Override
	public List<Supplier> selectIdAndName() {
		return sDao.selectIdAndName();
	}

	@Override
	public List<Supplier> selectSupplierByType(String type) {
		return sDao.selectSupplierByType(type);
	}

}
