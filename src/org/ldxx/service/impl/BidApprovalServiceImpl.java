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
	public List<BidApproval> selectBidApproval(String status) {
		return dao.selectBidApproval(status);
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

	@Override
	public int updateBidApproval(BidApproval ba) {
		return dao.updateBidApproval(ba);
	}

	@Override
	public List<BidApproval> selectprjNameAndNo(String status) {
		return dao.selectprjNameAndNo(status);
	}

	@Override
	public BidApproval selectNoByName(String name) {
		return dao.selectNoByName(name);
	}

	@Override
	public BidApproval selectNameByNo(String no) {
		return dao.selectNameByNo(no);
	}

	@Override
	public BidApproval selectBidApprovalById(String id) {
		return dao.selectBidApprovalById(id);
	}

}
