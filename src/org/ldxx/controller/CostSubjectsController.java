package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Dictionary;
import org.ldxx.bean.DictionaryFirst;
import org.ldxx.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 成本科目管理
 * @author hp
 *
 */
@Controller
@RequestMapping("costSubjects")
public class CostSubjectsController {
	
	@Autowired
	private ProjectTypeService projectTypeService;
	
	@RequestMapping("/addFirstcostSubjects")
	@ResponseBody
	public Map<String,Object> addFirstcostSubjects(DictionaryFirst dictionaryFirst){
		Map<String,Object> map = new HashMap<>();
		int i= projectTypeService.addFirstcostSubjects(dictionaryFirst);
		map.put("result", i);
		map.put("DictionaryFirst", dictionaryFirst);
		return map;
	}
	
	@RequestMapping("/deleteFirstcostSubjects")
	@ResponseBody
	public int deleteFirstcostSubjects(String idFirst){
		return projectTypeService.deleteFirstPrj(idFirst);
	}
	
	@RequestMapping("/updateFirstcostSubjects")
	@ResponseBody
	public Map<String,Object> updateFirstcostSubjects(DictionaryFirst dictionaryFirst){
		Map<String,Object> map = new HashMap<>();
		int i=projectTypeService .updateFirstPrj(dictionaryFirst);
		map.put("result", i);
		map.put("DictionaryFirst", dictionaryFirst);
		return map;
	}
	
	@RequestMapping("/selectAllFirstcostSubjects")
	@ResponseBody
	public List<DictionaryFirst> selectAllFirstcostSubjects(){
		return projectTypeService.selectAllFirstcostSubjects();
	}
	
	@RequestMapping("/addTwocostSubjects")
	@ResponseBody
	public int addTwocostSubjects(Dictionary dictionary){
		return projectTypeService.addTwoPrj(dictionary);
	}
	
	@RequestMapping("/deleteTwocostSubjects")
	@ResponseBody
	public int deleteTwocostSubjects(String dId){
		return projectTypeService.deleteTwoPrj(dId);
	}
	
	@RequestMapping("/updateTwocostSubjects")
	@ResponseBody
	public int updateTwocostSubjects(Dictionary dictionary){
		return projectTypeService.updateTwoPrj(dictionary);
	}
	
	@RequestMapping("/selectAllTwocostSubjects")
	@ResponseBody
	public List<Dictionary> selectAllTwocostSubjects(){
		return projectTypeService.selectAllTwoPrj();
	}
	
	@RequestMapping("/selectOne_TwocostSubjects")
	@ResponseBody
	public List<Dictionary> selectOne_TwocostSubjects(String idFirst){
		return projectTypeService.selectOne_TwoPrj(idFirst);
	}

}
