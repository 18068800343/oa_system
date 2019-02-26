package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.OperationTarget;
import org.ldxx.dao.OperationTargetDao;
import org.ldxx.service.OperationTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationTargetServiceImpl implements OperationTargetService{

	@Autowired
	private OperationTargetDao odao;
	
	@Override
	public int addOperationTarget(OperationTarget target) {
		int i=odao.countByYear(target.getYear(), target.getOtId());
		if(i>0){
			i=2;
		}else{
			i=odao.addOperationTarget(target);
		}
		return i;
	}

	@Override
	public int deleteOperationTargetById(String id) {
		return odao.deleteOperationTargetById(id);
	}

	@Override
	public int updateOperationTarget(OperationTarget target) {
		int i=odao.countByYear(target.getYear(), target.getOtId());
		if(i>0){
			i=2;
		}else{
			i=odao.updateOperationTarget(target);
		}
		return i;
	}

	@Override
	public List<OperationTarget> selectOperationTarget() {
		return odao.selectOperationTarget();
	}

	@Override
	public float getSumCostByYear(String year) {
		String y="%"+year+"%";
		return odao.getSumCostByYear(y);
	}

	@Override
	public List<OperationTarget> selectOperationTargetByYear(String year) {
		return odao.selectOperationTargetByYear(year);
	}

	@Override
	public String selectGsOperationTargetByTime(String time) {
		return odao.selectGsOperationTargetByTime(time);
	}

	@Override
	public Object selectBmOperationTargetByTime(Map<String, Object> map) {
		return odao.selectBmOperationTargetByTime(map);
	}

}
