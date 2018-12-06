package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.FinancialTables;
import org.ldxx.dao.FinancialReceipts2Dao;
import org.ldxx.service.FinancialReceipts2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialReceipts2ServiceImpl implements FinancialReceipts2Service{

	@Autowired
	private FinancialReceipts2Dao dao;
	
	@Override
	public List<FinancialTables> selectfinancialTables() {
		return dao.selectfinancialTables();
	}

	@Override
	public List<FinancialTables> selectfinancialTablesByState(String state) {
		return dao.selectfinancialTablesByState(state);
	}

	@Override
	public int updateState(String state, String id) {
		return dao.updateState(state, id);
	}

	@Override
	public List<FinancialReceipts> selectFinancialReceiptsByYear(String status, String y) {
		return dao.selectFinancialReceiptsByYear(status,y);
	}

	@Override
	@SuppressWarnings("unchecked")
	public int addFinancialReceipts2(Map<String, Object> map) {
		List<FinancialTables> list = (List<FinancialTables>) map.get("fR2");
		int num=0;
		if(list.size()!=0){
			for(int i=0;i<list.size();i++){
				String no=list.get(i).gettNo();
				String name = list.get(i).gettName();
				String department = list.get(i).gettDepartment();
				float collectionValue = list.get(i).gettCollectionValue();
				String desc = list.get(i).gettDesc();
				String time = list.get(i).gettTime();
				FinancialTables CollectionValue2=dao.selectValueByno(no);
				FinancialTables f=new FinancialTables();
				f.settNo(no);
				f.settName(name);
				f.settDepartment(department);
				f.settCollectionValue(collectionValue+CollectionValue2.gettCollectionValue());
				f.settDesc(desc);
				f.settTime(time);
				num=dao.updateValueByNo(f);
			}
		}
		return num;
	}

}
