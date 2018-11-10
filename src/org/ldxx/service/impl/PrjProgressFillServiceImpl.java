package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillCj;
import org.ldxx.bean.PrjProgressFillInfo;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.PrjProgressFillDao;
import org.ldxx.service.PrjProgressFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrjProgressFillServiceImpl implements PrjProgressFillService{

	@Autowired
	private PrjProgressFillDao dao;
	
	@Autowired
	private AccessoryDao aDao;
	
	@Transactional
	@Override
	public int addPrjProgressFill(PrjProgressFill ppf) {
		int i=dao.addPrjProgressFill(ppf);
		String id=ppf.getPpfId();
		if(i>0){
			List<PrjProgressFillInfo> ppfi=ppf.getPpfi();
			for(int a=0;a<ppfi.size();a++){
				ppfi.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi2=ppf.getPpfi2();
			for(int a=0;a<ppfi2.size();a++){
				ppfi2.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi3=ppf.getPpfi3();
			for(int a=0;a<ppfi3.size();a++){
				ppfi3.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi4=ppf.getPpfi4();
			for(int a=0;a<ppfi4.size();a++){
				ppfi4.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi5=ppf.getPpfi5();
			for(int a=0;a<ppfi5.size();a++){
				ppfi5.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi6=ppf.getPpfi6();
			for(int a=0;a<ppfi6.size();a++){
				ppfi6.get(a).setPpfId(id);
			}
			i=dao.addPrjProgressFillInfo(ppfi);
			i=dao.addPrjProgressFillInfo(ppfi2);
			i=dao.addPrjProgressFillInfo(ppfi3);
			i=dao.addPrjProgressFillInfo(ppfi4);
			i=dao.addPrjProgressFillInfo(ppfi5);
			i=dao.addPrjProgressFillInfo(ppfi6);
			List<PrjProgressFillCj>ppcj=ppf.getPpcj();
			for(int a=0;a<ppcj.size();a++){
				ppcj.get(a).setPpfId(id);
			}
			i=dao.addPrjProgressFillCj(ppcj);
			List<Accessory> accessory=ppf.getAccessory();
			if(accessory !=null){
				i=aDao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<PrjProgressFill> selectPrjProgressFill(String status) {
		return dao.selectPrjProgressFill(status);
	}

	@Override
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(String id, String type) {
		return dao.selectPrjProgressFillInfo(id, type);
	}

	@Override
	public PrjProgressFill selectPrjProgressFillById(String id) {
		return dao.selectPrjProgressFillById(id);
	}

	@Override
	public PrjProgressFill selectLastPrjProgressFill(String no) {
		return dao.selectLastPrjProgressFill(no);
	}

	@Override
	public PrjProgressFillInfo getLastByDepartmentAndId(String id, String department) {
		return dao.getLastByDepartmentAndId(id, department);
	}

	@Override
	public int addPrjProgressFillCj(List<PrjProgressFillCj> ppcj) {
		return dao.addPrjProgressFillCj(ppcj);
	}

	@Override
	public PrjProgressFillCj cjBq(String ppfId, String cjId) {
		return dao.cjBq(ppfId, cjId);
	}

	@Override
	public List<PrjProgressFillCj> selectPrjProgressFillCjById(String id) {
		return dao.selectPrjProgressFillCjById(id);
	}

	@Override
	public List<PrjProgressFill> selectPrjProgressFillByStatus(int status) {
		return dao.selectPrjProgressFillByStatus(status);
	}

	@Override
	public int updateStatusAndDesc(int status, String infos,String id) {
		return dao.updateStatusAndDesc(status, infos,id);
	}

}
