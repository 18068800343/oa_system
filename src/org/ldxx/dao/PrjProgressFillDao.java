package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillInfo;

public interface PrjProgressFillDao {

	public int addPrjProgressFill(@Param("ppf")PrjProgressFill ppf);
	
	public int addPrjProgressFillInfo(@Param("ppfi")List<PrjProgressFillInfo> ppfi);
	
	public List<PrjProgressFill> selectPrjProgressFill(@Param("status")String status);
	
	public PrjProgressFill selectPrjProgressFillById(@Param("id")String id);
	
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(@Param("id")String id,@Param("type")String type);
	
	public PrjProgressFill selectLastPrjProgressFill(@Param("no")String no);
}
