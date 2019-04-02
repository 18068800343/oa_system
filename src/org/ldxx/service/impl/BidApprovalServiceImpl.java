package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.BidApproval;
import org.ldxx.bean.ProjectTrace;
import org.ldxx.dao.BidApprovalDao;
import org.ldxx.dao.ProjectTraceDao;
import org.ldxx.service.BidApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BidApprovalServiceImpl implements BidApprovalService {
	
	@Autowired
	private BidApprovalDao dao;
	@Autowired
	private ProjectTraceDao ptdao;//项目跟踪单

	@Override
	public List<BidApproval> selectBidApproval(String status) {
		return dao.selectBidApproval(status);
	}

	@Override
	public int addBidApproval(BidApproval ba) {
		ProjectTrace pt=ptdao.selectprjStatesByname(ba.getPrjName());
		if(pt!=null){
			ba.setPrjStates(pt.getPrjStates());
		}else{
			ba.setPrjStates("无");
		}
		return dao.addBidApproval(ba);
	}

	@Override
	public int prjNocount(String year) {
		return dao.prjNocount(year);
	}

	@Override
	public int deleteBidApproval(String id) {
		return dao.deleteBidApproval(id);
	}

	@Override
	public int updateBidApproval(BidApproval ba) {
		ProjectTrace pt=ptdao.selectprjStatesByname(ba.getPrjName());
		if(pt!=null){
			ba.setPrjStates(pt.getPrjStates());
		}else{
			ba.setPrjStates("无");
		}
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

	@Override
	public int updateSpPeoson(BidApproval ba) {
		return dao.updateSpPeoson(ba);
	}

	@Override
	public int updateSubmissionTime(BidApproval ba) {
		return dao.updateSubmissionTime(ba);
	}

	@Override
	public List<BidApproval> selectBidApprovalByTypeAndDepartment(String type, String department) {
		return dao.selectBidApprovalByTypeAndDepartment(type, department);
	}

	@Override
	public List<BidApproval> selectBidApproval2(String status) {
		return dao.selectBidApproval2(status);
	}

	@Override
	public BidApproval selectBidApprovalByNo(String no) {
		return dao.selectBidApprovalByNo(no);
	}

	@Override
	public int updateBidNoById(String no, String id) {
		return dao.updateBidNoById(no, id);
	}

	@Override
	public String CreateBidApprovalNumOrder(String year) {
		return dao.CreateBidApprovalNumOrder(year);
	}

}
