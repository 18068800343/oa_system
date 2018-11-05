package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.DesignDocuments;
import org.ldxx.dao.DesignDocumentsDao;
import org.ldxx.service.DesignDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DesignDocumentsServiceImpl implements DesignDocumentsService {
	
	@Autowired
	private DesignDocumentsDao dao;

	@Override
	public List<DesignDocuments> selectDesignDocuments() {
		return dao.selectDesignDocuments();
	}

}
