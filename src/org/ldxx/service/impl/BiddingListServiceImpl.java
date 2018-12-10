package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay;
import org.ldxx.bean.ProjectList;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.BiddingListDao;
import org.ldxx.service.BiddingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiddingListServiceImpl implements BiddingListService {
	
	@Autowired
	private BiddingListDao bListDao;
	@Autowired
	private AccessoryDao adao;

	@Override
	public int adddiddingList(ProjectList projectList) {
		int i=bListDao.adddiddingList(projectList);
		if(i>0){
			List<Accessory> accessory = projectList.getAccessory1();
			if(accessory!=null&&accessory.size()>0){
				i = adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = projectList.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i = adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = projectList.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i = adao.addAccessory(accessory3);
			}
		}
		return i;
	}

	@Override
	public int deletediddingListById(String plId) {
		int i=bListDao.deletediddingListById(plId);
		if(i>0){
			List<Accessory> list = adao.selectAccessoryById(plId);
			if(list!=null&&list.size()!=0){
				i=adao.deleteAccessory(plId);
			}
		}
		return i;
	}

	@Override
	public List<ProjectList> selectdiddingList() {
		return bListDao.selectdiddingList();
	}

	@Override
	public int updatediddingList(ProjectList projectList) {
		int i= bListDao.updatediddingList(projectList);
		if(i>0){
			List<Accessory> accessory = projectList.getAccessory1();
			if(accessory!=null&&accessory.size()>0){
				i = adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = projectList.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i = adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = projectList.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i = adao.addAccessory(accessory3);
			}
		}
		return i;
	}


	@Override
	public List<ProjectList> selectdiddingUnitAndType() {
		return bListDao.selectdiddingUnitAndType();
	}

	@Override
	public List<ProjectList> selectdiddingByUnitAndType(String plUnit, String prjType) {
		return bListDao.selectdiddingByUnitAndType(plUnit,prjType);
	}

	@Override
	public ProjectList selectdiddingListById(String id) {
		return bListDao.selectdiddingListById(id);
	}

}
