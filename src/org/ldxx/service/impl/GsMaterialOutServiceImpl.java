package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ClRemainDao;
import org.ldxx.dao.GsClOutDao;
import org.ldxx.dao.GsMaterialOutDao;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.service.PrjMaterialBuyService;
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
	@Autowired
	private MaterialDemandDao mddao;
	@Autowired
	private PrjMaterialBuyService buyservice;
	@Autowired
	private ClRemainDao clRemaindao;
	
	@Override
	public List<CompanyMateriaOut> selectGsMaterialOut(String status) {
		return dao.selectGsMaterialOut(status);
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
			List<MaterialDemand> md = cm.getMd();
			if(md!=null){
				for(int j=0;j<md.size();j++){
					//修改材料剩余数量
					i=mddao.updateMaterialDemand(md.get(j).getMdlId(), md.get(j).getRemainNumber());
				}
			}
			List<ClRemain> clRemain = cm.getClRemain();
			if(clRemain!=null){//修改结余材料的数目
				for(int k=0;k<clRemain.size();k++){
					ClRemain cr=new ClRemain();
					cr.setCrId(clRemain.get(k).getCrId());
					cr.setCmoNumber(clRemain.get(k).getCmoNumber());
					cr.setRemainNumber(clRemain.get(k).getRemainNumber());
					cr.setCmoMoney(clRemain.get(k).getCmoMoney());
					i=clRemaindao.updateClRemainNum(cr);
				}
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

	@Override
	public List<CompanyMateriaOut> selectGSmaterialRemain(int remainType) {
		return dao.selectGSmaterialRemain(remainType);
	}

	@Override
	public List<CompanyMateriaOut> selectGsMaterialRemainByname(int remainType,String name) {
		return dao.selectGsMaterialRemainByname(remainType,name);
	}

	@Override
	public List<CompanyMateriaOut> selectGsMaterialRemainByno(int remainType, String no) {
		return dao.selectGsMaterialRemainByno(remainType,no);
	}

	@Override
	public CompanyMateriaOut selectGsMaterialOutById(String id) {
		CompanyMateriaOut cm= dao.selectGsMaterialOutById(id);
		List<PrjMaterialBuy> list = buyservice.selectBuyByname(cm.getPickProject());
		if(list!=null){
			cm.setPrjMaterialBuy(list);
		}
		List<GsClOut> gsclout = gdao.selectClByNo(cm.getCmoId());
		if(gsclout!=null){
			cm.setGsClOut(gsclout);
		}
		return cm;
	}

}
