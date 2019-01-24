package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.BusinessExample;
import org.ldxx.bean.FlowEdgeExample;
import org.ldxx.bean.FlowNode;
import org.ldxx.bean.FlowNodeExample;
import org.ldxx.bean.FlowTmp;
import org.ldxx.bean.FlowTmpExample;
import org.ldxx.bean.NodeActors;
import org.ldxx.bean.NodeActorsExample;
import org.ldxx.bean.Role;
import org.ldxx.dao.RoleDao;
import org.ldxx.mapper.BusinessMapper;
import org.ldxx.mapper.FlowEdgeMapper;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.mapper.FlowTmpMapper;
import org.ldxx.mapper.NodeActorsMapper;
import org.ldxx.mapper.RolesMapper;
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
	@Autowired 
	NodeActorsMapper nodeActorsMapper;
	@Autowired
	RoleDao roleDao;
	@Autowired
	FlowEdgeMapper flowEdgeMapper;
	@Autowired
	BusinessMapper businessMapper;
	@Override
	public List<FlowTmp> getFlowTmp() {
		
		List<FlowTmp> flowTmps = flowTmpMapper.selectAllFlowTmp();
		for(FlowTmp flowTmp:flowTmps){
			String flowTmpId = flowTmp.getId();
			FlowNodeExample example=new FlowNodeExample();
			example.createCriteria().andFloTmpIdEqualTo(flowTmpId);
			List<FlowNode> flowNodes = flowNodeMapper.selectByExample(example);
			
			for(FlowNode flowNode:flowNodes){
				String nodeActorNames = "";
				NodeActorsExample example2 = new NodeActorsExample();
				example2.createCriteria().andFloNodeIdEqualTo(flowNode.getId());
				List<NodeActors> nodeActors = nodeActorsMapper.selectByExample(example2);
				List<String> roleIds = new ArrayList<>(); 
				if(nodeActors.size()>0){
					for(NodeActors nodeActor:nodeActors){
						String roleCode = nodeActor.getRolecode();
						Role role = roleDao.selectRoleById(roleCode);
						if(null!=role){
							String roleName = role.getRoleName();
							nodeActorNames = nodeActorNames+roleName+",";
							roleIds.add(role.getId()+"");
						}else{
							String roleName = "";
							nodeActorNames = nodeActorNames+roleName+",";
							roleIds.add("");
						}
					}
					if(!"".equals(nodeActorNames)&&nodeActorNames.length()>0){
						nodeActorNames = nodeActorNames.substring(0, nodeActorNames.length()-1);
						flowNode.setNodeActorNames(nodeActorNames);
					}
					
				}else{
					flowNode.setNodeActorNames("");
				}
				flowNode.setRoleIds(roleIds.toArray());
				
			}
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
		FlowNodeExample example4 = new FlowNodeExample();
		example4.createCriteria().andFloTmpIdEqualTo(id);
		List<FlowNode> flowNodes = flowNodeMapper.selectByExample(example4 );
		for(FlowNode flowNode:flowNodes){
			NodeActorsExample example1 = new NodeActorsExample();
			example1.createCriteria().andFloNodeIdEqualTo(flowNode.getId());
			nodeActorsMapper.deleteByExample(example1);
		}
		FlowEdgeExample example2 = new FlowEdgeExample();
		example2.createCriteria().andFloTmpIdEqualTo(id);
		flowEdgeMapper.deleteByExample(example2);
		FlowNodeExample example = new FlowNodeExample();
		example.createCriteria().andFloTmpIdEqualTo(id);
		flowNodeMapper.deleteByExample(example);
		
		BusinessExample example5=new BusinessExample();
		example5.createCriteria().andFloTmpIdEqualTo(id);
		businessMapper.deleteByExample(example5);
		flowTmpMapper.deleteByPrimaryKey(id);
		
		return "";
	}

}
