package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.WxCost;
import org.ldxx.dao.WxCostDao;
import org.ldxx.service.WxCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxCostServiceImpl implements WxCostService{

	@Autowired
	private WxCostDao wxDao;
	
	@Override
	public int addWxCost(List<WxCost> wx) {
		return wxDao.addWxCost(wx);
	}

	@Override
	public List<WxCost> selectAllWxCost() {
		return wxDao.selectAllWxCost();
	}

}
