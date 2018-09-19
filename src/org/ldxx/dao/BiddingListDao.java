package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectList;

public interface BiddingListDao {

	int adddiddingList(@Param("projectList")ProjectList projectList);

	int deletediddingListById(@Param("plId")String plId);

	List<ProjectList> selectdiddingList();

	int updatediddingList(@Param("projectList")ProjectList projectList);

	int deletezhaoFileById(@Param("plId")String plId);

	int deletetouFileById(@Param("plId")String plId);

	int deletetuzhiFileById(@Param("plId")String plId);

	List<ProjectList> selectdiddingUnitAndType();

	List<ProjectList> selectdiddingByUnitAndType(@Param("plUnit")String plUnit, @Param("prjType1")String prjType1);

}
