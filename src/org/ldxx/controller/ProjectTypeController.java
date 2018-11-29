package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.ldxx.bean.Dictionary;
import org.ldxx.bean.DictionaryFirst;
import org.ldxx.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目类型管理
 * @author hp
 *
 */
@Controller
@RequestMapping("projectType")
public class ProjectTypeController {
	
	@Autowired
	private ProjectTypeService projectTypeService;
	
	
	@RequestMapping("/addFirstPrj")
	@ResponseBody
	public Map<String,Object> addFirstPrj(DictionaryFirst dictionaryFirst){
		Map<String,Object> map = new HashMap<>();
		int i=projectTypeService.addOneProjectType(dictionaryFirst);
		map.put("result", i);
		map.put("DictionaryFirst", dictionaryFirst);
		return map;
	}
	
	@RequestMapping("/deleteFirstPrj")
	@ResponseBody
	public int deleteFirstPrj(String idFirst){
		int i = projectTypeService.deleteFirstPrj(idFirst);
		return i;
	}
	
	
	@RequestMapping("/updateFirstPrj")
	@ResponseBody
	public Map<String,Object> updateFirstPrj(DictionaryFirst dictionaryFirst){
		Map<String,Object> map = new HashMap<>();
		int i=projectTypeService.updateFirstPrj(dictionaryFirst);
		map.put("result", i);
		map.put("DictionaryFirst", dictionaryFirst);
		return map;
	}
	
	@RequestMapping("/selectAllFirstPrj")
	@ResponseBody
	public List<DictionaryFirst> selectAllFirstPrj(){
		return projectTypeService.selectAllFirstPrj();
	}
	
	
	@RequestMapping("/addTwoPrj")
	@ResponseBody
	public Map<String,Object> addTwoPrj(Dictionary dictionary){
		Map<String,Object> map = new HashMap<>();
		int i=projectTypeService.addTwoPrj(dictionary);
		map.put("result", i);
		map.put("Dictionary", dictionary);
		return map;
	}
	
	@RequestMapping("/deleteTwoPrj")
	@ResponseBody
	public int deleteTwoPrj(String dId){
		int i = projectTypeService.deleteTwoPrj(dId);
		return i;
	}
	
	@RequestMapping("/updateTwoPrj")
	@ResponseBody
	public Map<String,Object> updateTwoPrj(Dictionary dictionary){
		Map<String,Object> map = new HashMap<>();
		int i=projectTypeService.updateTwoPrj(dictionary);
		map.put("result", i);
		map.put("Dictionary", dictionary);
		return map;
	}
	
	@RequestMapping("/selectAllTwoPrj")
	@ResponseBody
	public List<Dictionary> selectAllTwoPrj(){
		return projectTypeService.selectAllTwoPrj();
	}
	
	@RequestMapping("/selectOne_TwoPrj")
	@ResponseBody
	public List<Dictionary> selectOne_TwoPrj(String idFirst){
		return projectTypeService.selectOne_TwoPrj(idFirst);
	}
	
	
	@RequestMapping("/selectOneIdByName")
	@ResponseBody
	public DictionaryFirst selectOneIdByName(String nameFirst){
		return projectTypeService.selectOneIdByName(nameFirst);
	}
	
	@RequestMapping("/selectAllSecond")
	@ResponseBody
	public List<Dictionary> selectAllSecond(){
		return projectTypeService.selectAllSecond();
	}
	
}
