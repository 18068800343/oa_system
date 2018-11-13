package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OpeningInformation;

public interface OpeningInformationDao {

	List<OpeningInformation> selectOpeningInformationById(@Param("id")String id);

	int addOpeningInformation(@Param("list")List<OpeningInformation> list);

	int deleteOpeningInformation(@Param("id")String id);

}
