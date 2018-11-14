package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.RiskAssessment;
import org.ldxx.service.RiskAssessmentService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目风险评估
 * @author hp
 *
 */
@RequestMapping("riskAssessment")
@Controller
public class RiskAssessmentController {

	@Autowired
	private RiskAssessmentService raService;
	
	@RequestMapping("/addRiskAssessment")/*保存*/
	@ResponseBody
	public Map<String,Object> addRiskAssessment(RiskAssessment riskassessment){
		Map<String,Object> map = new HashMap<>();
		int i =raService.isExistByprjId(riskassessment.getPrjName());
		if(i==0){
			String id = new TimeUUID().getTimeUUID();
			riskassessment.setRaId(id);
			i = raService.addRiskAssessment(riskassessment);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/addRiskAssessmentSubmit")/*提交*/
	@ResponseBody
	public Map<String,Object> addRiskAssessmentSubmit(RiskAssessment riskassessment){
		Map<String,Object> map = new HashMap<>();
		int i =raService.isExistByprjId(riskassessment.getPrjName());
		if(i==0){
			String id = new TimeUUID().getTimeUUID();
			riskassessment.setRaId(id);
			i = raService.addRiskAssessment(riskassessment);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/deleteRiskAssessmentById")
	@ResponseBody
	public int deleteRiskAssessmentById(String raId){
		return raService.deleteRiskAssessmentById(raId);
	}
	
	@RequestMapping("/updateRiskAssessmentById")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updateRiskAssessmentById(RiskAssessment riskassessment){
		Map<String,Object> map = new HashMap<>();
		int i =raService.countOfPrjId(riskassessment.getPrjName(),riskassessment.getRaId());
		if(i<1){
			i = raService.updateRiskAssessmentById(riskassessment);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/updateRiskAssessmentByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updateRiskAssessmentByIdSubmit(RiskAssessment riskassessment){
		Map<String,Object> map = new HashMap<>();
		int i =raService.countOfPrjId(riskassessment.getPrjName(),riskassessment.getRaId());
		if(i<1){
			i = raService.updateRiskAssessmentById(riskassessment);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/selectRiskAssessmentById")
	@ResponseBody
	public RiskAssessment selectRiskAssessmentById(String raId){
		return raService.selectRiskAssessmentById(raId);
	}
	
	@RequestMapping("/selectAllRiskAssessment")
	@ResponseBody
	public List<RiskAssessment> selectAllRiskAssessment(String status){
		return raService.selectAllRiskAssessment(status);
	}
	
	@RequestMapping("/selectRiskAssessmentPrjName")
	@ResponseBody
	public List<RiskAssessment> selectRiskAssessmentPrjName(){
		return raService.selectRiskAssessmentPrjName();
	}
	
	@RequestMapping("/selectIdByName")
	@ResponseBody
	public RiskAssessment selectIdByName(String prjName){
		return raService.selectIdByName(prjName);
	}
	
}
