package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.dao.PrjMaterialBuyDao;
import org.ldxx.service.PrjMaterialBuyService;
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
			if(md!=null){
				for(int a=0;a<md.size();a++){
					md.get(a).setMdlId(id);
				}
				i=mdao.addMaterialDemand(md);
			}
		}
		return i;
	}

	@Override
	public List<PrjMaterialBuy> selectPrjMaterialBuy() {
		return dao.selectPrjMaterialBuy();
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

}
