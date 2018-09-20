package org.ldxx.bean;
/**
 * 人工预算
 * @author hp
 *
 */
public class ArtificialBudget {
	
	private String aId;
	private String prjMemberType;//项目成员类型
	private String aName;//姓名
	private String roleCoefficient;//角色系数
	private String estimatedDays;//预计投入天数
	private String aDesc;//备注
	
	
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getPrjMemberType() {
		return prjMemberType;
	}
	public void setPrjMemberType(String prjMemberType) {
		this.prjMemberType = prjMemberType;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getRoleCoefficient() {
		return roleCoefficient;
	}
	public void setRoleCoefficient(String roleCoefficient) {
		this.roleCoefficient = roleCoefficient;
	}
	public String getEstimatedDays() {
		return estimatedDays;
	}
	public void setEstimatedDays(String estimatedDays) {
		this.estimatedDays = estimatedDays;
	}
	public String getaDesc() {
		return aDesc;
	}
	public void setaDesc(String aDesc) {
		this.aDesc = aDesc;
	}
	
	

}
