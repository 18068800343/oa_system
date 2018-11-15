package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ProjectList;

public interface BiddingListService {

	int adddiddingList(ProjectList projectList);

	int deletediddingListById(String plId);

	List<ProjectList> selectdiddingList();

	int updatediddingList(ProjectList projectList);

	int deletezhaoFileById(String plId);

	int deletetouFileById(String plId);

	int deletetuzhiFileById(String plId);

	List<ProjectList> selectdiddingUnitAndType();

	List<ProjectList> selectdiddingByUnitAndType(String plUnit, String prjType);

}
