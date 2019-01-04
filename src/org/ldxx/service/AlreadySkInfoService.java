package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkInfo;

public interface AlreadySkInfoService {

	int addAlreadySkInfo(AlreadySkInfo as, String uName);

	List<AlreadySkInfo> selectAlreadySkInfo();

	AlreadySkInfo selectAlreadySkInfoByskId(String skId);

	int updateStatusBack(String id, String status,String cId);

	int countquerenNo();

	int addAlreadyRenling(AlreadyRenling ar);

}
