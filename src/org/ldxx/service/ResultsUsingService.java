package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ResultManagementSignet;

public interface ResultsUsingService {

	List<ResultManagementSignet> selectResultsUsing(String status);

	int addResultsUsing(ResultManagementSignet rs);

	int deleteResultsUsingById(String usId);

	int updateResultsUsingByIdSave(ResultManagementSignet rs);

	ResultManagementSignet selectResultsUsingById(String usId);
	
	int updateUseStatus(String id);

}
