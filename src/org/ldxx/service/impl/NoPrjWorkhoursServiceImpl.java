package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.NoPrjWorkhours;
import org.ldxx.bean.NoPrjWorkhoursP;
import org.ldxx.dao.NoPrjWorkhoursDao;
import org.ldxx.dao.NoPrjWorkhoursPDao;
import org.ldxx.service.NoPrjWorkhoursService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoPrjWorkhoursServiceImpl implements NoPrjWorkhoursService {
	
	@Autowired
	private NoPrjWorkhoursDao dao;
	@Autowired
	private NoPrjWorkhoursPDao pdao;

	@Override
	public int addNoPrjWorkhours(NoPrjWorkhours no) {
		int i= dao.addNoPrjWorkhours(no);
		if(i>0){
			List<NoPrjWorkhoursP> workhoursP = no.getNoPrjWorkhoursP();
			if(workhoursP!=null&&workhoursP.size()!=0){
				String npId = no.getNpId();
				TimeUUID uuid=new TimeUUID();
				for(int j=0;j<workhoursP.size();j++){
					workhoursP.get(j).setpId(uuid.getTimeUUID());
					workhoursP.get(j).setNpId(npId);
				}
				i=pdao.addNoPrjWorkhoursP(workhoursP);
			}
		}
		return i;
	}

	@Override
	public int deleteNoPrjWorkhours(String id) {
		int i=dao.deleteNoPrjWorkhours(id);
		if(i>0){
			i=pdao.deleteNoPrjWorkhoursPByNpId(id);
		}
		return i;
	}

	@Override
	public int updateNoPrjWorkhours(NoPrjWorkhours no) {
		int i=dao.updateNoPrjWorkhours(no);
		if(i>0){
			pdao.deleteNoPrjWorkhoursPByNpId(no.getNpId());
			List<NoPrjWorkhoursP> workhoursP = no.getNoPrjWorkhoursP();
			if(workhoursP!=null&&workhoursP.size()!=0){
				String npId = no.getNpId();
				TimeUUID uuid=new TimeUUID();
				for(int j=0;j<workhoursP.size();j++){
					workhoursP.get(j).setpId(uuid.getTimeUUID());
					workhoursP.get(j).setNpId(npId);
				}
				i=pdao.addNoPrjWorkhoursP(workhoursP);
			}
		}
		return i;
	}

	@Override
	public List<NoPrjWorkhours> selectNoPrjWorkhours() {
		List<NoPrjWorkhours> noList=dao.selectNoPrjWorkhours();
		if(noList!=null&&noList.size()!=0){
			for(int i=0;i<noList.size();i++){
				String npId = noList.get(i).getNpId();
				List<NoPrjWorkhoursP> np=pdao.selectNoPrjWorkhoursPByNpId(npId);
				if(np!=null&&np.size()!=0){
					noList.get(i).setNoPrjWorkhoursP(np);
				}
			}
		}
		return noList;
	}

}
