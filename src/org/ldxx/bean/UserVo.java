package org.ldxx.bean;

import java.util.List;

public class UserVo {

	private String id;
	private List<User> users;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
