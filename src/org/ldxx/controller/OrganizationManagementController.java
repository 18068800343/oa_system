package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.OrganizationManagement;
import org.ldxx.service.OrganizationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 组织机构管理
 * @author hp
 *
 */
@RequestMapping("organizationManagement")
@Controller
public class OrganizationManagementController {

	@Autowired
	OrganizationManagementService omservice;
	
	@RequestMapping("/addOrganizationManagement")/*新建组织机构*/
	@ResponseBody
	public int addOrganizationManagement(OrganizationManagement organizationManagement){
		return omservice.addOrganizationManagement(organizationManagement);
	}
	
	@RequestMapping("/deleteOrganizationManagement")/*删除组织机构*/
	@ResponseBody
	public int deleteOrganizationManagement(String omId){
		return omservice.deleteOrganizationManagement(omId);
	}
	
	@RequestMapping("/updateOrganizationManagement")/*修改组织机构*/
	@ResponseBody
	public int updateOrganizationManagement(OrganizationManagement organizationManagement){
		return omservice.updateOrganizationManagement(organizationManagement);
	}
	
	@RequestMapping("/getAllOrganizationManagement")/*查看所有的组织机构*/
	@ResponseBody
	public List<OrganizationManagement> getAllOrganizationManagement(){
		return omservice.getAllOrganizationManagement();
	}
	
	@RequestMapping("/getOrgIdAndName")/*查看组织机构的id和name*/
	@ResponseBody
	public List<OrganizationManagement> getOrgIdAndName(){
		return omservice.getOrgIdAndName();
	}
	
	@RequestMapping("/getOrgNameById")/*通过id查看组织机构的name*/
	@ResponseBody
	public OrganizationManagement getOrgNameById(String omId){
		return omservice.getOrgNameById(omId);
	}
	@RequestMapping("/getOrgIdByName")/*通过name查看组织机构的id*/
	@ResponseBody
	public OrganizationManagement getOrgIdByName(String omName){
		return omservice.getOrgIdByName(omName);
	}
}
