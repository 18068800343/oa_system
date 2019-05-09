package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjDeptSplitMoney;
import org.ldxx.bean.CjSplitMoney;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CjContractDao;
import org.ldxx.service.CjContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CjContractServiceImpl implements CjContractService{

	@Autowired
	private CjContractDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addCjContract(CjContract cj) {
		int i=dao.addCjContract(cj);
		if(i>0){
			List<Accessory> accessory=cj.getAccessory();
			if(accessory!=null){
				adao.addAccessory(accessory);
			}
			List<Accessory> accessory2=cj.getAccessory2();
			if(accessory2!=null){
				adao.addAccessory(accessory2);
			}
			/*List<CjSplitMoney> cjSplitMoney = cj.getCjSplitMoney();
			for(int j=0;j<cjSplitMoney.size();j++){
				cjSplitMoney.get(j).setCjId(cj.getCjId());
			}
			if(cjSplitMoney!=null&& cjSplitMoney.size()>0){
				i = dao.addCjSplitMoneySave(cjSplitMoney);
			}
			List<CjDeptSplitMoney> cjDeptSplitMoney=cj.getCjDeptSplitMoney();
			for(int ii=0;ii<cjDeptSplitMoney.size();ii++){
				cjDeptSplitMoney.get(ii).setId(cj.getCjId());
			}
			if(cjDeptSplitMoney!=null&& cjDeptSplitMoney.size()>0){
				i = dao.addCjDeptSplitMoney(cjDeptSplitMoney);
			}*/
		}
		return i;
	}

	@Transactional
	@Override
	public int updateCjContract(CjContract cj) {
		int i=dao.updateCjContract(cj);
		if(i>0){
			dao.deleteCjSplitMoneyById(cj.getCjId());
			List<CjSplitMoney> cs=cj.getCjSplitMoney();
			if(null!=cs&&cs.size()>0){
				dao.addCjSplitMoneySave(cs);
			}
			List<Accessory> accessory=cj.getAccessory();
			if(accessory!=null){
				adao.addAccessory(accessory);
			}
			List<Accessory> accessory2=cj.getAccessory2();
			if(accessory2!=null){
				adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public List<CjContract> selectCjContractByStatus(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String xbDp,Double contractMoneyMin,Double contractMoneyMax,Double zdMoneyMin,Double zdMoneyMax) {
		List<CjContract> list = dao.selectCjContractByStatus(status, startMin, startMax, endMin, endMax, mainDp, xbDp, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getCjId();
			List<CjSplitMoney> cjSplitMoney=dao.selectCjSplitMoneyById(id);
			list.get(i).setCjSplitMoney(cjSplitMoney);
		}
		return list;
	}

	@Override
	public CjContract selectCjContractById(String id) {
		return dao.selectCjContractById(id);
	}

	@Override
	public int deleteCjContract(String id) {
		return 0;
	}

	@Override
	public List<CjContract> selectIdAndName() {
		return dao.selectIdAndName();
	}

	@Override
	public List<CjContract> selectContractNoById(String id) {
		return dao.selectContractNoById(id);
	}

	@Override
	public List<CjContract> selectContractByTaskNo(String no) {
		return dao.selectContractByTaskNo(no);
	}

	@Override
	public List<CjContract> selectCjByName(String name) {
		return dao.selectCjByName(name);
	}

	@Override
	public List<CjContract> selectCjByNo(String no) {
		return dao.selectCjByNo(no);
	}

	@Override
	public List<CjContract> selectCjHistory(String no) {
		List<CjContract> list = dao.selectCjHistory(no);
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getCjId();
			List<CjSplitMoney> cjSplitMoney=dao.selectCjSplitMoneyById(id);
			list.get(i).setCjSplitMoney(cjSplitMoney);
		}
		return list;
	}

	@Override
	public int countNo(String year) {
		year="%"+year+"%";
		return dao.countNo(year);
	}

	@Override
	public List<CjContract> selectNameAndNo() {
		return dao.selectNameAndNo();
	}

	@Override
	public CjContract selectCjContractByName(String name) {
		return dao.selectCjContractByName(name);
	}

	@Override
	public CjContract selectCjContractByNo(String no) {
		return dao.selectCjContractByNo(no);
	}

	@Override
	public List<CjContract> selectCjContractByTaskNo(String no) {
		return dao.selectCjContractByTaskNo(no);
	}

	@Override
	public CjContract selectCjByCjNo(String no) {
		return dao.selectCjByCjNo(no);
	}

	@Override
	public List<CjContract> selectNoAndMoneyByDepartment(String department,String year) {
		return dao.selectNoAndMoneyByDepartment(department,year);
	}

	@Override
	public Double selectCjContractMoneyBySignTime(String time) {
		Double money=(double) 0;
		List<CjContract> cj=dao.selectCjContractMoneyBySignTime(time);
		if(cj!=null){
			for(int i=0;i<cj.size();i++){
				Double contractMoney=cj.get(i).getContractMoney();
				money=money+contractMoney;
			}
		}
		return money;
	}

	@Override
	public CjContract getCjContractMainDepartmentLeader(String no) {
		return dao.getCjContractMainDepartmentLeader(no);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= dao.updateHistoryById(id);

		i=dao.updateHistoryNow(id);
		
		return i;
	}

	@Override
	public List<CjDeptSplitMoney> selectCjDeptSplitMoney(String id, String dept) {
		return dao.selectCjDeptSplitMoney(id, dept);
	}

	@Override
	public CjContract selectCjContractLikeTaskNo(String no) {
		no="%"+no+"%";
		return dao.selectCjContractLikeTaskNo(no);
	}

	@Override
	public CjContract selectCjContractLikeTaskCode(String no) {
		return dao.selectCjContractLikeTaskCode(no);
	}

	@Override
	public int updateCjNoById(String no, String id) {
		return dao.updateCjNoById(no, id);
	}

	@Override
	public String CreateContractNumOrder(String type, String year) {
		return dao.CreateContractNumOrder(type, year);
	}

	@Override
	public int updateCjContractCancelReason(CjContract cj) {
		// TODO Auto-generated method stub
		return dao.updateCjContractCancelReason(cj);
	}

}
