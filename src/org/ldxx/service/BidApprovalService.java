package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BidApproval;

public interface BidApprovalService {

	List<BidApproval> selectBidApproval(String status);
	
	List<BidApproval> selectBidApproval2(String status);

	int addBidApproval(BidApproval ba);

	int prjNocount(String year);

	int deleteBidApproval(String id);

	int updateBidApproval(BidApproval ba);

	List<BidApproval> selectprjNameAndNo(String status);

	BidApproval selectNoByName(String name);

	BidApproval selectNameByNo(String no);

	BidApproval selectBidApprovalById(String id);
	
	int updateSpPeoson(BidApproval ba);
	
	int updateSubmissionTime(BidApproval ba);
	
	List<BidApproval> selectBidApprovalByTypeAndDepartment(String type,String department); 

	BidApproval selectBidApprovalByNo(String no);
	
	int updateBidNoById(String no,String id);
	
	String CreateBidApprovalNumOrder(String year);
}
