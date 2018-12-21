package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbContractPurchaseSettlement;

public interface MaterialPurchaseSettlementService {

	List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(String status);

	int addmaterialPurchaseSettlementSave(clfbContractPurchaseSettlement c);


	clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(String id);


	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);


}
