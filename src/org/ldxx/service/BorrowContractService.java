package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BorrowContract;

public interface BorrowContractService {

	List<BorrowContract> selectBorrowContract(String status);

	int JKNocount();

	int addBorrowContractSave(BorrowContract bc);

	List<BorrowContract> selectBorrowContractHistory(String no);

}
