package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;
import org.ldxx.bean.outRemain;
import org.ldxx.dao.ClOutDao;
import org.ldxx.dao.GsMaterialInClDao;
import org.ldxx.dao.GsMaterialOutDao;
import org.ldxx.service.ClOutService;
import org.ldxx.service.GsClOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClOutServiceImpl implements ClOutService{

	@Autowired
	private ClOutDao cdao;
	@Autowired
	private GsMaterialInClDao gsInCldao;
	
	@Override
	public int addClOut(ClOut out) {
		int i=cdao.addClOut(out);
		if(i>0){
			List<ClOutInfo> cInfo=out.getcInfo();
			if(cInfo!=null){
				for(int a=0;a<cInfo.size();a++){
					cInfo.get(a).setOutId(out.getOutId());
				}
				i=cdao.addClOutInfo(cInfo);
				if(i>0){
					for(int a=0;a<cInfo.size();a++){
						outRemain or=cInfo.get(a).getOutRemain();
						i=gsInCldao.updateRemain(or.getId(), or.getRemain());
					}
				}
			}
		}
		return i;
	}

	@Override
	public List<ClOut> selectClOutByNo(String no,String useromId) {
		return cdao.selectClOutByNo(no,useromId);
	}

	@Override
	public List<ClOutInfo> selectClOutInfoById(String id) {
		return cdao.selectClOutInfoById(id);
	}

	

	

}
