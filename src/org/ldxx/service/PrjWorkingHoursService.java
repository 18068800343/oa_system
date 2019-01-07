package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjWorkingHours;

public interface PrjWorkingHoursService {

	int addPrjWorkingHoursSave(PrjWorkingHours pwh);

	List<PrjWorkingHours> selectPrjWorkingHours();

	int deletePrjWorkingHours(String id);

	int updatePrjWorkingHoursSave(PrjWorkingHours pwh);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	PrjWorkingHours selectPrjWorkingHoursByPrjNo(String prjno);


}
