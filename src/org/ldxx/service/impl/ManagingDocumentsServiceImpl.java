package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.ManagingDocumentsTenderer;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ManagingDocumentsDao;
import org.ldxx.dao.ManagingDocumentsTendererDao;
import org.ldxx.service.ManagingDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagingDocumentsServiceImpl implements ManagingDocumentsService {
	
	@Autowired
	private ManagingDocumentsDao dao;
	@Autowired
	private ManagingDocumentsTendererDao tdao;
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<ManagingDocuments> selectManagingDocuments() {
		List<ManagingDocuments> list = dao.selectManagingDocuments();
		for(int i=0;i<list.size();i++){
			List<ManagingDocumentsTenderer> list2 = tdao.selectTendererById(list.get(i).getMdId());
			list.get(i).setManagingDocumentsTenderer(list2);
		}
		return list;
	}

	@Override
	public int deleteManagingDocumentsById(String id) {
		int i=dao.deleteManagingDocumentsById(id);
		if(i>0){
			i=tdao.deletetTendererById(id);
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
			}
		}
		return i;
	}

	@Override
	public int addManagingDocumentsSave(ManagingDocuments md) {
		int i=dao.addManagingDocumentsSave(md);
		List<Accessory> accessory1 = md.getAccessory1();
		List<Accessory> accessory2 = md.getAccessory2();
		List<Accessory> accessory3 = md.getAccessory3();
		List<Accessory> accessory4 = md.getAccessory4();
		List<Accessory> accessory5 = md.getAccessory5();
		List<Accessory> accessory6 = md.getAccessory6();
		List<ManagingDocumentsTenderer> tenderer = md.getManagingDocumentsTenderer();
		if(i>0){
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			for(int k=0;k<tenderer.size();k++){
				tenderer.get(k).settId(md.getMdId());
			}
			if(tenderer!=null&&tenderer.size()>0){
				i=tdao.addTenderer(tenderer);
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
	public int updateManagingDocumentsSave(ManagingDocuments md) {
		int i=dao.updateManagingDocumentsSave(md);
		if(i>0){
			List<Accessory> accessory1 = md.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = md.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = md.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = md.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = md.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = md.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			i=tdao.deletetTendererById(md.getMdId());
			List<ManagingDocumentsTenderer> tenderer = md.getManagingDocumentsTenderer();
			for(int k=0;k<tenderer.size();k++){
				tenderer.get(k).settId(md.getMdId());
			}
			if(tenderer!=null&&tenderer.size()>0){
				i=tdao.addTenderer(tenderer);
			}
		}
		return i;
	}

	@Override
	public ManagingDocuments selectManagingDocumentsById(String id) {
		return dao.selectManagingDocumentsById(id);
	}

}
