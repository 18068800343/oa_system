package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.ProjectOver;
import org.ldxx.service.ManagingDocumentsService;
import org.ldxx.service.ProjectOverService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 中标项目移交
 * @author hp
 *
 */
@RequestMapping("prjOver")
@Controller
public class ProjectOverController {
	
	@Autowired
	private ProjectOverService prjOverService;
	@Autowired
	private ManagingDocumentsService service;//经营文档资料
	
	@RequestMapping("/selectPrjOver")
	@ResponseBody
	public List<ProjectOver> selectPrjOver(int status){
		return prjOverService.selectPrjOver(status);
	}
	
	@RequestMapping("/addPrjOver")//添加保存
	@ResponseBody
	public Map<String,Object> addPrjOver(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		projectOver.setPoId(id);
		int i =prjOverService.addPrjOver(projectOver);
		if(i>0){
			ManagingDocuments md=new ManagingDocuments();
			md.setMdId(id);
			md.setPrjName(projectOver.getPrjName());//项目名
			md.setPrjNo(projectOver.getPrjNo());//项目编号
			md.setPrjType(projectOver.getPrjType());//项目类型
			md.setPrjBidTime(projectOver.getPoDate());//项目投标时间
			md.setIsBidding("是");//是否中标
			md.setOffer(projectOver.getContractAmount());//本公司报价
			md.setBiddingPrice(projectOver.getContractAmount());//中标价格
			md.setBiddingPrjManager(projectOver.getProjectManager());//中标项目经理
			md.setPrjGeneral(projectOver.getProjectEngineer());//项目总工
			md.setBiddingUnit(projectOver.getTenderCompany());//中标单位
			i=service.addManagingDocumentsSave(md);
		}
		map.put("result", i);
		map.put("projectOver", projectOver);
		return map;
	}
	
	@RequestMapping("/SubmitPrjOver")//添加提交
	@ResponseBody
	public Map<String,Object> SubmitPrjOver(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		projectOver.setPoId(id);
		int i =prjOverService.addPrjOver(projectOver);
		if(i>0){
			ManagingDocuments md=new ManagingDocuments();
			md.setMdId(id);
			md.setPrjName(projectOver.getPrjName());//项目名
			md.setPrjNo(projectOver.getPrjNo());//项目编号
			md.setPrjType(projectOver.getPrjType());//项目类型
			md.setPrjBidTime(projectOver.getPoDate());//项目投标时间
			md.setIsBidding("是");//是否中标
			md.setOffer(projectOver.getContractAmount());//本公司报价
			md.setBiddingPrice(projectOver.getContractAmount());//中标价格
			md.setBiddingPrjManager(projectOver.getProjectManager());//中标项目经理
			md.setPrjGeneral(projectOver.getProjectEngineer());//项目总工
			md.setBiddingUnit(projectOver.getTenderCompany());//中标单位
			i=service.addManagingDocumentsSave(md);
		}
		map.put("result", i);
		map.put("projectOver", projectOver);
		return map;
	}
	
	@RequestMapping("/deletePrjOver")
	@ResponseBody
	public int deletePrjOver(String poId){
		int i =prjOverService.deletePrjOver(poId);
		return i;
	}
	
	@RequestMapping("/updatePrjOverById")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatePrjOverById(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		int i =prjOverService.updatePrjOverById(projectOver);
		map.put("result", i);
		map.put("projectOver", projectOver);
		return map;
	}
	
	@RequestMapping("/updatePrjOverByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updatePrjOverByIdSubmit(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		int i =prjOverService.updatePrjOverById(projectOver);
		map.put("result", i);
		map.put("projectOver", projectOver);
		return map;
	}
	
	@RequestMapping("/selectPrjOverById")
	@ResponseBody
	public ProjectOver selectPrjOverById(String poId){
		return prjOverService.selectPrjOverById(poId);
	}
}
