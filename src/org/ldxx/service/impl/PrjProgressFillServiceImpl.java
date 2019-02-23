package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillCj;
import org.ldxx.bean.PrjProgressFillFb;
import org.ldxx.bean.PrjProgressFillInfo;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.PrjProgressFillDao;
import org.ldxx.service.PrjProgressFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrjProgressFillServiceImpl implements PrjProgressFillService{

	@Autowired
	private PrjProgressFillDao dao;
	
	@Autowired
	private AccessoryDao aDao;
	
	@Transactional
	@Override
	public int addPrjProgressFill(PrjProgressFill ppf) {
		int i=dao.addPrjProgressFill(ppf);
		String id=ppf.getPpfId();
		if(i>0){
			List<PrjProgressFillInfo> ppfi=ppf.getPpfi();
			for(int a=0;a<ppfi.size();a++){
				ppfi.get(a).setPpfId(id);
			}
			/*List<PrjProgressFillInfo> ppfi2=ppf.getPpfi2();
			for(int a=0;a<ppfi2.size();a++){
				ppfi2.get(a).setPpfId(id);
			}*/
			/*List<PrjProgressFillInfo> ppfi3=ppf.getPpfi3();
			for(int a=0;a<ppfi3.size();a++){
				ppfi3.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi4=ppf.getPpfi4();
			for(int a=0;a<ppfi4.size();a++){
				ppfi4.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi5=ppf.getPpfi5();
			for(int a=0;a<ppfi5.size();a++){
				ppfi5.get(a).setPpfId(id);
			}
			List<PrjProgressFillInfo> ppfi6=ppf.getPpfi6();
			for(int a=0;a<ppfi6.size();a++){
				ppfi6.get(a).setPpfId(id);
			}*/
			i=dao.addPrjProgressFillInfo(ppfi);
			/*i=dao.addPrjProgressFillInfo(ppfi2);*/
			/*i=dao.addPrjProgressFillInfo(ppfi3);
			i=dao.addPrjProgressFillInfo(ppfi4);
			i=dao.addPrjProgressFillInfo(ppfi5);
			i=dao.addPrjProgressFillInfo(ppfi6);*/
			List<PrjProgressFillFb> ppfb=ppf.getPpfb();
			for(int ii=0;ii<ppfb.size();ii++){
				ppfb.get(ii).setPpfId(id);
			}
			if(ppfb!=null&&ppfb.size()>0){
				i=dao.addPrjProgressFillFb(ppfb);
			}
			
			/*List<PrjProgressFillCj>ppcj=ppf.getPpcj();
			if(ppcj!=null){
				for(int ii=0;ii<ppcj.size();ii++){
					int count=dao.selectPrjProgressFillCjCountByIdAndBq(ppcj.get(ii).getCjId(),ppcj.get(ii).getBq());
					if(count==0){
						i=dao.addPrjProgressFillCj(ppcj.get(ii));
					}else{
						i=dao.updatePrjProgressFillCjByIdAndBq(ppcj.get(ii));
					}
				}
			}*/
			
			List<Accessory> accessory=ppf.getAccessory();
			if(accessory !=null&&accessory.size()>0){
				i=aDao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<PrjProgressFill> selectPrjProgressFill(String status) {
		return dao.selectPrjProgressFill(status);
	}

	@Override
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(String id, String type) {
		return dao.selectPrjProgressFillInfo(id, type);
	}

	@Override
	public PrjProgressFill selectPrjProgressFillById(String id) {
		return dao.selectPrjProgressFillById(id);
	}

	@Override
	public PrjProgressFill selectLastPrjProgressFill(String no) {
		return dao.selectLastPrjProgressFill(no);
	}

	@Override
	public PrjProgressFillInfo getLastByDepartmentAndId(String id, String department) {
		return dao.getLastByDepartmentAndId(id, department);
	}

	@Override
	public int addPrjProgressFillCj(PrjProgressFillCj ppcj) {
		return dao.addPrjProgressFillCj(ppcj);
	}

	/*@Override
	public PrjProgressFillCj cjBq(String ppfId, String cjId) {
		return dao.cjBq(ppfId, cjId);
	}*/

	@Override
	public List<PrjProgressFillCj> selectPrjProgressFillCjById(String id) {
		return dao.selectPrjProgressFillCjById(id);
	}

	@Override
	public List<PrjProgressFill> selectPrjProgressFillByStatus(int status) {
		return dao.selectPrjProgressFillByStatus(status);
	}

	@Override
	public int updateStatusAndDesc(int status, String infos,String id) {
		return dao.updateStatusAndDesc(status, infos,id);
	}

	@Override
	public List<PrjProgressFill> selectDistinctTaskNo(String year) {
		String y="%"+year+"%";
		return dao.selectDistinctTaskNo(y);
	}

	@Override
	public PrjProgressFill getCost(String no) {
		return dao.getCost(no);
	}

	@Override
	public float getDepartmentCost(String department, String id) {
		return dao.getDepartmentCost(department, id);
	}

	@Override
	public int countOfDepartmentCost(String department, String id) {
		return dao.countOfDepartmentCost(department, id);
	}

	@Override
	public List<PrjProgressFill> selectPrjProgressFillByYear(String status, String y) {
		return dao.selectPrjProgressFillByYear(status,y);
	}

	@Override
	public PrjProgressFill selectAllCostAndJd(String taskNo) {
		return dao.selectAllCostAndJd(taskNo);
	}

	@Override
	public List<PrjProgressFill> selectDepartmentIncome(String department, String start, String end) {
		return dao.selectDepartmentIncome(department, start, end);
	}

	@Override
	public PrjProgressFillInfo selectYearCostByDepartment(String department, String year) {
		return dao.selectYearCostByDepartment(department, year);
	}

	/*@Override
	public float selectTotalIncome(String time) {
		float money=0;
		List<PrjProgressFill> ppi=dao.selectPrjProgressFillByYear("2", time);
		if(ppi!=null){
			for(int i=0;i<ppi.size();i++){
				float prjMoney=ppi.get(i).getPrjMoney();
				String this_income=ppi.get(i).getPrjThisIncome().replace("%", "");
				float income=Float.valueOf(this_income);
				float come=prjMoney*income/100;
				money=money+come;
			}
		}
		return money;
	}

	@Override
	public float selectThisTimeIncomeByDepartment(String department, String time) {
		float money=0;
		List<PrjProgressFill> list=dao.selectThisTimeIncomeByDepartment(department, time);
		if(list!=null){
			for(int i=0;i<list.size();i++){
				float contractMoney=list.get(i).getPrjMoney();
				String income=list.get(i).getPrjThisIncome();
				income=income.replace("%", "");
				float bl=Float.valueOf(income);
				money=money+(contractMoney*bl/100);
			}
		}
		return money;
	}

	@Override
	public float selectThisTimeIncomeByDepartmentAndPrjType(String department, String time, String type) {
		float money=0;
		List<PrjProgressFill> list=dao.selectThisTimeIncomeByDepartmentAndPrjType(department, time, type);
		if(list!=null){
			for(int i=0;i<list.size();i++){
				float contractMoney=list.get(i).getPrjMoney();
				String income=list.get(i).getPrjThisIncome();
				income=income.replace("%", "");
				float bl=Float.valueOf(income);
				money=money+(contractMoney*bl/100);
			}
		}
		return money;
	}*/

	@Override
	public List<PrjProgressFill> selectNewest() {
		List<PrjProgressFill> list=dao.selectNewest();
		return list;
	}

	@Transactional
	@Override
	public int updatePrjProgressFill(PrjProgressFill ppf) {
		int i=dao.updatePrjProgressFill(ppf);
		String id=ppf.getPpfId();
		if(i>0){
			i=dao.deletePrjProgressFillInfoById(id);
			List<PrjProgressFillInfo> ppfi=ppf.getPpfi();
			for(int a=0;a<ppfi.size();a++){
				ppfi.get(a).setPpfId(id);
			}
			if(ppfi!=null){
				i=dao.addPrjProgressFillInfo(ppfi);
			}
			
			/*List<PrjProgressFillInfo> ppfi2=ppf.getPpfi2();
			for(int a=0;a<ppfi2.size();a++){
				ppfi2.get(a).setPpfId(id);
			}
			if(ppfi2!=null){
				i=dao.addPrjProgressFillInfo(ppfi2);
			}*/
			
			/*i=dao.deletePrjProgressFillCjById(id);
			List<PrjProgressFillCj>ppcj=ppf.getPpcj();
			for(int a=0;a<ppcj.size();a++){
				ppcj.get(a).setPpfId(id);
			}
			if(ppcj!=null){
				for(int ii=0;ii<ppcj.size();ii++){
					i=dao.addPrjProgressFillCj(ppcj.get(ii));
				}
			}*/
			
			List<Accessory> accessory=ppf.getAccessory();
			if(accessory !=null && accessory.size()!=0){
				i=aDao.addAccessory(accessory);
			}
		}
		return i;
	}

	/*@Transactional
	@Override
	public int updateAllIncomeAndCost(PrjProgressFill ppf) {
		int i=dao.updateAllIncomeAndCost(ppf);
		if(i>0){
			List<PrjProgressFillInfo> ppfi3=ppf.getPpfi3();
			if(ppfi3!=null){
				i=dao.addPrjProgressFillInfo(ppfi3);
			}
			List<PrjProgressFillInfo> ppfi4=ppf.getPpfi4();
			if(ppfi4!=null){
				i=dao.addPrjProgressFillInfo(ppfi4);
			}
			List<PrjProgressFillInfo> ppfi5=ppf.getPpfi5();
			if(ppfi5!=null){
				i=dao.addPrjProgressFillInfo(ppfi5);
			}
			List<PrjProgressFillInfo> ppfi6=ppf.getPpfi6();
			if(ppfi6!=null){
				i=dao.addPrjProgressFillInfo(ppfi6);
			}
		}
		return i;
	}*/

	@Override
	public CjContract selectCjContractAndPrjProgressFillCj(String no) {
		return dao.selectCjContractAndPrjProgressFillCj(no);
	}

	@Override
	public int addPrjProgressFillFb(List<PrjProgressFillFb> fb) {
		return dao.addPrjProgressFillFb(fb);
	}

	@Override
	public PrjProgressFillFb selectPrjProgressFillFbByFbId(String id) {
		return dao.selectPrjProgressFillFbByFbId(id);
	}

	@Override
	public PrjProgressFillCj selectPrjProgressFillCjIncomeBq(String id, String bq) {
		PrjProgressFillCj cj=dao.selectPrjProgressFillCjIncomeBq(id, bq);
		return cj;
	}

	@Override
	public PrjProgressFillInfo selectPrjProgressFillInfoTotalByTaskAndDept(String no, String dept) {
		return dao.selectPrjProgressFillInfoTotalByTaskAndDept(no, dept);
	}

	@Override
	public  List<PrjProgressFillFb>  selectPrjProgressFillFbByPpfId(String id) {
		return dao.selectPrjProgressFillFbByPpfId(id);
	}

	@Override
	public PrjProgressFill selectGsIncomeByTime(String time) {
		time="%"+time+"%";
		return dao.selectGsIncomeByTime(time);
	}

	@Override
	public PrjProgressFill selectGsIncomeByTimeAndDept(String time, String dept) {
		time="%"+time+"%";
		return dao.selectGsIncomeByTimeAndDept(time, dept);
	}

	@Override
	public PrjProgressFill selectDeptIncomeByTimeAndType(String time, String dept, String type) {
		time="%"+time+"%";
		type="%"+type+"%";
		return dao.selectDeptIncomeByTimeAndType(time, dept, type);
	}

	@Override
	public PrjProgressFill selectTotalIncome(String dept, String start, String end) {
		return dao.selectTotalIncome(dept, start, end);
	}

	@Override
	public PrjProgressFill selectNewPlanByTaskNo(String no) {
		return dao.selectNewPlanByTaskNo(no);
	}

}
