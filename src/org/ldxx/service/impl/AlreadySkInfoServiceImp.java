package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkInfo;
import org.ldxx.bean.AlreadySkOmInfo;
import org.ldxx.dao.AlreadySkInfoDao;
import org.ldxx.dao.FinancialReceiptsDao;
import org.ldxx.dao.ReceiveMoneyDao;
import org.ldxx.service.AlreadySkInfoService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlreadySkInfoServiceImp implements AlreadySkInfoService {
	
	@Autowired
	private AlreadySkInfoDao dao;
	@Autowired
	private ReceiveMoneyDao rmdao;

	@Override
	public int addAlreadySkInfo(AlreadySkInfo as, String uName) {
		int i = rmdao.updateStatus(as.getSkId(),as.getStatus());
		if(i>0){
			Float allSkMoney=dao.countallSkMoney(as.getTaskNo(),as.getContractNo());//通过任务单号和合同编号查累计收款金额
			as.setAllSkMoney(as.getAllSkMoney()+allSkMoney);
			i=dao.addAlreadySkInfo(as);
			if(i>0){
				List<AlreadySkOmInfo> asoList = as.getAsoList();
				for(int j=0;j<asoList.size();j++){
					AlreadySkOmInfo skOmInfo = asoList.get(j);
					TimeUUID uuid=new TimeUUID();
					String id=uuid.getTimeUUID();
					skOmInfo.setAoId(id);
					skOmInfo.setcId(as.getcId());
					skOmInfo.setOperatorPerson(uName);
					i=dao.addAlreadySkOmInfo(skOmInfo);
				}
			}
			
		}
		return i;
	}

	@Override
	public List<AlreadySkInfo> selectAlreadySkInfo() {
		List<AlreadySkInfo> list=dao.selectAlreadySkInfo();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				List<AlreadySkOmInfo> asmList=dao.selectAlreadySkOmInfoById(list.get(i).getcId());
				if(asmList.size()!=0){
					list.get(i).setAsoList(asmList);
				}
			}
		}
		return list;
	}

	@Override
	public AlreadySkInfo selectAlreadySkInfoByskId(String skId) {
		AlreadySkInfo as= dao.selectAlreadySkInfoByskId(skId);
		if(as!=null){
			List<AlreadySkOmInfo> asmList=dao.selectAlreadySkOmInfoById(as.getcId());
			if(asmList.size()!=0){
				as.setAsoList(asmList);
			}
		}
		return as;
	}

	@Override
	public int updateStatusBack(String id, String status,String cId) {
		int i = rmdao.updateStatus(id,status);
		if(i>0){
			i=dao.deleteAlreadySkInfoByskId(id);
			if(i>0){
				i=dao.deleteAlreadySkOmInfoById(cId);
			}
		}
		return i;
	}

	@Override
	public int countquerenNo() {
		return dao.countquerenNo();
	}

	@Override
	public int addAlreadyRenling(AlreadyRenling ar) {
		int i = rmdao.updateStatus(ar.getSkNo(),ar.getStatus());
		if(i>0){
			i=dao.addAlreadyRenling(ar);
			if(i>0){
				List<AlreadySkOmInfo> asoList = ar.getAsoList();
				for(int j=0;j<asoList.size();j++){
					AlreadySkOmInfo skOmInfo = asoList.get(j);
					TimeUUID uuid=new TimeUUID();
					String id=uuid.getTimeUUID();
					skOmInfo.setAoId(id);
					skOmInfo.setcId(ar.getrId());
					skOmInfo.setOperatorPerson(ar.getThisPerson());
					i=dao.addAlreadySkOmInfo(skOmInfo);
				}
			}
			
		}
		return i;
	}
	
}
