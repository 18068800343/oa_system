package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BidApproval;

public interface BidApprovalService {

	List<BidApproval> selectBidApproval();

	int addBidApproval(BidApproval ba);

	int prjNocount();

	int deleteBidApproval(String id);

	int updateBidApproval(BidApproval ba);

}
