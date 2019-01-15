package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMaterialInCl;

public interface GsMaterialInService {

	List<CompanyMateriaIn> selectGsMaterialIn(String outState);

	int addGsMaterialInSave(CompanyMateriaIn cm);

	List<CompanyMateriaIn> selectcgNotaskNoPrjName();

	List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo);

	List<CompanyMateriaIn> selectcgNotaskNoPrjNameBycgName(String cgName);

	int updateGsMaterialInSave(CompanyMateriaIn cm);

	int updateMaterialbuyUnitAndManufacturer(String id,String unit, String manufacturer);

	CompanyMateriaIn selectGsClInById(String id);

	int updateOutStateById(String id,String outstate);

	List<CompanyMateriaIn> selectXmMaterialByNo(String no, String outstate);

	int updateXmState(CompanyMateriaIn gsIncl);

	List<CompanyMateriaIn> selectAllXmReceivedGoods();

	List<CompanyMaterialInCl> selectGsClInBytaskNo(String no);

	List<CompanyMateriaIn> selectMateriaOutForEnd(String no,String type);

	int updateremainType(String id, String type);

	List<CompanyMateriaIn> selectGsMateriaOutForEnd(String no);

	List<CompanyMateriaIn> getGsMaterialIn();

	List<CompanyMateriaIn> selectAlearyRemain();

	List<CompanyMateriaIn> selectGsMateriaOutForEnd2(String no);


}
