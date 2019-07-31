package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.User;

public interface UserService {

	int addUser(User user);

	int deleteUser(String userId);

	int updateUser(User user);

	List<User> selectAllUser();

	List<User> selectAllroleandper();
	User selectUserById(String userId);

	int countOfusername(String username);

	int countOfworkId(String workId);

	int countOfrecordNo(String recordNo);

	int countOfusernameEdit(String username, String userId);

	int countOfworkIdEdit(String workId, String userId);

	int countOfrecordNoEdit(String recordNo, String userId);

	//List<User> selectUserByomId(String omId);

	String countUsername(String username);

	User selectUserByusername(String username);

	List<User> selectUserAndRoles();

	int countuserCode();

	int updatePasswordById(String userId, String new_password);

	List<User> selectUserByomId(String omId);

	List<User> selectUserByomIdByJobFirstNames(String[] omId);
	
	List<User> selectGCSByDept(String id,String name);
	
	int updateUserInfoByuName(User user);

}
