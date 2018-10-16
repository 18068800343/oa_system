package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Parameter;

public interface ParameterDao {

	List<Parameter> selectParameter();

	int addParameter(@Param("p")Parameter p);

	int deleteParameter(@Param("id")String id);

	int updateParameter(@Param("p")Parameter p);

}
