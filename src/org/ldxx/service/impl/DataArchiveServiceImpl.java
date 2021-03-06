package org.ldxx.service.impl;

import java.io.File;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.DataArchive;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.DataArchiveDao;
import org.ldxx.service.DataArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataArchiveServiceImpl implements DataArchiveService{

	@Autowired
	private DataArchiveDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addDataArchive(DataArchive archive) {
		List<Accessory> list=archive.getAccessory();
		List<Accessory> list2=archive.getAccessory2();
		List<Accessory> list3=archive.getAccessory3();
		int i=dao.addDataArchive(archive);
		if(i>0){
			if(list.size()>0){
				i=adao.addAccessory(list);
			}
			if(list2.size()>0){
				i=adao.addAccessory(list2);
			}
			if(list3.size()>0){
				i=adao.addAccessory(list3);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteDataArchive(String id) {
		List<Accessory> list=adao.selectAccessoryById(id);
		int i=dao.deleteDataArchive(id);
		if(i>0){
			i=adao.deleteAccessory(id);
			if(i>0){
					for(int a=0;a<list.size();a++){
						String path=list.get(a).getAcUrl();
						File f=new File(path);
						f.delete();
					}
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int updateDataArchive(DataArchive archive) {
		List<Accessory> list=archive.getAccessory();
		List<Accessory> list2=archive.getAccessory2();
		List<Accessory> list3=archive.getAccessory3();
		int i=dao.updateDataArchive(archive);
		if(i>0){
			if(list.size()>0){
				adao.addAccessory(list);
			}
			if(list2.size()>0){
				adao.addAccessory(list2);
			}
			if(list3.size()>0){
				adao.addAccessory(list3);
			}
		}
		return i;
	}

	@Override
	public List<DataArchive> selectDataArchive() {
		List<DataArchive> list=dao.selectDataArchive();
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getDaId();
			List<Accessory> acc=adao.selectAccessoryByIdAndType(id, "资料");
			List<Accessory> acc2=adao.selectAccessoryByIdAndType(id, "证书");
			List<Accessory> acc3=adao.selectAccessoryByIdAndType(id, "自我总结");
			list.get(i).setAccessory(acc);
			list.get(i).setAccessory2(acc2);
			list.get(i).setAccessory3(acc3);
		}
		return list;
	}

	@Override
	public DataArchive selectDataArchiveById(String id) {
		return dao.selectDataArchiveById(id);
	}

}
