package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.GsMaterialWastetreatment;
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

	@Override
	public int addGsMaterialWastetreatmentSave(GsMaterialWastetreatment mw) {
		return dao.addGsMaterialWastetreatmentSave(mw);
	}

	@Override
	public int updateGsMaterialWastetreatmentSave(GsMaterialWastetreatment mw) {
		return dao.updateGsMaterialWastetreatmentSave(mw);
	}

	@Override
	public int deleteGsMaterialWastetreatment(String id) {
		return dao.deleteGsMaterialWastetreatment(id);
	}

	@Override
	public List<GsMaterialWastetreatment> selectGsMaterialWastetreatment() {
		return dao.selectGsMaterialWastetreatment();
	}
}
