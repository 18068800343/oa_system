package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.User;

public interface UserDao {

	int addUser(@Param("user")User user);

	int deleteUser(@Param("userId")String userId);

	int updateUser(@Param("user")User user);

	List<User> selectAllUser();

	User selectUserById(@Param("userId")String userId);

	int countOfusername(@Param("username")String username);

	int countOfworkId(@Param("workId")String workId);

	int countOfrecordNo(@Param("recordNo")String recordNo);

	int countOfusernameEdit(@Param("username") String username,@Param("userId") String userId);

	int countOfworkIdEdit(@Param("workId")String workId,@Param("userId") String userId);

	int countOfrecordNoEdit(@Param("recordNo")String recordNo,@Param("userId") String userId);

	List<User> selectUserByomId(@Param("omId")String omId);

	String countUsername(@Param("username")String username);

	User selectUserByusername(@Param("username")String username);

	int countuserCode();

}
