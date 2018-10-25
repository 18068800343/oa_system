package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjWorkingHoursP;

public interface PrjWorkingHoursPDao {

	int addPrjWorkingHoursP(@Param("hoursP")List<PrjWorkingHoursP> hoursP);

	List<PrjWorkingHoursP> selectByprjgsid(@Param("prjgsid")String prjgsid);

	int deleteByprjgsid(@Param("id")String id);

}
