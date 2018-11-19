package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.DesignDocuments;
import org.ldxx.bean.MaintenanceReinforcement;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.TechnicalDocumentation;
import org.ldxx.bean.TestingEvaluation;
import org.ldxx.service.ConstructionDocumentsService;
import org.ldxx.service.DesignDocumentsService;
import org.ldxx.service.MaintenanceReinforcementService;
import org.ldxx.service.ManagingDocumentsService;
import org.ldxx.service.TechnicalDocumentationService;
import org.ldxx.service.TestingEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: ArchivalStatisticsController 
* @Description: 档案统计
* @author zhaohui
* @date 2018年11月19日 下午3:06:22 
*  
*/
@Controller
@RequestMapping("/ArchivalStatistics")
public class ArchivalStatisticsController {

	@Autowired
	private ConstructionDocumentsService cService;
	@Autowired
	private DesignDocumentsService dService;
	@Autowired
	private ManagingDocumentsService mService;
	@Autowired
	private TechnicalDocumentationService tService;
	@Autowired
	private TestingEvaluationService teService;
	@Autowired
	private MaintenanceReinforcementService mrService;
	
	
	@RequestMapping("/selectArchivalStatistics")
	@ResponseBody
	public List<List<String>> selectArchivalStatistics(String id){
		List<List<String>> list=new ArrayList<List<String>>();
		ConstructionDocuments cd=cService.selectConstructionDocumentsById(id);
		if(cd!=null){
			List<String> ll=new ArrayList<>();
			ll.add(cd.getCdId());
			ll.add("施工文档资料");
			list.add(ll);
		}
		DesignDocuments dd=dService.selectDesignDocumentsById(id);
		if(dd!=null){
			List<String> ll2=new ArrayList<>();
			ll2.add(dd.getDdId());
			ll2.add("设计文件资料");
			list.add(ll2);
		}
		ManagingDocuments md=mService.selectManagingDocumentsById(id);
		if(md!=null){
			List<String> ll3=new ArrayList<>();
			ll3.add(md.getMdId());
			ll3.add("经营文档资料");
			list.add(ll3);
		}
		TechnicalDocumentation td=tService.selectTechnicalDocumentationById(id);
		if(td!=null){
			List<String> ll4=new ArrayList<>();
			ll4.add(td.getTdId());
			ll4.add("科技文档资料");
			list.add(ll4);
		}
		TestingEvaluation te=teService.selectTestingEvaluationById(id);
		if(te!=null){
			List<String> ll5=new ArrayList<>();
			ll5.add(te.getTeId());
			ll5.add("检测评估资料");
			list.add(ll5);
		}
		MaintenanceReinforcement mr=mrService.selectAllMaintenanceReinforcementById(id);
		if(mr!=null){
			List<String> ll6=new ArrayList<>();
			ll6.add(mr.getMrId());
			ll6.add("维修加固设计资料");
			list.add(ll6);
		}
		return list;
	}
}
