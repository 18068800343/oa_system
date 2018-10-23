package org.ldxx.dao;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ModeStatus;

public interface ModeStatusDao {

	int addModeStatus(@Param("ms")ModeStatus ms);

}
