package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbContractPurchaseSettlement;

public interface MaterialPurchaseSettlementService {

	List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(String status);

	int addmaterialPurchaseSettlementSave(clfbContractPurchaseSettlement c);

	int updateHistory(String cpId);

	clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(String id);

	int cgjsNocount();

	List<clfbContractPurchaseSettlement> selectHistoryByNo(String no);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);


}
