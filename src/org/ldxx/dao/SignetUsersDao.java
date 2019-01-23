package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.SignetManage;
import org.ldxx.bean.SignetUsers;

public interface SignetUsersDao {

	int addsUser(@Param("sUser")SignetUsers sUser);

	int deletesUserById(@Param("suId")String suId);

	int updatesUser(@Param("sUser")SignetUsers sUser);

	List<SignetUsers> selectUser();

	SignetUsers selectUsersById(@Param("suId")String suId);
	
	List<SignetManage> selectSignetNo(); 
	
	int addHuan(@Param("sUser")SignetUsers sUser);

}
