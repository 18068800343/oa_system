package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.AllQuery;

public interface AllQueryService {

	public List<AllQuery> selectAllQueryByTimeAndDepart(String year_Time, String month_time,String depart,String omName);

	public List<AllQuery> getQueryTable(String depart, String omName, Double seachCjMoneyMin, Double seachCjMoneyMax,
			String seachTimeMin, String seachTimeMax, String serchType, String serchYear);
}
