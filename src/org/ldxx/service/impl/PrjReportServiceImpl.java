package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjReport;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.PrjReportDao;
import org.ldxx.service.PrjReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrjReportServiceImpl implements PrjReportService {

	@Autowired
	private PrjReportDao dao;
	@Autowired
	private AccessoryDao adao;
	
	
	@Override
	public List<PrjReport> selectPrjReport(String prType) {
		return dao.selectPrjReport(prType);
	}

	@Override
	public int addPrjReportSave(PrjReport prjReport) {
		int i=dao.addPrjReportSave(prjReport);
		if(i>0){
			List<Accessory> accessory = prjReport.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
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
	public int deletePrjReport(String id) {
		int i=dao.deletePrjReport(id);
		if(i>0){
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list!=null&&list.size()>0){
				i=adao.deleteAccessory(id);
			}
		}
		return i;
	}

	@Override
	public int updatePrjReportSave(PrjReport prjReport) {
		int i=dao.updatePrjReportSave(prjReport);
		if(i>0){
			List<Accessory> list = prjReport.getAccessory();
			if(list!=null&&list.size()>0){
				i=adao.addAccessory(prjReport.getAccessory());
			}
		}
		return i;
	}
	
}
