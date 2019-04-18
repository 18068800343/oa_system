/**
 * <p>Title: CjDeptSplitMoney.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2019年1月5日 下午4:22:18
 */

package org.ldxx.bean;

/** 
* @ClassName: CjDeptSplitMoney 
* @Description: 部门合同金额年度拆分
* @author zhaohui
* @date 2019年1月5日 下午4:22:18 
*  
*/
public class CjDeptSplitMoney {

	private String id;
	private String dept;
	private Double money;
	private String year;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
