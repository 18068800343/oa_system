package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.FlowNode;
import org.ldxx.bean.FlowNodeExample;
import org.ldxx.bean.FlowTmp;
import org.ldxx.bean.FlowTmpExample;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.mapper.FlowTmpMapper;
import org.ldxx.service.FlowTmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlowTmpServiceImpl implements FlowTmpService {

	@Autowired
	FlowTmpMapper flowTmpMapper;
	@Autowired
	FlowNodeMapper flowNodeMapper;
	
	@Override
	public List<FlowTmp> getFlowTmp() {
		
		List<FlowTmp> flowTmps = flowTmpMapper.selectByExample(null);
		for(FlowTmp flowTmp:flowTmps){
			String flowTmpId = flowTmp.getId();
			FlowNodeExample example=new FlowNodeExample();
			example.createCriteria().andFloTmpIdEqualTo(flowTmpId);
			List<FlowNode> flowNodes = flowNodeMapper.selectByExample(example);
			flowTmp.setFlowNodes(flowNodes);
		}
		
		return flowTmps;
	}

	@Override
	public String saveFlowTmp(FlowTmp flowTmp) {
		
		int i = flowTmpMapper.insert(flowTmp);
		return i+"";
	}

	@Transactional
	@Override
	public String deleteFlowTmp(String id) {
		FlowNodeExample example = new FlowNodeExample();
		example.createCriteria().andFloTmpIdEqualTo(id);
		flowNodeMapper.deleteByExample(example);
		flowTmpMapper.deleteByPrimaryKey(id);
		return "";
	}

}
