package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.GsMaterialWastetreatment;
import org.ldxx.bean.GsMaterialWastetreatmentCl;
import org.ldxx.bean.outRemain;
import org.ldxx.dao.ClRemainDao;
import org.ldxx.dao.GsMaterialWastetreatmentDao;
import org.ldxx.service.GsMaterialWastetreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GsMaterialWastetreatmentServiceImpl implements GsMaterialWastetreatmentService {
	
	
	@Autowired
	private GsMaterialWastetreatmentDao dao;
	@Autowired
	private ClRemainDao crdao;

	@Override
	public int addGsMaterialWastetreatmentSave(GsMaterialWastetreatment mw) {
		int i=dao.addGsMaterialWastetreatmentSave(mw);
		if(i>0){
			List<GsMaterialWastetreatmentCl> cl = mw.getGsMaterialWastetreatmentCl();
			List<outRemain> remain = mw.getoRemain();
			for(int k=0;k<cl.size();k++){
				cl.get(k).setCwmclId(mw.getCmwId());
			}
			i=dao.addGsMaterialWastetreatmentCl(cl);
			if(i>0){
				i=crdao.updateRemainForWaste(remain);
			}
		}
		return i;
	}


	@Override
	public List<GsMaterialWastetreatment> selectGsMaterialWastetreatment(String type) {
		List<GsMaterialWastetreatment> list= dao.selectGsMaterialWastetreatment(type);
		if(list!=null&&list.size()!=0){
			for(int i=0;i<list.size();i++){
				List<GsMaterialWastetreatmentCl> wastetreatmentClById = dao.selectGsMaterialWastetreatmentClById(list.get(i).getCmwId());
				if(wastetreatmentClById!=null&&wastetreatmentClById.size()!=0){
					list.get(i).setGsMaterialWastetreatmentCl(wastetreatmentClById);
				}
			}
		}
		return list;
	}


	@Override
	public List<GsMaterialWastetreatmentCl> selectGsMaterialWastetreatmentClById(String id) {
		return dao.selectGsMaterialWastetreatmentClById(id);
	}


	@Override
	public GsMaterialWastetreatment selectGsMaterialWastetreatmentById(String id) {
		return dao.selectGsMaterialWastetreatmentById(id);
	}
}
