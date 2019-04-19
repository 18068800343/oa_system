package org.ldxx.dao;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BackUpDataBase;

public interface AutoBackUpDataBaseDao {

	void insertDataBaseBack(@Param("bd")BackUpDataBase bd);

}
