package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.DesignDocuments;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.Task;
import org.ldxx.bean.TechnicalDocumentation;
import org.ldxx.bean.TestingEvaluation;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ConstructionDocumentsDao;
import org.ldxx.dao.DesignDocumentsDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.ManagingDocumentsDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.dao.TechnicalDocumentationDao;
import org.ldxx.dao.TestingEvaluationDao;
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
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private ManagingDocumentsDao mddao;
	@Autowired
	private ConstructionDocumentsDao cddao;
	@Autowired
	private TestingEvaluationDao tedao;
	@Autowired
	private DesignDocumentsDao dddao;
	@Autowired
	private TechnicalDocumentationDao tddao;
	
	@Transactional
	@Override
	public int addTask(Task task) {
		List<Enterprise> enterprise=task.getEnterprise();
		int i=tdao.addTask(task);
		if(i>0){
			if(null!=enterprise&&enterprise.size()>0){
				for(int ii=0;ii<enterprise.size();ii++){
					enterprise.get(ii).seteId(task.getPrjId());
				}
				i=edao.addEnterprise(enterprise);
			}
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
			edao.deleteEnterprise(task.getPrjId());
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
		Task task = null;
		task=tdao.selectTaskById(id);
		if(null==task) {
			return task;
		}
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
	public Task selectTaskAndTaskChildrenById(String id) {
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
		String mainPrjNo = task.getPrjNo();
		List<Task> taskChildren = tdao.selectTaskAndTaskChildrenByMainPrjNo(mainPrjNo,id);

		task.setTaskChildren(taskChildren);
		return task;
	}
	@Override
	public List<Task> selectIdAndNameByStatus(String status) {
		return tdao.selectIdAndNameByStatus(status);
	}

	@Override
	public int typeCount(String year) {
		year="%"+year+"%";
		return tdao.typeCount(year);
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
			String mainDp, String xbDp, Double prjMoneyMin, Double prjMoneyMax, Double contractMoneyMin,
			Double contractMoneyMax, Double zdMoneyMin, Double zdMoneyMax) {
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
		
		i=tdao.updateHistoryNow(id);
		
		return i;
	}

	@Override
	public List<Task> selectTaskByCj() {
		return tdao.selectTaskByCj();
	}

	@Override
	public List<Task> selectTaskByStatus2(String status) {
		return tdao.selectTaskByStatus2(status);
	}

	@Override
	public int updateTasks(List<Task> task) {
		return tdao.updateTasks(task);
	}

	@Override
	public Task selectPrjJsMoneyByNo(String no) {
		Task task=tdao.selectPrjJsMoneyByNo(no);
		if(task.getMainPrjNo()!=null){
			Double prjEstimateMoney=tdao.getPrjEstimateMoneyByNo(task.getMainPrjNo());
			task.setPrjEstimateMoney(task.getPrjEstimateMoney()+prjEstimateMoney);
		}
		return task;
	}

	@Override
	public List<Task> selectTask(String mainDepartment) {
		List<Task> list=tdao.selectlikeMainDepartment(mainDepartment);
		if(list!=null&&list.size()!=0){
			for(int i=0;i<list.size();i++){
				ManagingDocuments managingDocuments = mddao.selectManagingDocumentsByNo(list.get(i).getPrjNo());
				if(managingDocuments!=null){
					List<Accessory> Accessory = adao.selectAccessoryById(managingDocuments.getMdId());
					if(Accessory!=null&&Accessory.size()!=0){
						list.get(i).setFileLength(1);
					}
				}
				ConstructionDocuments constructionDocuments = cddao.selectConstructionDocumentsByno(list.get(i).getPrjNo());
				if(constructionDocuments!=null){
					List<Accessory> Accessory = adao.selectAccessoryById(constructionDocuments.getCdId());
					if(Accessory!=null&&Accessory.size()!=0){
						list.get(i).setFileLengthSG(1);
					}
				}
				TestingEvaluation testingEvaluation = tedao.selectTestingEvaluationById(list.get(i).getPrjNo());
				if(testingEvaluation!=null){
					List<Accessory> Accessory = adao.selectAccessoryById(testingEvaluation.getTeId());
					if(Accessory!=null&&Accessory.size()!=0){
						list.get(i).setFileLengthJC(1);
					}
				}
				DesignDocuments designDocuments = dddao.selectDesignDocumentsById(list.get(i).getPrjNo());
				if(designDocuments!=null){
					List<Accessory> Accessory = adao.selectAccessoryById(designDocuments.getDdId());
					if(Accessory!=null&&Accessory.size()!=0){
						list.get(i).setFileLengthSJ(1);
					}
				}
				TechnicalDocumentation technicalDocumentation = tddao.selectTechnicalDocumentationById(list.get(i).getPrjNo());
				if(technicalDocumentation!=null){
					List<Accessory> Accessory = adao.selectAccessoryById(technicalDocumentation.getTdId());
					if(Accessory!=null&&Accessory.size()!=0){
						list.get(i).setFileLengthKJ(1);
					}
				}
				
			}
		}
		return list;
	}

	@Override
	public int updateTaskNoById(String no, String id) {
		return tdao.updateTaskNoById(no, id);
	}

	@Override
	public String CreateTaskNumOrder(String gs,String year, String type) {
		return tdao.CreateTaskNumOrder(gs,year, type);
	}

	@Override
	public String selectIdByTaskNo(String prjNo) {
		
		return tdao.selectIdByTaskNo(prjNo);
	}

	@Override
	public int addReason(String id, String reason) {
		return tdao.addReason(id, reason);
	}

}
