package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.GsMaterialWastetreatment;

public interface GsMaterialWastetreatmentService {

	int addGsMaterialWastetreatmentSave(GsMaterialWastetreatment mw);

	int updateGsMaterialWastetreatmentSave(GsMaterialWastetreatment mw);

	int deleteGsMaterialWastetreatment(String id);

	List<GsMaterialWastetreatment> selectGsMaterialWastetreatment();

}
