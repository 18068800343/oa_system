package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BidApproval;

public interface BidApprovalDao {

	List<BidApproval> selectBidApproval(@Param("status")String status);
	
	List<BidApproval> selectBidApproval2(@Param("status")String status);

	int addBidApproval(@Param("ba")BidApproval ba);

	int prjNocount(@Param("year")String year);

	int deleteBidApproval(@Param("id")String id);

	int updateBidApproval(@Param("ba")BidApproval ba);

	List<BidApproval> selectprjNameAndNo(@Param("status")String status);

	BidApproval selectNoByName(@Param("name")String name);

	BidApproval selectNameByNo(@Param("no")String no);

	BidApproval selectBidApprovalById(@Param("id")String id);
	
	int updateSpPeoson(@Param("ba")BidApproval ba);
	
	int updateSubmissionTime(@Param("ba")BidApproval ba);
	
	int updateFlowEdit(@Param("ba")BidApproval ba);
	
	List<BidApproval> selectBidApprovalByTypeAndDepartment(@Param("type")String type,@Param("department")String department);
}
