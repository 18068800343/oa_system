package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BidProject;

public interface ConstructionProjectService {

	List<BidProject> selectAllcPrj(String status);

	int addcPrj(BidProject bidProject);

	int deletecPrj(String bpId);

	int updatecPrj(BidProject bidProject);

	int updatecPrjBidById(BidProject bidProject);

}
