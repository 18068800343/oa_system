package org.ldxx.service.impl;

import org.ldxx.bean.ModeStatus;
import org.ldxx.dao.ModeStatusDao;
import org.ldxx.service.ModeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeStatusServiceImpl implements ModeStatusService {
	
	@Autowired
	private ModeStatusDao dao;

	@Override
	public int addModeStatus(ModeStatus ms) {
		return dao.addModeStatus(ms);
	}
}
