package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CurrentFlow;

public interface BusinessReminderDao {

	List<CurrentFlow> selectBusinessReminder(@Param("userId")String userId, @Param("status")String status);

}
