package org.ldxx.bean;

/** 
* @ClassName: ContractUpdate 
* @Description: 承接合同中任务单改变，任务金额操作表
* @author 
* @date 2019年1月12日 下午3:35:52 
*  
*/
public class ContractUpdate {

	private String prjNo;
	private String dept;
	private Double money;
	private String time;
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
