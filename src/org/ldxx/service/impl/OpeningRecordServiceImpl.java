package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OpeningInformation;
import org.ldxx.bean.OpeningRecord;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OpeningInformationDao;
import org.ldxx.dao.OpeningRecordDao;
import org.ldxx.service.OpeningRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OpeningRecordServiceImpl implements OpeningRecordService {

	@Autowired
	private OpeningRecordDao dao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private OpeningInformationDao idao;

	@Override
	public List<OpeningRecord> selectOpeningRecord() {
		List<OpeningRecord> list=dao.selectOpeningRecord();
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getOrId();
			List<OpeningInformation> openingInformation=idao.selectOpeningInformationById(id);
			list.get(i).setOpeningInformation(openingInformation);
		}
		return list;
	}

	@Override
	public int addOpeningRecordSave(OpeningRecord record) {
		int i=dao.addOpeningRecordSave(record);
		if(i>0){
			List<Accessory> accessory=record.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
			List<OpeningInformation> list = record.getOpeningInformation();
			if(list.size()!=0){
				for(int k=0;k<list.size();k++){
					list.get(k).setOiId(record.getOrId());
				}
				i=idao.addOpeningInformation(list);
			}
		}
		return i;
	}

	@Override
	public int updateOpeningRecordSave(OpeningRecord record) {
		List<OpeningInformation> information = idao.selectOpeningInformationById(record.getOrId());
		if(information.size()>0&&information!=null){
			idao.deleteOpeningInformation(record.getOrId());
		}
		int i=dao.updateOpeningRecordSave(record);
		if(i>0){
			List<Accessory> accessory=record.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
			List<OpeningInformation> list = record.getOpeningInformation();
			if(list.size()!=0&&list!=null){
				for(int ii=0;ii<list.size();ii++){
					list.get(ii).setOiId(record.getOrId());
				}
				i=idao.addOpeningInformation(list);
			}
		}
		return i;
	}

	@Override
	public OpeningRecord selectOpeningRecordById(String id) {
		OpeningRecord record=dao.selectOpeningRecordById(id);
		List<OpeningInformation> list=idao.selectOpeningInformationById(id);
		if(list.size()>0&&list!=null){
			record.setOpeningInformation(list);
		}
		return record;
	}
	
}
