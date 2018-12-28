package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectList;
import org.ldxx.bean.ReceiveMoney;

public interface ReceiveMoneyDao {

	int addReceiveMoney(ReceiveMoney receiveMoney);

	int deleteReceiveMoneyById(String id);

	List<ReceiveMoney> selectReceiveList();
	
	List<ReceiveMoney> selectReceiveListByStatus(String status);

	int updateReceiveMoney(@Param("receiveMoney")ReceiveMoney receiveMoney);

}
