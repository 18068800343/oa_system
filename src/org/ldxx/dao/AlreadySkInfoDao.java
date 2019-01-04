package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkInfo;
import org.ldxx.bean.AlreadySkOmInfo;

public interface AlreadySkInfoDao {

	int addAlreadySkInfo(@Param("as")AlreadySkInfo as);

	int addAlreadySkOmInfo(@Param("skOmInfo")AlreadySkOmInfo skOmInfo);

	List<AlreadySkInfo> selectAlreadySkInfo();

	List<AlreadySkOmInfo> selectAlreadySkOmInfoById(@Param("id")String id);

	Float countallSkMoney(@Param("taskNo")String taskNo,@Param("contractNo") String contractNo);

	AlreadySkInfo selectAlreadySkInfoByskId(@Param("skId")String skId);

	int deleteAlreadySkInfoByskId(@Param("id")String id);

	int deleteAlreadySkOmInfoById(@Param("cId")String cId);

	int countquerenNo();

	int addAlreadyRenling(@Param("ar")AlreadyRenling ar);

}
