package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.BidApproval;
import org.ldxx.dao.BidApprovalDao;
import org.ldxx.service.BidApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BidApprovalServiceImpl implements BidApprovalService {
	
	@Autowired
	private BidApprovalDao dao;

	@Override
	public List<BidApproval> selectBidApproval() {
		return dao.selectBidApproval();
	}

	@Override
	public int addBidApproval(BidApproval ba) {
		return dao.addBidApproval(ba);
	}

	@Override
	public int prjNocount() {
		return dao.prjNocount();
	}

	@Override
	public int deleteBidApproval(String id) {
		return dao.deleteBidApproval(id);
	}

}
