package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BidApproval;

public interface BidApprovalDao {

	List<BidApproval> selectBidApproval();

	int addBidApproval(@Param("ba")BidApproval ba);

	int prjNocount();

	int deleteBidApproval(@Param("id")String id);

}
