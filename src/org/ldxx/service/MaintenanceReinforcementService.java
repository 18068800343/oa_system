package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.MaintenanceReinforcement;

public interface MaintenanceReinforcementService {

	public int addMaintenanceReinforcement(MaintenanceReinforcement mr);
	
	public List<MaintenanceReinforcement> selectAllMaintenanceReinforcement();
	
	public int deleteMr(String id);
}
