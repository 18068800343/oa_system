package org.ldxx.service.impl;

import java.util.List;
import org.ldxx.bean.OtherFile;
import org.ldxx.dao.OtherFileDao;
import org.ldxx.service.OtherFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherFileServiceImpl implements OtherFileService {
	@Autowired
	private OtherFileDao ofDao;
	
	@Transactional
	@Override
	public int deleteOtherFileById(String id) {
		return ofDao.deleteOtherFileById(id);
	}
	@Override
	public int insertOtherFile(OtherFile otherFile) {
		return ofDao.insertOtherFile(otherFile);
	}
	@Override
	public List<OtherFile> selectAllOhterFile() {
		return ofDao.selectAllOhterFile();
	}

	@Override
	public OtherFile selectOtherFileById(String id) {
		// TODO Auto-generated method stub
		return ofDao.selectOtherFileById(id);
	}

}
