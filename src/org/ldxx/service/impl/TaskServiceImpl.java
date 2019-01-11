package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Task;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.service.TaskService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDao tdao;
	
	@Autowired
	private EnterpriseDao edao;
	
	@Transactional
	@Override
	public int addTask(Task task) {
		List<Enterprise> enterprise=task.getEnterprise();
		int i=tdao.addTask(task);
		if(i>0){
			for(int ii=0;ii<enterprise.size();ii++){
				enterprise.get(ii).seteId(task.getPrjId());
			}
			i=edao.addEnterprise(enterprise);
		}
		return i;
	}
	
	@Transactional
	@Override
	public int deleteTask(String id) {
		int i=edao.deleteEnterprise(id);
		if(i>0){
			i=tdao.deleteTask(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateTask(Task task) {
		int i=tdao.updateTask(task);
		if(i>0){
			i=edao.deleteEnterprise(task.getPrjId());
			List<Enterprise> enterprise=task.getEnterprise();
			if(enterprise.size()>0){
				for(int ii=0;ii<enterprise.size();ii++){
					enterprise.get(ii).seteId(task.getPrjId());
				}
				i=edao.addEnterprise(task.getEnterprise());
			}
		}
		return i;
	}

	@Override
	public Task selectTaskById(String id) {
		Task task=tdao.selectTaskById(id);
		String prjCompany1 = task.getPrjCompany1();
		if(null!=prjCompany1&&!"".equals(prjCompany1)){
			if(prjCompany1.contains("华通")){
				task.setPrjCompany1("华通");
			}else if(prjCompany1.contains("华汇")){
				task.setPrjCompany1("华汇");
			}
		}else{
			task.setPrjCompany1("");
		}
		List<Enterprise> enterprise=edao.selectEnterpriseById(id);
		task.setEnterprise(enterprise);
		return task;
	}

	@Override
	public List<Task> selectIdAndNameByStatus(String status) {
		return tdao.selectIdAndNameByStatus(status);
	}

	@Override
	public int typeCount() {
		return tdao.typeCount();
	}

	@Override
	public List<Task> selectTaskHistory(String no) {
		return tdao.selectTaskHistory(no);
	}

	@Override
	public Task selectCcNameByPrjId(String id) {
		return tdao.selectCcNameByPrjId(id);
	}

	@Override
	public List<Task> selectPrjNameAndWorkNo() {
		return tdao.selectPrjNameAndWorkNo();
	}

	@Override
	public Task selectTaskPrjName(String prjNo) {
		return tdao.selectTaskPrjName(prjNo);
	}

	@Override
	public Task selectTaskPrjNo(String prjName) {
		return tdao.selectTaskPrjNo(prjName);
	}

	@Override
	public Task selectNoByName(String name) {
		return tdao.selectNoByName(name);
	}

	@Override
	public Task selectIdByNo(String no) {
		return tdao.selectIdByNo(no);
	}

	@Override
	public Task selectNoByName2(String name) {
		return tdao.selectNoByName2(name);
	}

	@Override
	public Task selectIdByNo2(String no) {
		return tdao.selectIdByNo2(no);
	}

	@Override
	public List<Task> selectPrjandNoAndPrjMoney() {
		return tdao.selectPrjandNoAndPrjMoney();
	}

	@Override
	public List<Task> selectPrjByprjlike(String no) {
		no="%"+no+"%";
		return tdao.selectPrjByprjlike(no);
	}

	@Override
	public List<Task> selectPrjAndNo() {
		return tdao.selectPrjAndNo();
	}

	@Override
	public Task selectIdByName(String name) {
		return tdao.selectIdByName(name);
	}

	@Override
	public Task selectIdByNameAndNo(String name, String no) {
		return tdao.selectIdByNameAndNo(name,no);
	}

	@Override
	public List<Task> getTaskIdNameNo() {
		return tdao.getTaskIdNameNo();
	}

	@Override
	public List<Task> selectTaskByStatus(String status, String startMin, String startMax, String endMin, String endMax,
			String mainDp, String xbDp, float prjMoneyMin, float prjMoneyMax, float contractMoneyMin,
			float contractMoneyMax, float zdMoneyMin, float zdMoneyMax) {
		return tdao.selectTaskByStatus(status, startMin, startMax, endMin, endMax, mainDp, xbDp, prjMoneyMin, prjMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
	}

	@Override
	public List<Task> selectTaskByPrjType(String type,String time) {
		return tdao.selectTaskByPrjType(type,time);
	}

	@Override
	public Task selectTaskByNoAndType(String type, String no) {
		return tdao.selectTaskByNoAndType(type, no);
	}

	@Override
	public int updateById(Task task) {
		return tdao.updateById(task);
	}
	
	@Override
	public Task selectPrjLeaderByPrjNo(String no) {
		return tdao.selectPrjLeaderByPrjNo(no);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= tdao.updateHistoryById(id);
		if(i>0){
			i=tdao.updateHistoryNow(id);
		}
		return i;
	}

	@Override
	public List<Task> selectTaskByCj() {
		return tdao.selectTaskByCj();
	}

}
