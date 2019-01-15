/**
 * <p>Title: StatisticsVo.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月14日 下午4:54:42
 */

package org.ldxx.bean;

/** 
* @ClassName: StatisticsVo 
* @Description: 统计分析
* @author zhaohui
* @date 2018年12月14日 下午4:54:42 
*  
*/
public class StatisticsVo {

	private double mbContractMoney;//目标合同金额
	private double mbIncome;//目标收入
	private double mbReceipt;//目标收款
	private double contractAll;//实际总合同金额
	private double allInCome;//实际总收入
	private double allReceipt;//实际总收款
	public double getMbContractMoney() {
		return mbContractMoney;
	}
	public void setMbContractMoney(double mbContractMoney) {
		this.mbContractMoney = mbContractMoney;
	}
	public double getMbIncome() {
		return mbIncome;
	}
	public void setMbIncome(double mbIncome) {
		this.mbIncome = mbIncome;
	}
	public double getMbReceipt() {
		return mbReceipt;
	}
	public void setMbReceipt(double mbReceipt) {
		this.mbReceipt = mbReceipt;
	}
	public double getContractAll() {
		return contractAll;
	}
	public void setContractAll(double contractAll) {
		this.contractAll = contractAll;
	}
	public double getAllInCome() {
		return allInCome;
	}
	public void setAllInCome(double allInCome) {
		this.allInCome = allInCome;
	}
	public double getAllReceipt() {
		return allReceipt;
	}
	public void setAllReceipt(double allReceipt) {
		this.allReceipt = allReceipt;
	}
	
}
