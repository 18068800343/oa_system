package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;

public interface ProjectSealService {

	List<SignetManage> selectPrjSeal(String status);

	int addPrjSeal(SignetManage signetManage);

	int deletePrjSealById(String id);

	int updatePrjSealById(SignetManage signetManage);

	SignetManage selectPrjSealById(String smId, String status);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

}
