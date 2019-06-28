package org.ldxx.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Eva;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CooperatorDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.service.CooperatorService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CooperatorServiceImpl  implements CooperatorService{

	@Autowired
	private CooperatorDao cDao;
	
	@Autowired
	private EnterpriseDao eDao;
	@Autowired
	private AccessoryDao adao;
	
	
	@Transactional
	@Override
	public int addCooperator(Cooperator cooperator) {
		int i=cDao.addCooperator(cooperator);
		String id = cooperator.getCcId();
		if(i>0){
			List<Enterprise> enterprise=cooperator.getEnterprise();
			if(enterprise.size()!=0&&enterprise!=null){
				for(int ii=0;ii<enterprise.size();ii++){
					enterprise.get(ii).seteId(id);
				}
				i=eDao.addEnterprise(enterprise);
			}
			List<Accessory> accessory1=cooperator.getAccessory1();
			if(accessory1!=null){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2=cooperator.getAccessory2();
			if(accessory2!=null){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3=cooperator.getAccessory3();
			if(accessory3!=null){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4=cooperator.getAccessory4();
			if(accessory4!=null){
				i=adao.addAccessory(accessory4);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteCooperator(String id) {
		int i=eDao.deleteEnterprise(id);
		if(i>0){
			i=cDao.deleteCooperator(id);
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
				if(i>0){
					String path="D:"+File.separator+"oa"+File.separator+"cooperator"+File.separator+id;
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

	@Transactional
	@Override
	public int updateCooperator(Cooperator cooperator) {
		int i=eDao.deleteEnterprise(cooperator.getCcId());
		List<Enterprise>enterprise=cooperator.getEnterprise();
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(cooperator.getCcId());
		}
			i=cDao.updateCooperator(cooperator);
			if(i>0){
				i=eDao.addEnterprise(enterprise);
			}
			List<Accessory> accessory1=cooperator.getAccessory1();
			if(accessory1!=null){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2=cooperator.getAccessory2();
			if(accessory2!=null){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3=cooperator.getAccessory3();
			if(accessory3!=null){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4=cooperator.getAccessory4();
			if(accessory4!=null){
				i=adao.addAccessory(accessory4);
			}
		return i;
	}

	@Override
	public List<Cooperator> selectAllCooperator() {
		return cDao.selectAllCooperator();
	}

	@Transactional
	@Override
	public Cooperator selectOneCooperator(String id) {
		Cooperator cooperator=cDao.selectOneCooperator(id);
		List<Enterprise> enterprise=eDao.selectEnterpriseById(id);
		cooperator.setEnterprise(enterprise);
/*		List<Eva> eva=new ArrayList<>();
		Eva a=new Eva();
		a.setEvaName("棱点oA合同");
		a.setEvaLv("90");
		eva.add(a);
		cooperator.setEnterpriseEva(eva);*/
		return cooperator;
	}

	@Override
	public List<Cooperator> selectCooperatorIdAndName() {
		return cDao.selectCooperatorIdAndName();
	}

	@Override
	public Cooperator selectCooperatorByCcName(String name) {
		Cooperator cc=cDao.selectCooperatorByCcName(name);
		if(cc!=null){
			List<Enterprise> enterprise=eDao.selectEnterpriseById(cc.getCcId());
			if(enterprise!=null&&enterprise.size()!=0){
				cc.setEnterprise(enterprise);
			}
		}
		return cc;
	}

}
