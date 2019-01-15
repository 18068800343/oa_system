package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.AlreadyRenling;
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
					skOmInfo.setRId(ar.getrId());
					skOmInfo.setOperatorPerson(ar.getThisPerson());
					i=dao.addAlreadySkOmInfo(skOmInfo);
				}
			}
			
		}
		return i;
	}

	@Override
	public AlreadyRenling getyirenlingfpMoneyByKpno(String kpno) {
		return dao.getyirenlingfpMoneyByKpno(kpno);
	}

	@Override
	public List<AlreadyRenling> selectAlreadyRenling() {
		return dao.selectAlreadyRenling();
	}

	@Override
	public List<AlreadyRenling> selectAlreadySkBySkno(String skno) {
		return dao.selectAlreadySkBySkno(skno);
	}

	@Override
	public int deleteAlreadyRenlingById(String rId) {
		int i=dao.deleteAlreadyRenlingById(rId);
		if(i>0){
			i=dao.deleteAlreadySkOmInfoByrId(rId);
		}
		return i;
	}

	@Override
	public AlreadyRenling selectGsRenlingByTime(String time) {
		time="%"+time+"%";
		return dao.selectGsRenlingByTime(time);
	}

	@Override
	public AlreadyRenling selectDeptRenlingByTime(String time, String dept) {
		time="%"+time+"%";
		return dao.selectDeptRenlingByTime(time, dept);
	}

	@Override
	public AlreadyRenling selectDeptRenlingByTimeAndType(String time, String dept, String type) {
		time="%"+time+"%";
		type="%"+type+"%";
		return dao.selectDeptRenlingByTimeAndType(time, dept, type);
	}
	
}
