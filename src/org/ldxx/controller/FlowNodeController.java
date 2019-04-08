package org.ldxx.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.ldxx.bean.FlowEdge;
import org.ldxx.bean.FlowEdgeExample;
import org.ldxx.bean.FlowNode;
import org.ldxx.bean.FlowNodeExample;
import org.ldxx.bean.FlowTmp;
import org.ldxx.bean.NodeActors;
import org.ldxx.bean.NodeActorsExample;
import org.ldxx.mapper.FlowEdgeMapper;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.mapper.FlowTmpMapper;
import org.ldxx.mapper.NodeActorsMapper;
import org.ldxx.service.FlowTmpService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("flowNode")
@Controller
public class FlowNodeController {
	@Autowired
	FlowTmpService flowTmpService;
	@Autowired
	FlowTmpMapper flowTmpMapper;
	@Autowired
	FlowNodeMapper flowNodeMapper;
	@Autowired
	NodeActorsMapper nodeActorsMapper;
	@Autowired
	FlowEdgeMapper flowEdgeMapper;
	@ResponseBody
	@RequestMapping("/getFloNodeByFloTmpId")
	public List<FlowNode> getFlowTmpList(String floTmpId){
		
		FlowNodeExample example = new FlowNodeExample();
		example.createCriteria().andFloTmpIdEqualTo(floTmpId);
		List<FlowNode> flowNodes = flowNodeMapper.selectByExample(example);
		return flowNodes;
	}
	
	@ResponseBody
	@RequestMapping("/getNodeRoleById")
	public List<String> getNodeRoleById(String id){
		
		List<String> strs = flowNodeMapper.selectFlowNodeRoleByTmpId(id);
		return strs;
	}
	
	@ResponseBody
	@RequestMapping("/addFlowNode")
	public String addFlowNode(String floNodeName,String lastFloNode,String floNodeRoles,String page_floTmpId){
		FlowNode flowNode = new FlowNode();
		flowNode.setFloNodeLeft(lastFloNode);
		flowNode.setFloTmpId(page_floTmpId);
		flowNode.setFlownodename(floNodeName);
		flowNode.setReturnrole(3);
		flowNode.setEditOrView("view");
		//floNodeId 
		String floNodeId = new TimeUUID().getTimeUUID();
		flowNode.setId(floNodeId);
		flowNodeMapper.insert(flowNode);
		if(null!=floNodeRoles){
			String roleIds[] = floNodeRoles.split(",");
			for(String roleId:roleIds){
				NodeActors nodeActors = new NodeActors();
				nodeActors.setFloNodeId(floNodeId);
				nodeActors.setId(new TimeUUID().getTimeUUID());
				nodeActors.setRolecode(roleId);
				nodeActorsMapper.insert(nodeActors);
			}
		}
		if(!"".equals(lastFloNode)&&null!=lastFloNode){
			FlowEdge flowEdge = new FlowEdge();
			flowEdge.setFloTmpId(page_floTmpId);
			flowEdge.setFloNodeLeft(lastFloNode);
			flowEdge.setFloNodeRight(floNodeId);
			flowEdge.setId(new TimeUUID().getTimeUUID());
			flowEdgeMapper.insert(flowEdge);
		}
		return "1";
	}
	
	@ResponseBody
	@RequestMapping("/updateFlowNode")
	public String updateFlowNode(String floNodeName,String lastFloNode,String floNodeRoles,String floNodeId,String page_update_floTmpId){
		FlowNode flowNode = new FlowNode();
		flowNode.setFloNodeLeft(lastFloNode);
		flowNode.setFlownodename(floNodeName);
		int i =flowNodeMapper.updateByPrimaryKeySelective(flowNode);
		NodeActorsExample example = new NodeActorsExample();
		example.createCriteria().andFloNodeIdEqualTo(floNodeId);
		nodeActorsMapper.deleteByExample(example);
		if(null!=floNodeRoles){
			String roleIds[] = floNodeRoles.split(",");
			for(String roleId:roleIds){
				NodeActors nodeActors = new NodeActors();
				nodeActors.setFloNodeId(floNodeId);
				nodeActors.setId(new TimeUUID().getTimeUUID());
				nodeActors.setRolecode(roleId);
				int k = nodeActorsMapper.insert(nodeActors);
			}
		}
		//修改FlowEdge
			FlowEdgeExample example3=new FlowEdgeExample();
			example3.createCriteria().andFloTmpIdEqualTo(page_update_floTmpId).andFloNodeRightEqualTo(floNodeId);
			List<FlowEdge> flowEdges = flowEdgeMapper.selectByExample(example3);
			if(null!=flowEdges&&flowEdges.size()>0){
				FlowEdge flowEdge = flowEdges.get(0);
				if(!"".equals(lastFloNode)&&null!=lastFloNode){
					flowEdge.setFloNodeLeft(lastFloNode);
				}
				int j = flowEdgeMapper.updateByPrimaryKeySelective(flowEdge);
			}
		return "1";
	}
	@ResponseBody
	@RequestMapping("/deleteFloNode")
	public String deleteFloNode(String floNodeId){
		NodeActorsExample example = new NodeActorsExample();
		example.createCriteria().andFloNodeIdEqualTo(floNodeId);
		nodeActorsMapper.deleteByExample(example);
		FlowEdgeExample example3 = new FlowEdgeExample();
		example3.createCriteria().andFloNodeRightEqualTo(floNodeId);
		flowEdgeMapper.deleteByExample(example3);
		flowNodeMapper.deleteByPrimaryKey(floNodeId);
		return "1";
	}
}
