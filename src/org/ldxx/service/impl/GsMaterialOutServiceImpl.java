package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.GsClOutDao;
import org.ldxx.dao.GsMaterialOutDao;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GsMaterialOutServiceImpl implements GsMaterialOutService {

	@Autowired
	private GsMaterialOutDao dao;
	@Autowired
	private AccessoryDao adao;
	
	@Autowired
	private GsClOutDao gdao;
	
	@Override
	public List<CompanyMateriaOut> selectGsMaterialOut() {
		return dao.selectGsMaterialOut();
	}

	@Override
	public int addGsMaterialOutSave(CompanyMateriaOut cm) {
		List<GsClOut> gsClOut = cm.getGsClOut();
		int i = dao.addGsMaterialOutSave(cm);
		String id = cm.getCmoId();
		String date = cm.getPickDate();
		if(i>0){
			TimeUUID uuid=new TimeUUID();
			if(gsClOut!=null&&gsClOut.size()!=0){
				for(int k=0;k<gsClOut.size();k++){
					gsClOut.get(k).setGsId(uuid.getTimeUUID());
					gsClOut.get(k).setGsOutId(id);
					gsClOut.get(k).setPickDate(date);
				}
				i=gdao.addgsClOut(gsClOut);
			}
		}
		return i;
	}

	@Override
	public List<CompanyMateriaOut> selectXmMaterialOutByNo(String no) {
		no="%"+no+"%";
		return dao.selectXmMaterialOutByNo(no);
	}

	@Override
	public CompanyMateriaOut selectNoByName(String name) {
		return dao.selectNoByName(name);
	}

	@Override
	public CompanyMateriaOut selectNameByNo(String no) {
		return dao.selectNameByNo(no);
	}

	@Transactional
	@Override
	public int updateStatus(CompanyMateriaOut out) {
		int i=dao.updateStatus(out);
		if(i>0){
			List<Accessory> accessory=out.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<CompanyMateriaOut> selectAllXmMaterialOut() {
		return dao.selectAllXmMaterialOut();
	}

	@Override
	public List<CompanyMateriaOut> selectCompanyMateriaOutForEnd(String no) {
		no="%"+no+"%";
		return dao.selectCompanyMateriaOutForEnd(no);
	}

	@Override
	public List<CompanyMateriaOut> selectCompanyMateriaOutForWaste(String no) {
		no="%"+no+"%";
		return dao.selectCompanyMateriaOutForWaste(no);
	}

	@Override
	public List<CompanyMateriaOut> selectCgIdAndName() {
		return dao.selectCgIdAndName();
	}

	@Override
	public List<CompanyMateriaOut> selectTaskByNo(String no) {
		return dao.selectTaskByNo(no);
	}

	@Override
	public List<CompanyMateriaOut> selectTaskByName(String name) {
		return dao.selectTaskByName(name);
	}

}
