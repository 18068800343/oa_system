package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.DepartmentTarget;
import org.ldxx.dao.DepartmentTargetDao;
import org.ldxx.service.DepartmentTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentTargetServiceImpl implements DepartmentTargetService{

	@Autowired
	private DepartmentTargetDao dao;
	
	@Override
	public int addDepartmentTarget(List<DepartmentTarget> dTarget) {
		return dao.addDepartmentTarget(dTarget);
	}

	@Override
	public int updateDepartmentTarget(List<DepartmentTarget> dTarget) {
		return dao.updateDepartmentTarget(dTarget);
	}

	@Override
	public List<DepartmentTarget> selectDepartmentTarget(String otId) {
		return dao.selectDepartmentTarget(otId);
	}

	@Override
	public int orNotSplit(String otId) {
		return dao.orNotSplit(otId);
	}

	@Override
	public List<DepartmentTarget> selectDepartmentTargetByOmId(String id) {
		return dao.selectDepartmentTargetByOmId(id);
	}

	@Override
	public DepartmentTarget selectDepartmentTargetByOmIdAndYear(String id, String year) {
		return dao.selectDepartmentTargetByOmIdAndYear(id, year);
	}

	@Override
	public DepartmentTarget selectDepartmentTargetByIdAndOmId(String id, String omId) {
		return dao.selectDepartmentTargetByIdAndOmId(id, omId);
	}

	@Override
	public DepartmentTarget selectDepartmentTargetByYearAndOmId(String year, String omId) {
		return dao.selectDepartmentTargetByYearAndOmId(year, omId);
	}

	@Override
	public int countDepartmentTarget(String omId) {
		return dao.countDepartmentTarget(omId);
	}

}
