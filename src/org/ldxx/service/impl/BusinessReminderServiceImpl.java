package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.dao.BusinessReminderDao;
import org.ldxx.service.BusinessReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessReminderServiceImpl implements BusinessReminderService {
	
	@Autowired
	private BusinessReminderDao dao;

	@Override
	public List<CurrentFlow> selectBusinessReminder(String userId, String status) {
		return dao.selectBusinessReminder(userId,status);
	}

}
