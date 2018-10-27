package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.GsMaterialWastetreatment;
import org.ldxx.bean.GsMaterialWastetreatmentCl;

public interface GsMaterialWastetreatmentDao {

	int addGsMaterialWastetreatmentSave(@Param("mw")GsMaterialWastetreatment mw);

	List<GsMaterialWastetreatment> selectGsMaterialWastetreatment(@Param("type")String type);

	int addGsMaterialWastetreatmentCl(@Param("cl")List<GsMaterialWastetreatmentCl> cl);

	List<GsMaterialWastetreatmentCl> selectGsMaterialWastetreatmentClById(@Param("id")String id);

}
