package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BorrowContract;

public interface BorrowContractDao {

	List<BorrowContract> selectBorrowContract(@Param("status")String status);

	int JKNocount(@Param("year")String year);

	int addBorrowContractSave(@Param("bc")BorrowContract bc);

	List<BorrowContract> selectBorrowContractHistory(@Param("no")String no);

	int updateHistoryById(@Param("id")String id);

	int updateHistoryNow(@Param("id")String id);
	
	int updateHistory(@Param("id")String id);
	
	BorrowContract selectBorrowById(@Param("id")String id);

	int updateBorrowContractById(@Param("bc")BorrowContract bc);
	
	BorrowContract selectAllBorrowByFbNo(@Param("no")String no);

	List<BorrowContract> getRateAndMoney(@Param("no")String no);
}
