package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.DataArchive;

public interface DataArchiveService {

	public int addDataArchive(DataArchive archive);
	
	public int deleteDataArchive(String id);
	
	public int updateDataArchive(DataArchive archive);
	
	public List<DataArchive> selectDataArchive();
}
