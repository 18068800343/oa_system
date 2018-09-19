package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ProjectList;
import org.ldxx.dao.BiddingListDao;
import org.ldxx.service.BiddingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiddingListServiceImpl implements BiddingListService {
	
	@Autowired
	private BiddingListDao bListDao;

	@Override
	public int adddiddingList(ProjectList projectList) {
		return bListDao.adddiddingList(projectList);
	}

	@Override
	public int deletediddingListById(String plId) {
		return bListDao.deletediddingListById(plId);
	}

	@Override
	public List<ProjectList> selectdiddingList() {
		return bListDao.selectdiddingList();
	}

	@Override
	public int updatediddingList(ProjectList projectList) {
		return bListDao.updatediddingList(projectList);
	}

	@Override
	public int deletezhaoFileById(String plId) {
		return bListDao.deletezhaoFileById(plId);
	}

	@Override
	public int deletetouFileById(String plId) {
		return bListDao.deletetouFileById(plId);
	}

	@Override
	public int deletetuzhiFileById(String plId) {
		return bListDao.deletetuzhiFileById(plId);
	}

	@Override
	public List<ProjectList> selectdiddingUnitAndType() {
		return bListDao.selectdiddingUnitAndType();
	}

	@Override
	public List<ProjectList> selectdiddingByUnitAndType(String plUnit, String prjType1) {
		return bListDao.selectdiddingByUnitAndType(plUnit,prjType1);
	}

}
