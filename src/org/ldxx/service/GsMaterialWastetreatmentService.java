package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.GsMaterialWastetreatment;
import org.ldxx.bean.GsMaterialWastetreatmentCl;

public interface GsMaterialWastetreatmentService {

	int addGsMaterialWastetreatmentSave(GsMaterialWastetreatment mw);

	List<GsMaterialWastetreatment> selectGsMaterialWastetreatment(String type);

	List<GsMaterialWastetreatmentCl> selectGsMaterialWastetreatmentClById(String id);

}
