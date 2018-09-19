package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.User;
import org.ldxx.dao.UserDao;
import org.ldxx.service.UserService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int addUser(User user) {
		TimeUUID uuid = new TimeUUID();
		user.setUserId(uuid.getTimeUUID());
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public User selectUserById(String userId) {
		return userDao.selectUserById(userId);
	}

	@Override
	public int countOfusername(String username) {
		return userDao.countOfusername(username);
	}

	@Override
	public int countOfworkId(String workId) {
		return userDao.countOfworkId(workId);
	}

	@Override
	public int countOfrecordNo(String recordNo) {
		return userDao.countOfrecordNo(recordNo);
	}

	@Override
	public int countOfusernameEdit(String username, String userId) {
		return userDao.countOfusernameEdit(username,userId);
	}

	@Override
	public int countOfworkIdEdit(String workId, String userId) {
		return userDao.countOfworkIdEdit(workId,userId);
	}

	@Override
	public int countOfrecordNoEdit(String recordNo, String userId) {
		return userDao.countOfrecordNoEdit(recordNo,userId);
	}

	@Override
	public List<User> selectUserByomId(String omId) {
		return userDao.selectUserByomId(omId);
	}

}
