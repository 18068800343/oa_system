package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;

public interface ProjectSealService {

	List<SignetManage> selectPrjSeal(String status);

	int addPrjSeal(SignetManage signetManage);

	int deletePrjSealById(String id);

	int updatePrjSealById(SignetManage signetManage);

	SignetManage selectPrjSealById(String smId);

	int deleteAccessoryByIdAndName(Accessory accessory);
	
	int addStop(SignetManage signetManage);
	
	int updateStatus(String id,String status);
	
	int updateStatusByNo(String no,String status);

}
