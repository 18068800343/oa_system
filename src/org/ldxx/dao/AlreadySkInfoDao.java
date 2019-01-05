package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkOmInfo;

public interface AlreadySkInfoDao {


	int addAlreadySkOmInfo(@Param("skOmInfo")AlreadySkOmInfo skOmInfo);

	int addAlreadyRenling(@Param("ar")AlreadyRenling ar);

	AlreadyRenling getyirenlingfpMoneyByKpno(@Param("kpno")String kpno);

	AlreadyRenling getyirenlingfpMoneyByskno(@Param("skNo")String skNo);

	List<AlreadyRenling> selectAlreadyRenling();

}
