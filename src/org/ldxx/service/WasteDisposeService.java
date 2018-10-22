package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.WasteDispose;
import org.ldxx.bean.WasteDisposeCl;

public interface WasteDisposeService {

	public List<WasteDispose> selectWasteDispose();
	
	public int addWasteDispose(WasteDispose wd);
	
	public List<WasteDisposeCl> selectWdById(String id);
}
