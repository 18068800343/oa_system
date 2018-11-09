package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MaintenanceReinforcement;

public interface MaintenanceReinforcementDao {

	public int addMaintenanceReinforcement(@Param("mr")MaintenanceReinforcement mr);
	
	public List<MaintenanceReinforcement> selectAllMaintenanceReinforcement();
	
	public int deleteMr(@Param("id")String id);
}
