package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMaterialInCl;
import org.ldxx.bean.outRemain;
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
	public List<CompanyMateriaIn> getGsMaterialIn() {
		List<CompanyMateriaIn> list= gmDao.getGsMaterialIn();
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<CompanyMaterialInCl> clList=gsInCldao.selectByGsInId(list.get(i).getCmId());
				if(clList!=null&&clList.size()>0){
					list.get(i).setGsInCl(clList);
				}
			}
		}
		return list;
	}
	
	@Override
	public List<CompanyMateriaIn> selectGsMaterialIn(String outState) {
		List<CompanyMateriaIn> list= gmDao.selectGsMaterialIn(outState);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<CompanyMaterialInCl> clList=gsInCldao.selectByGsInId(list.get(i).getCmId());
				if(clList!=null&&clList.size()>0){
					list.get(i).setGsInCl(clList);
				}
			}
		}
		return list;
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
					if("3".equals(cm.getOutState())){//结余转出入库去修改材料结余剩余数量
						outRemain outRemain = gsInCl.get(j).getOutRemain();
						i=clremaindao.updateRemainNumById(outRemain.getId(),outRemain.getRemain());
					}
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
			List<CompanyMaterialInCl> gsIncl=gsInCldao.selectByGsInId(id);
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
			if(accessory!=null&&accessory.size()>0){
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
		List<CompanyMateriaIn> list=gmDao.selectMateriaOutForEnd(no,type);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<CompanyMaterialInCl> clList=gsInCldao.selectGsInClById(list.get(i).getCmId());
				if(clList!=null&&clList.size()>0){
					list.get(i).setGsInCl(clList);
				}
			}
		}
		return list;
	}

	@Override
	public int updateremainType(String id, String type) {
		int i=0;
		if(type.equals("0")){//拒绝结余就去项目材料表修改库存数量并去结余材料表删除材料信息
			List<ClRemain> clRemain = clremaindao.selectClRemainById(id);
			if(clRemain!=null){
				for(int k=0;k<clRemain.size();k++){
					i=gsInCldao.updateSumClRemainById(clRemain.get(k).getOldClId(),clRemain.get(k).getCmoNumber() );
				}
				if(i>0){
					i=clremaindao.deleteClremainByGsoutId(id);
				}
			}
		}
		i=gmDao.updateremainType(id, type);
		return i;
	}

	@Override
	public List<CompanyMateriaIn> selectGsMateriaOutForEnd(String no) {
		return gmDao.selectGsMateriaOutForEnd(no);
	}

	@Override
	public List<CompanyMateriaIn> selectAlearyRemain() {
		List<CompanyMateriaIn> list = gmDao.selectAlearyRemain();
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<ClRemain> selectGsInClById = clremaindao.selectClRemainById(list.get(i).getCmId());
				if(selectGsInClById!=null&&selectGsInClById.size()!=0){
					list.get(i).setClremain(selectGsInClById);
				}
			}
		}
		return list;
	}

	@Override
	public List<CompanyMateriaIn> selectGsMateriaOutForEnd2(String no) {
		return gmDao.selectGsMateriaOutForEnd2(no);
	}

	@Override
	public List<CompanyMateriaIn> selectBytaskNo(String no) {
		List<CompanyMateriaIn> list=gmDao.selectBytaskNo(no);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<CompanyMaterialInCl> clList=gsInCldao.selectByGsInId(list.get(i).getCmId());
				if(clList!=null&&clList.size()>0){
					list.get(i).setGsInCl(clList);
				}
			}
		}
		return list;
	}

	@Override
	public List<CompanyMateriaIn> selectByoutStateAndgetState(String outstate, String getstate) {
		List<CompanyMateriaIn> list = gmDao.selectByoutStateAndgetState(outstate,getstate);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<CompanyMaterialInCl> clList=gsInCldao.selectByGsInId(list.get(i).getCmId());
				if(clList!=null&&clList.size()>0){
					list.get(i).setGsInCl(clList);
				}
			}
		}
		return list;
	}

	@Override
	public List<CompanyMateriaIn> selectBygetDepartment(String getDepartment) {
		List<CompanyMateriaIn> list=gmDao.selectBygetDepartment(getDepartment);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<CompanyMaterialInCl> clList=gsInCldao.selectByGsInId(list.get(i).getCmId());
				if(clList!=null&&clList.size()>0){
					list.get(i).setGsInCl(clList);
				}
			}
		}
		return list;
	}

	@Override
	public List<CompanyMateriaIn> selectAlreadySure(String getstate,String useromId) {
		return gmDao.selectAlreadySure(getstate,useromId);
	}

	@Override
	public List<CompanyMateriaIn> selectGsRemainOut(String outState, String getStatus, String remainType) {
		List<CompanyMateriaIn> list=gmDao.selectGsRemainOut(outState,getStatus,remainType);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				List<ClRemain> selectGsInClById = clremaindao.selectClRemainById(list.get(i).getCmId());
				if(selectGsInClById!=null&&selectGsInClById.size()!=0){
					list.get(i).setClremain(selectGsInClById);
				}
			}
		}
		return list;
	}

	@Override
	public List<CompanyMateriaIn> selectXmInByNo(String no, String outstate, String useromId) {
		return gmDao.selectXmInByNo(no,outstate,useromId);
	}

	@Override
	public List<CompanyMateriaIn> selectXmInBybm(String getDepartment, String useromId) {
		List<CompanyMateriaIn> list=gmDao.selectXmInBybm(getDepartment,useromId);
		return list;
	}

}
