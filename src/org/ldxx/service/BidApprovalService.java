package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BidApproval;

public interface BidApprovalService {

	List<BidApproval> selectBidApproval(String status);

	int addBidApproval(BidApproval ba);

	int prjNocount();

	int deleteBidApproval(String id);

	int updateBidApproval(BidApproval ba);

	List<BidApproval> selectprjNameAndNo(String status);

	BidApproval selectNoByName(String name);

	BidApproval selectNameByNo(String no);

	BidApproval selectBidApprovalById(String id);
	
	int updateSpPeoson(BidApproval ba);
	
	int updateSubmissionTime(BidApproval ba);
	
	List<BidApproval> selectBidApprovalByTypeAndDepartment(String type,String department); 
	
}
