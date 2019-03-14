package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjWorkingHours;

public interface PrjWorkingHoursDao {

	int addPrjWorkingHoursSave(@Param("pwh")PrjWorkingHours pwh);

	List<PrjWorkingHours> selectPrjWorkingHours();

	int deletePrjWorkingHours(@Param("id")String id);

	int updatePrjWorkingHoursSave(@Param("pwh")PrjWorkingHours pwh);

	PrjWorkingHours selectPrjWorkingHoursByPrjNo(@Param("prjno")String prjno);
	
	//190313 当未填写项目信息的时候添加项目信息用的
	int updatePrjWorkingHoursAddInfo(@Param("pwh")PrjWorkingHours pwh);

}
