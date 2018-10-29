/**
 * <p>Title: PrjClosingAuditPerson.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月29日 上午11:24:04
 */

package org.ldxx.bean;

/** 
* @ClassName: PrjClosingAuditPerson 
* @Description: 项目结算审计-人员
* @author zhaohui
* @date 2018年10月29日 上午11:24:04 
*  
*/
public class PrjClosingAuditPerson {

	private String pcId;
	private String roleName;
	private String uName;
	private String roleXs;
	private int days;
	private int score;
	public String getPcId() {
		return pcId;
	}
	public void setPcId(String pcId) {
		this.pcId = pcId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getRoleXs() {
		return roleXs;
	}
	public void setRoleXs(String roleXs) {
		this.roleXs = roleXs;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
