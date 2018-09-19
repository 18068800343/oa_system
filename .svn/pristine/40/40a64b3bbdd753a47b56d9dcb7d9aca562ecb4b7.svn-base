package org.ldxx.controller;

import java.util.List;
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
	public int addFirstPrj(DictionaryFirst dictionaryFirst){
		int i=projectTypeService.addOneProjectType(dictionaryFirst);
		return i;
	}
	
	@RequestMapping("/deleteFirstPrj")
	@ResponseBody
	public int deleteFirstPrj(String idFirst){
		int i = projectTypeService.deleteFirstPrj(idFirst);
		return i;
	}
	
	
	@RequestMapping("/updateFirstPrj")
	@ResponseBody
	public int updateFirstPrj(DictionaryFirst dictionaryFirst){
		return projectTypeService.updateFirstPrj(dictionaryFirst);
	}
	
	@RequestMapping("/selectAllFirstPrj")
	@ResponseBody
	public List<DictionaryFirst> selectAllFirstPrj(){
		return projectTypeService.selectAllFirstPrj();
	}
	
	
	@RequestMapping("/addTwoPrj")
	@ResponseBody
	public int addTwoPrj(Dictionary dictionary){
		int i=projectTypeService.addTwoPrj(dictionary);
		return i;
	}
	
	@RequestMapping("/deleteTwoPrj")
	@ResponseBody
	public int deleteTwoPrj(String dId){
		int i = projectTypeService.deleteTwoPrj(dId);
		return i;
	}
	
	@RequestMapping("/updateTwoPrj")
	@ResponseBody
	public int updateTwoPrj(Dictionary dictionary){
		return projectTypeService.updateTwoPrj(dictionary);
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
}
