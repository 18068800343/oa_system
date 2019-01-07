package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.clfbContractPurchaseSettlement;

public interface MaterialPurchaseSettlementDao {

	List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(@Param("status")String status);

	int addmaterialPurchaseSettlementSave(@Param("c")clfbContractPurchaseSettlement c);

	clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(@Param("id")String id);

	int updateMaterialPurchaseSettlement(@Param("c")clfbContractPurchaseSettlement c);
}
