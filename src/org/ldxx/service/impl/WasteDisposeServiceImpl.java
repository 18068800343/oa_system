package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.WasteDispose;
import org.ldxx.bean.WasteDisposeCl;
import org.ldxx.bean.outRemain;
import org.ldxx.dao.GsClOutDao;
import org.ldxx.dao.GsMaterialInClDao;
import org.ldxx.dao.WasteDisposeDao;
import org.ldxx.service.WasteDisposeService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WasteDisposeServiceImpl implements WasteDisposeService{

	@Autowired
	private WasteDisposeDao dao;
	/*@Autowired
	private GsClOutDao gDao;*/
	@Autowired
	private GsMaterialInClDao gsInCldao;
	
	@Override
	public List<WasteDispose> selectWasteDispose() {
		return dao.selectWasteDispose();
	}

	@Transactional
	@Override
	public int addWasteDispose(WasteDispose wd) {
		int i=dao.addWasteDispose(wd);
		if(i>0){
			List<WasteDisposeCl> wdc=wd.getWdc();
			List<outRemain> or=wd.getoRemain();
			for(int a=0;a<wdc.size();a++){
				wdc.get(a).setWpId(wd.getWpId());
			}
			i=dao.addWasteDisposeCl(wdc);
			i=gsInCldao.updateRemainForWaste(or);
		}
		return i;
	}

	@Override
	public List<WasteDisposeCl> selectWdById(String id) {
		return dao.selectWdById(id);
	}

	@Override
	public WasteDispose selectWasteDisposeById(String id) {
		WasteDispose wd=dao.selectWasteDisposeById(id);
		if(wd!=null){
			List<WasteDisposeCl> wdcl = dao.selectWdById(id);
			wd.setWdc(wdcl);
		}
		return wd;
	}

}
