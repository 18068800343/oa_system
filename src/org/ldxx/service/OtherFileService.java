package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.OtherFile;

public interface OtherFileService {

	public int deleteOtherFileById(String id);
	
	public int insertOtherFile(OtherFile otherFile);
	
	public List<OtherFile> selectAllOhterFile();
	
	public OtherFile selectOtherFileById(String id);
}
