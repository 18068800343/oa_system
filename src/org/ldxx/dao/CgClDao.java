package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CgCl;

public interface CgClDao {

	int addCgCl(@Param("cgcl")List<CgCl> cgcl);

	List<CgCl> selectCgClById(@Param("id")String id);

	int deleteCgClById(@Param("id")String id);
}
