package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjWorkingHours;

public interface PrjWorkingHoursDao {

	int addPrjWorkingHoursSave(@Param("pwh")PrjWorkingHours pwh);

	List<PrjWorkingHours> selectPrjWorkingHours();

	int deletePrjWorkingHours(@Param("id")String id);

	int updatePrjWorkingHoursSave(@Param("pwh")PrjWorkingHours pwh);

}
