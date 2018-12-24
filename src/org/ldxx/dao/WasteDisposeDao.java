package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.WasteDispose;
import org.ldxx.bean.WasteDisposeCl;

public interface WasteDisposeDao {
	
	public List<WasteDispose> selectWasteDispose();
	
	public List<WasteDisposeCl> selectWdById(@Param("id")String id);
	
	public int addWasteDispose(@Param("wd")WasteDispose wd);
	
	public int addWasteDisposeCl(@Param("wdc")List<WasteDisposeCl> wdc);

	public WasteDispose selectWasteDisposeById(@Param("id")String id);
}
