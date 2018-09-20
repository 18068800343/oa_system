package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预算单管理
 * @author hp
 *
 */
@Controller
@RequestMapping("budge")
public class BudgetFpplicationFormController {

	@Autowired
	private BudgetFpplicationFormService bservice;
	
	@RequestMapping("/saveBudge")
	@ResponseBody
	public Map<String,Object> saveBudge(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String nowTime=dateFormat.format(date);
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		budge.setMakeTime(nowTime);
		int i=bservice.saveBudge(budge);
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/submitBudge")
	@ResponseBody
	public Map<String,Object> submitBudge(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String nowTime=dateFormat.format(date);
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		budge.setMakeTime(nowTime);
		int i=bservice.saveBudge(budge);
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/deleteBudgeById")
	@ResponseBody
	public int deleteBudgeById(String id){
		return bservice.deleteBudgeById(id);
	}
	
	@RequestMapping("/updateBudgeSave")
	@ResponseBody
	public Map<String,Object> updateBudgeSave(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String nowTime=dateFormat.format(date);
		BudgetFpplicationForm budge = budges.get(0);
		budge.setMakeTime(nowTime);
		int i=bservice.changeStateById(budge.getBfId());
		if(i>0){
			String newId=new TimeUUID().getTimeUUID();
			budge.setBfId(newId);
			i=bservice.saveBudge(budge);
		}
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/updateBudgeSubmit")
	@ResponseBody
	public Map<String,Object> updateBudgeSubmit(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String nowTime=dateFormat.format(date);
		BudgetFpplicationForm budge = budges.get(0);
		budge.setMakeTime(nowTime);
		int i=bservice.changeStateById(budge.getBfId());
		if(i>0){
			String newId=new TimeUUID().getTimeUUID();
			budge.setBfId(newId);
			i=bservice.saveBudge(budge);
		}
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/selectBudgeByStatus")
	@ResponseBody
	public List<BudgetFpplicationForm> selectBudgeByStatus(String status,String state){
		return bservice.selectBudgeByStatus(status,state);
	}
	
	@RequestMapping("/selectBudgeById")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeById(String id,String status,String state){
		return bservice.selectBudgeById(id,status,state);
	}
}
