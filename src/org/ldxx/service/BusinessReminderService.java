package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CurrentFlow;

public interface BusinessReminderService {

	List<CurrentFlow> selectBusinessReminder(String userId, String status);

}
