package org.ldxx.service.impl;

import java.io.File;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.PrjWorkingHoursDao;
import org.ldxx.dao.PrjWorkingHoursPDao;
import org.ldxx.service.PrjWorkingHoursService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrjWorkingHoursServiceImpl implements PrjWorkingHoursService {

	
	@Autowired
	private PrjWorkingHoursDao dao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private PrjWorkingHoursPDao pdao;
	
	@Override
	public int addPrjWorkingHoursSave(PrjWorkingHours pwh) {
		int i=dao.addPrjWorkingHoursSave(pwh);
		if(i>0){
			List<Accessory> accessory=pwh.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<PrjWorkingHoursP> hoursP = pwh.getPrjWorkingHoursP();
			String gsId = pwh.getPwhId();
			TimeUUID uuid=new TimeUUID();
			for(int j=0;j<hoursP.size();j++){
				hoursP.get(j).setGsId(uuid.getTimeUUID());
				hoursP.get(j).setPrjGsId(gsId);
			}
			if(hoursP!=null && hoursP.size()>0){
				i=pdao.addPrjWorkingHoursP(hoursP);
			}
		}
		return i;
	}

	@Override
	public List<PrjWorkingHours> selectPrjWorkingHours() {
		List<PrjWorkingHours> list=dao.selectPrjWorkingHours();
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getPwhId();
			List<PrjWorkingHoursP> p=pdao.selectByprjgsid(id);
			list.get(i).setPrjWorkingHoursP(p);
		}
		return list;
	}

	@Override
	public int deletePrjWorkingHours(String id) {
		int i=dao.deletePrjWorkingHours(id);
		if(i>0){
			List<PrjWorkingHoursP> list2 = pdao.selectByprjgsid(id);
			if(list2.size()>0){
				i=pdao.deleteByprjgsid(id);
			}
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
				if(i>0){
					String path="D:"+File.separator+"oa"+File.separator+"PrjWorkingHours"+File.separator+id;
					File f=new File(path);
					String[]  tempList  =  f.list();
					for(int a=0;a<tempList.length;a++){
						String path2=path+File.separator+tempList[a];
						File f2=new File(path2);
						f2.delete();
					}
					f.delete();
				}
			}
		}
		return i;
	}

	@Override
	public int updatePrjWorkingHoursSave(PrjWorkingHours pwh) {
		int i=dao.updatePrjWorkingHoursSave(pwh);
		if(i>0){
			List<Accessory> accessory=pwh.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			i=pdao.deleteByprjgsid(pwh.getPwhId());
			List<PrjWorkingHoursP> hoursP = pwh.getPrjWorkingHoursP();
			TimeUUID uuid=new TimeUUID();
			for(int j=0;j<hoursP.size();j++){
				hoursP.get(j).setGsId(uuid.getTimeUUID());
				hoursP.get(j).setPrjGsId(pwh.getPwhId());
			}
			if(hoursP!=null&&hoursP.size()>0){
				i=pdao.addPrjWorkingHoursP(hoursP);
			}
		}
		return i;
	}

	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public PrjWorkingHours selectPrjWorkingHoursByPrjNo(String prjno) {
		PrjWorkingHours pws= dao.selectPrjWorkingHoursByPrjNo(prjno);
		if(pws!=null){
			List<PrjWorkingHoursP> p=pdao.selectByprjgsid(pws.getPwhId());
			if(p!=null&& p.size()>0){
				pws.setPrjWorkingHoursP(p);
			}
		}
		return pws;
	}
}
