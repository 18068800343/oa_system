package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.MaterialDemand;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.dao.PrjMaterialBuyDao;
import org.ldxx.service.MaterialDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaterialDemandServiceImpl implements MaterialDemandService{

	@Autowired
	private MaterialDemandDao dao;
	@Autowired
	private PrjMaterialBuyDao pdao;
	
	@Override
	public int addMaterialDemand(List<MaterialDemand> md) {
		return dao.addMaterialDemand(md);
	}

	@Override
	public List<MaterialDemand> selectMaterialDemandById(String id) {
		return dao.selectMaterialDemandById(id);
	}

	@Transactional
	@Override
	public int updateMd(List<MaterialDemand> md) {
		String id=md.get(0).getMdlId();
		int i=dao.deleteMdById(id);
		if(i>0){
			i=dao.addMaterialDemand(md);
			if(i>0){
				Double sumPrice=(double) 0;
				for(int a=0;a<md.size();a++){
					int num=md.get(a).getNum();
					Double price=md.get(a).getPrice();
					Double sum=num*price;
					sumPrice=sumPrice+sum;
				}
				i=pdao.updateSumPrice(sumPrice, id);
			}
		}
		return i;
	}

	@Override
	public int updateMaterialDemand(String id, int number) {
		return dao.updateMaterialDemand(id,number);
	}

	
}
