package org.ldxx.service.impl;

import java.io.File;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.MaintenanceReinforcement;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.MaintenanceReinforcementDao;
import org.ldxx.service.MaintenanceReinforcementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaintenanceReinforcementServiceImpl implements MaintenanceReinforcementService{

	@Autowired
	private MaintenanceReinforcementDao dao;
	@Autowired
	private AccessoryDao aDao;
	
	@Transactional
	@Override
	public int addMaintenanceReinforcement(MaintenanceReinforcement mr) {
		int i=dao.addMaintenanceReinforcement(mr);
		if(i>0){
			List<Accessory> acc=mr.getAccessory1();
			if(acc.size()!=0){
				i=aDao.addAccessory(acc);
			}
			List<Accessory> acc2=mr.getAccessory2();
			if(acc2.size()!=0){
				i=aDao.addAccessory(acc2);
			}
			List<Accessory> acc3=mr.getAccessory3();
			if(acc3.size()!=0){
				i=aDao.addAccessory(acc3);
			}
			List<Accessory> acc4=mr.getAccessory4();
			if(acc4.size()!=0){
				i=aDao.addAccessory(acc4);
			}
			List<Accessory> acc5=mr.getAccessory5();
			if(acc5.size()!=0){
				i=aDao.addAccessory(acc5);
			}
			List<Accessory> acc6=mr.getAccessory6();
			if(acc6.size()!=0){
				i=aDao.addAccessory(acc6);
			}
			List<Accessory> acc7=mr.getAccessory7();
			if(acc7.size()!=0){
				i=aDao.addAccessory(acc7);
			}
			List<Accessory> acc8=mr.getAccessory8();
			if(acc8.size()!=0){
				i=aDao.addAccessory(acc8);
			}
			List<Accessory> acc9=mr.getAccessory9();
			if(acc9.size()!=0){
				i=aDao.addAccessory(acc9);
			}
			List<Accessory> acc10=mr.getAccessory10();
			if(acc10.size()!=0){
				i=aDao.addAccessory(acc10);
			}
			List<Accessory> acc11=mr.getAccessory11();
			if(acc11.size()!=0){
				i=aDao.addAccessory(acc11);
			}
			List<Accessory> acc12=mr.getAccessory12();
			if(acc12.size()!=0){
				i=aDao.addAccessory(acc12);
			}
			List<Accessory> acc13=mr.getAccessory13();
			if(acc13.size()!=0){
				i=aDao.addAccessory(acc13);
			}
			List<Accessory> acc14=mr.getAccessory14();
			if(acc14.size()!=0){
				i=aDao.addAccessory(acc14);
			}
			List<Accessory> acc15=mr.getAccessory15();
			if(acc15.size()!=0){
				i=aDao.addAccessory(acc15);
			}
			List<Accessory> acc16=mr.getAccessory16();
			if(acc16.size()!=0){
				i=aDao.addAccessory(acc16);
			}
			List<Accessory> acc17=mr.getAccessory17();
			if(acc17.size()!=0){
				i=aDao.addAccessory(acc17);
			}
			List<Accessory> acc18=mr.getAccessory18();
			if(acc18.size()!=0){
				i=aDao.addAccessory(acc18);
			}
			List<Accessory> acc19=mr.getAccessory19();
			if(acc19.size()!=0){
				i=aDao.addAccessory(acc19);
			}
			List<Accessory> acc20=mr.getAccessory20();
			if(acc20.size()!=0){
				i=aDao.addAccessory(acc20);
			}
		}
		return i;
	}

	@Override
	public List<MaintenanceReinforcement> selectAllMaintenanceReinforcement() {
		return dao.selectAllMaintenanceReinforcement();
	}

	@Override
	public int deleteMr(String id) {
		int i=aDao.deleteAccessory(id);
		if(i>0){
			i=dao.deleteMr(id);
			if(i>0){
				String path="D:"+File.separator+"oa"+File.separator+"MaintenanceReinforcement"+File.separator+id;
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
		return i;
	}

	@Override
	public MaintenanceReinforcement selectAllMaintenanceReinforcementById(String id) {
		return dao.selectAllMaintenanceReinforcementById(id);
	}

}
