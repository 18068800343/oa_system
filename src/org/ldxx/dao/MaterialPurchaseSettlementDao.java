package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.clfbContractPurchaseSettlement;

public interface MaterialPurchaseSettlementDao {

	List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(@Param("status")String status);

	int addmaterialPurchaseSettlementSave(@Param("c")clfbContractPurchaseSettlement c);

	int updateHistory(@Param("cpId")String cpId);

	clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(@Param("id")String id);

	int cgjsNocount();

	List<clfbContractPurchaseSettlement> selectHistoryByNo(@Param("no")String no);

}
