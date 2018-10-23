package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.outRemain;
import org.ldxx.dao.ClRemainDao;
import org.ldxx.dao.GsClOutDao;
import org.ldxx.dao.GsMaterialOutDao;
import org.ldxx.service.ClRemainService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClRemainServiceImpl implements ClRemainService{

	@Autowired
	private ClRemainDao dao;
	
	@Autowired
	private GsMaterialOutDao gdao;
	
	@Autowired
	private GsClOutDao goDao;
	
	@Transactional
	@Override
	public int addClRemain(List<ClRemain> cr) {
		int i=dao.addClRemain(cr);
		if(i>0){
			String id=cr.get(0).getGsOutId();
			i=gdao.updateRemainStatus(id);
			i=goDao.updateRemainForEnd(id);
		}
		return i;
	}

	@Override
	public List<GsClOut> selectGsClOutById(String id) {
		return dao.selectGsClOutById(id);
	}

	@Transactional
	@Override
	public int remainUse(CompanyMateriaOut cm) {
		int i=gdao.addGsMaterialOutSave(cm);
		if(i>0){
			TimeUUID uuid=new TimeUUID();
			String id=cm.getCmoId();
			List<GsClOut> gsout=cm.getGsClOut();
			for(int a=0;a<gsout.size();a++){
				gsout.get(a).setGsOutId(id);
				gsout.get(a).setGsId(uuid.getTimeUUID());
			}
			i=goDao.addgsClOut(gsout);
			List<outRemain> out=cm.getoRemain();
			i=dao.updateClRemain(out);		
		}
		return i;
	}

	@Override
	public int updateClRemain(List<outRemain> out) {
		return dao.updateClRemain(out);
	}

	@Override
	public List<ClRemain> selectClRemainById(String id) {
		return dao.selectClRemainById(id);
	}

	@Override
	public int updateClRemainNum(ClRemain cr) {
		return dao.updateClRemainNum(cr);
	}

}
