package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BorrowContract;

public interface BorrowContractDao {

	List<BorrowContract> selectBorrowContract(@Param("status")String status);

	int JKNocount();

	int addBorrowContractSave(@Param("bc")BorrowContract bc);

	List<BorrowContract> selectBorrowContractHistory(@Param("no")String no);

}
