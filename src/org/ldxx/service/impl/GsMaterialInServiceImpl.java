package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMaterialInCl;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ClRemainDao;
import org.ldxx.dao.GsMaterialInClDao;
import org.ldxx.dao.GsMaterialInDao;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.service.GsMaterialInService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GsMaterialInServiceImpl implements GsMaterialInService {
	
	@Autowired
	private GsMaterialInDao gmDao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private MaterialDemandDao mdao;
	@Autowired
	private GsMaterialInClDao gsInCldao;
	@Autowired
	private ClRemainDao clremaindao;
	
	@Override
	public List<CompanyMateriaIn> selectGsMaterialIn(String outState) {
		return gmDao.selectGsMaterialIn(outState);
	}

	@Override
	public int addGsMaterialInSave(CompanyMateriaIn cm) {
		int i=gmDao.addGsMaterialInSave(cm);
		if(i>0){
			List<Accessory> accessory=cm.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<CompanyMaterialInCl> gsInCl = cm.getGsInCl();
			if(gsInCl!=null&&gsInCl.size()>0){
				for(int j=0;j<gsInCl.size();j++){
					TimeUUID uuid=new TimeUUID();
					String id=uuid.getTimeUUID();
					gsInCl.get(j).setClId(id);
					gsInCl.get(j).setGsInId(cm.getCmId());
				}
				i=gsInCldao.addGsInCl(gsInCl);
			}
		}
		return i;
	}


	@Override
	public CompanyMateriaIn selectGsClInById(String id) {
		CompanyMateriaIn gs=gmDao.selectGsClInById(id);
		if(gs!=null){
			List<Accessory> accessory = adao.selectAccessoryById(id);
			if(accessory!=null&&accessory.size()>0){
				gs.setAccessory(accessory);
			}
			List<CompanyMaterialInCl> gsIncl=gsInCldao.selectGsInClById(id);
			if(gsIncl!=null&&gsIncl.size()>0){
				gs.setGsInCl(gsIncl);
			}
		}
		return gs;
	}

	@Override
	public List<CompanyMateriaIn> selectcgNotaskNoPrjName() {
		return gmDao.selectcgNotaskNoPrjName();
	}

	@Override
	public List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo) {
		return gmDao.selecttaskNoPrjNameBycgNo(cgNo);
	}

	@Override
	public List<CompanyMateriaIn> selectcgNotaskNoPrjNameBycgName(String cgName) {
		return gmDao.selectcgNotaskNoPrjNameBycgName(cgName);
	}

	@Override
	public int updateGsMaterialInSave(CompanyMateriaIn cm) {
		int i=gmDao.updateGsMaterialInSave(cm);
		if(i>0){
			List<Accessory> accessory=cm.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
			List<CompanyMaterialInCl> gsInCl = cm.getGsInCl();
			List<CompanyMaterialInCl> gsInClById = gsInCldao.selectGsInClById(cm.getCmId());
			if(gsInClById!=null&&gsInClById.size()>0){
				i=gsInCldao.deleteGsInClById(cm.getCmId());
				if(i>0 && gsInCl!=null && gsInCl.size()>0){
					for(int j=0;j<gsInCl.size();j++){
						TimeUUID uuid=new TimeUUID();
						String id=uuid.getTimeUUID();
						gsInCl.get(j).setClId(id);
						gsInCl.get(j).setGsInId(cm.getCmId());
					}
					i=gsInCldao.addGsInCl(gsInCl);
				}
			}
		}
		return i;
	}

	@Override
	public int updateMaterialbuyUnitAndManufacturer(String id,String unit, String manufacturer) {
		return mdao.updateMaterialbuyUnitAndManufacturer(id,unit,manufacturer);
	}

	@Override
	public int updateOutStateById(String id,String outstate) {
		return gmDao.updateOutStateById(id,outstate);
	}

	@Override
	public List<CompanyMateriaIn> selectXmMaterialByNo(String no, String outstate) {
		return gmDao.selectXmMaterialByNo(no,outstate);
	}

	@Override
	public int updateXmState(CompanyMateriaIn gsIncl) {
		int i=gmDao.updateXmState(gsIncl);
		if(i>0){
			List<Accessory> accessory=gsIncl.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<CompanyMateriaIn> selectAllXmReceivedGoods() {
		return gmDao.selectAllXmReceivedGoods();
	}

	@Override
	public List<CompanyMaterialInCl> selectGsClInBytaskNo(String no) {
		return gsInCldao.selectGsClInBytaskNo(no);
	}

	@Override
	public List<CompanyMateriaIn> selectMateriaOutForEnd(String no,String type) {
		return gmDao.selectMateriaOutForEnd(no,type);
	}

	@Override
	public int updateremainType(String id, String type) {
		int i=0;
		if(type.equals("0")){//拒绝结余就去结余材料表删除材料信息并去项目材料表修改库存数量
			List<ClRemain> clRemain = clremaindao.selectClRemainById(id);
			if(clRemain!=null){
				for(int k=0;k<clRemain.size();k++){
					CompanyMaterialInCl cl=gsInCldao.selectClByCrId(clRemain.get(k).getCrId());
					int value=Integer.parseInt(cl.getClRemain())+clRemain.get(k).getCmoNumber();
					i=gsInCldao.updateSumClRemainById(clRemain.get(k).getCrId(),value );
				}
				if(i>0){
					i=clremaindao.deleteClremainByGsoutId(id);
				}
			}
		}
		i=gmDao.updateremainType(id, type);
		return i;
	}



}
