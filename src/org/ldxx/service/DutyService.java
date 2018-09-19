package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Duty;

public interface DutyService {
	
	public int addDuty(Duty duty);
	
	public int deleteDutyById(String id);
	
	public int updateDutyById(Duty duty);
	
	public List<Duty> selectDutyByOmId(String omId);
	
	public int countOfDutyName(String name,String omId);
	
	public int countOfDutyNameToEdit(String name,String omId,String dutyId);

	public List<Duty> selectDutyByOmIdAndJobType(String omId, String jobType);

	public Duty selectDutyBydutyId(String dutyId);
	
	public List<Duty> selectDutyByUserId(String id);
}
