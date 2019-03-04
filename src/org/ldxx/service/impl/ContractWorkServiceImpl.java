package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Task;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.ContractWorkDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.service.ContractWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWorkServiceImpl implements ContractWorkService{

	@Autowired
	private ContractWorkDao dao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private EnterpriseDao edao;
	@Autowired
	private TaskDao tdao;
	@Autowired
	private CjContractDao cDao;
	
	@Transactional
	@Override
	public int addContractWork(ContractWork work) {
		int i=dao.addContractWork(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				i=adao.addAccessory(accessory);
			}
			/*List<Accessory> accessory1=work.getAccessory1();
			if(accessory1!=null){
				i=adao.addAccessory(accessory1);
			}*/
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null&&enterprise.size()!=0){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				i=edao.addEnterprise(enterprise);
			}
			List<Task> task=work.getTaskArray();
			i=tdao.updateTasks(task);
			i=cDao.updateCjContractMoney(work.getCjContractCode(), work.getEndMoney());
		}
		return i;
	}

	@Override
	public List<ContractWork> selectContractWork(String type,String status) {
		return dao.selectContractWork(type,status);
	}

	@Override
	public ContractWork selectContractWorkByNo(String no) {
		return dao.selectContractWorkByNo(no);
	}

	@Override
	public ContractWork getContractMoney(String no) {
		return dao.getContractMoney(no);
	}

	@Override
	public ContractWork selectContractWorkByid(String id) {
		return dao.selectContractWorkByid(id);
	}

	@Override
	public ContractWork selectContractWorkBytaskNoAndCno(String no, String type) {
		return dao.selectContractWorkBytaskNoAndCno(no,type);
	}

	@Transactional
	@Override
	public int updateContractWork2(ContractWork work) {
		int i=dao.updateContractWork2(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				i=adao.addAccessory(accessory);
			}
			edao.deleteEnterprise(id);
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null&&enterprise.size()!=0){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				i=edao.addEnterprise(enterprise);
			}
		}
		return i;
	}
	
	@Transactional
	@Override
	public int updateContractWork3(ContractWork work) {
		int i=dao.updateContractWork3(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			i=edao.deleteEnterprise(id);
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				i=edao.addEnterprise(enterprise);
			}
		}
		return i;
	}

	@Override
	public List<ContractWork> selectContractWorkByprjNo(String pNo,String type) {
		return dao.selectContractWorkByprjNo(pNo,type);
	}

}
