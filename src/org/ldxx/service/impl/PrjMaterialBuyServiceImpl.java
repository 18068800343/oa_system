package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.dao.PrjMaterialBuyDao;
import org.ldxx.service.PrjMaterialBuyService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrjMaterialBuyServiceImpl implements PrjMaterialBuyService{

	@Autowired
	private PrjMaterialBuyDao dao;
	@Autowired
	private MaterialDemandDao mdao;
	
	@Transactional
	@Override
	public int addPrjMaterialBuy(PrjMaterialBuy buy) {
		int i=dao.addPrjMaterialBuy(buy);
		String id=buy.getPmbId();
		if(i>0){
			List<MaterialDemand> md=buy.getMd();
			TimeUUID uuid=new TimeUUID();
			if(md!=null){
				for(int a=0;a<md.size();a++){
					md.get(a).setBuyId(id);
					md.get(a).setMdlId(uuid.getTimeUUID());
				}
				i=mdao.addMaterialDemand(md);
			}
		}
		return i;
	}

	@Override
	public List<PrjMaterialBuy> selectPrjMaterialBuy(String status) {
		return dao.selectPrjMaterialBuy(status);
	}

	@Override
	public int selectPrjMaterialBuyCount() {
		return dao.selectPrjMaterialBuyCount();
	}

	@Override
	public List<PrjMaterialBuy> selectBuyCode() {
		return dao.selectBuyCode();
	}

	@Override
	public List<PrjMaterialBuy> selectBuyByIds(String ids) {
		List<PrjMaterialBuy> list=new ArrayList<PrjMaterialBuy>();
		for(int a=0;a<ids.split(",").length;a++){
			PrjMaterialBuy buy=dao.selectBuyById(ids.split(",")[a]);
			list.add(buy);
		}
		return list;
	}

	@Override
	public List<PrjMaterialBuy> selectBuyByname(String name) {
		return dao.selectBuyByname(name);
	}

	@Override
	public List<PrjMaterialBuy> selectDepartmentAndMoney() {
		return dao.selectDepartmentAndMoney();
	}

	@Override
	public List<PrjMaterialBuy> selectDepartmentlike(String bumen) {
		bumen="%"+bumen+"%";
		return dao.selectDepartmentlike(bumen);
	}

	@Override
	public PrjMaterialBuy selectPrjMaterialBuyById(String id) {
		PrjMaterialBuy buy= dao.selectPrjMaterialBuyById(id);
		if(buy!=null){
			List<MaterialDemand> list = mdao.getMdById(id);
			buy.setMd(list);
		}
		return buy;
	}

	@Override
	public int updateXMById(PrjMaterialBuy buy) {
		return dao.updateXMById(buy);
	}

	@Override
	public int updateById(PrjMaterialBuy buy) {
		int i=dao.updateById(buy);
		if(i>0){
			i=mdao.deleteBybuyId(buy.getPmbId());
			List<MaterialDemand> md = buy.getMd();
			if(md!=null&&md.size()!=0){
				TimeUUID uuid=new TimeUUID();
				for(int a=0;a<md.size();a++){
					md.get(a).setBuyId(buy.getPmbId());
					md.get(a).setMdlId(uuid.getTimeUUID());
				}
				i=mdao.addMaterialDemand(md);
			}
		}
		return i;
	}

}
