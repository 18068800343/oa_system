/**
 * <p>Title: StatisticsVo.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月14日 下午4:54:42
 */

package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: StatisticsVo 
* @Description: 统计分析
* @author zhaohui
* @date 2018年12月14日 下午4:54:42 
*  
*/
public class StatisticsVo {

	private BigDecimal mbContractMoney;//目标合同金额
	private BigDecimal mbIncome;//目标收入
	private BigDecimal mbReceipt;//目标收款
	private BigDecimal contractAll;//实际总合同金额
	private BigDecimal allInCome;//实际总收入
	private BigDecimal allReceipt;//实际总收款
	public BigDecimal getMbContractMoney() {
		return mbContractMoney;
	}
	public void setMbContractMoney(BigDecimal mbContractMoney) {
		this.mbContractMoney = mbContractMoney;
	}
	public BigDecimal getMbIncome() {
		return mbIncome;
	}
	public void setMbIncome(BigDecimal mbIncome) {
		this.mbIncome = mbIncome;
	}
	public BigDecimal getMbReceipt() {
		return mbReceipt;
	}
	public void setMbReceipt(BigDecimal mbReceipt) {
		this.mbReceipt = mbReceipt;
	}
	public BigDecimal getContractAll() {
		return contractAll;
	}
	public void setContractAll(BigDecimal contractAll) {
		this.contractAll = contractAll;
	}
	public BigDecimal getAllInCome() {
		return allInCome;
	}
	public void setAllInCome(BigDecimal allInCome) {
		this.allInCome = allInCome;
	}
	public BigDecimal getAllReceipt() {
		return allReceipt;
	}
	public void setAllReceipt(BigDecimal allReceipt) {
		this.allReceipt = allReceipt;
	}
	
}
