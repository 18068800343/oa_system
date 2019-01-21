package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BorrowContract;

public interface BorrowContractService {

	List<BorrowContract> selectBorrowContract(String status);

	int JKNocount(String year);

	int addBorrowContractSave(BorrowContract bc);

	List<BorrowContract> selectBorrowContractHistory(String no);

	int updateHistoryById(String id);
	
	int updateHistory(String id);
	
	BorrowContract selectBorrowById(String id);

	int updateBorrowContractById(BorrowContract bc);
	
	BorrowContract selectAllBorrowByFbNo(String no);
	
	List<BorrowContract> getRateAndMoney(String no);

}
