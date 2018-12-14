package org.ldxx.bean;

import java.util.List;

public class Role {

	private int id;
	private String text;
	private String roleCode;
	private String roleName;
	private String roleSort;
	private String parentRoleCode;
	private List<Role> nodes;
	
	public String getParentRoleCode() {
		return parentRoleCode;
	}
	public void setParentRoleCode(String parentRoleCode) {
		this.parentRoleCode = parentRoleCode;
	}
	public String getRoleSort() {
		return roleSort;
	}
	public void setRoleSort(String roleSort) {
		this.roleSort = roleSort;
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Role> getNodes() {
		return nodes;
	}
	public void setNodes(List<Role> nodes) {
		this.nodes = nodes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
