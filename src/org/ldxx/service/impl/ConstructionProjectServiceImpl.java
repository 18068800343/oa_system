package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.BidProject;
import org.ldxx.dao.ConstructionProjectDao;
import org.ldxx.service.ConstructionProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConstructionProjectServiceImpl implements ConstructionProjectService {
	
	@Autowired
	private ConstructionProjectDao cPrjDao;

	@Override
	public List<BidProject> selectAllcPrj(String status) {
		return cPrjDao.selectAllcPrj(status);
	}

	@Override
	public int addcPrj(BidProject bidProject) {
		return cPrjDao.addcPrj(bidProject);
	}

	@Override
	public int deletecPrj(String bpId) {
		return cPrjDao.deletecPrj(bpId);
	}

	@Override
	public int updatecPrj(BidProject bidProject) {
		return cPrjDao.updatecPrj(bidProject);
	}

	@Override
	public int updatecPrjBidById(BidProject bidProject) {
		return cPrjDao.updatecPrjBidById(bidProject);
	}

}
