package org.ldxx.bean;
/**
 * 用户权限
 * @author hp
 *
 */
public class PermissionsUser {
	
	private String uId;//用户id
	private String uPermissions;//权限编码
	
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPermissions() {
		return uPermissions;
	}
	public void setuPermissions(String uPermissions) {
		this.uPermissions = uPermissions;
	}
	
	
	

}
