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

	private float mbContractMoney;//目标合同金额
	private float mbIncome;//目标收入
	private float mbReceipt;//目标收款
	private float contractAll;//实际总合同金额
	private float allInCome;//实际总收入
	private float allReceipt;//实际总收款
	public float getMbContractMoney() {
		return mbContractMoney;
	}
	public void setMbContractMoney(float mbContractMoney) {
		this.mbContractMoney = mbContractMoney;
	}
	public float getMbIncome() {
		return mbIncome;
	}
	public void setMbIncome(float mbIncome) {
		this.mbIncome = mbIncome;
	}
	public float getMbReceipt() {
		return mbReceipt;
	}
	public void setMbReceipt(float mbReceipt) {
		this.mbReceipt = mbReceipt;
	}
	public float getContractAll() {
		return contractAll;
	}
	public void setContractAll(float contractAll) {
		this.contractAll = contractAll;
	}
	public float getAllInCome() {
		return allInCome;
	}
	public void setAllInCome(float allInCome) {
		this.allInCome = allInCome;
	}
	public float getAllReceipt() {
		return allReceipt;
	}
	public void setAllReceipt(float allReceipt) {
		this.allReceipt = allReceipt;
	}
	
	
}
