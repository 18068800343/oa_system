package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.GsMaterialWastetreatment;

public interface GsMaterialWastetreatmentDao {

	int addGsMaterialWastetreatmentSave(@Param("mw")GsMaterialWastetreatment mw);

	int updateGsMaterialWastetreatmentSave(@Param("mw")GsMaterialWastetreatment mw);

	int deleteGsMaterialWastetreatment(@Param("id")String id);

	List<GsMaterialWastetreatment> selectGsMaterialWastetreatment();

}
