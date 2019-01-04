package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectList;
import org.ldxx.bean.ReceiveMoney;

public interface ReceiveMoneyDao {

	int addReceiveMoney(@Param("receiveMoney")ReceiveMoney receiveMoney);

	int deleteReceiveMoneyById(@Param("id")String id);

	List<ReceiveMoney> selectReceiveList();
	
	List<ReceiveMoney> selectReceiveListByStatus(@Param("status")String status);

	int updateReceiveMoney(@Param("receiveMoney")ReceiveMoney receiveMoney);

	int updateStatus(@Param("skno")String skno, @Param("status")String status);

	int countSkNo();
	
	

}
