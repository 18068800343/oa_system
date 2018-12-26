/**
 * <p>Title: ContractReason.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月26日 下午1:48:19
 */

package org.ldxx.bean;

/** 
* @ClassName: ContractReason 
* @Description: 合同取消启用原因
* @author 马潇霄
* @date 2018年12月26日 下午1:48:19 
*  
*/
public class ContractReason {

	private String id;
	private String restartReason;
	private String stopReason;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRestartReason() {
		return restartReason;
	}
	public void setRestartReason(String restartReason) {
		this.restartReason = restartReason;
	}
	public String getStopReason() {
		return stopReason;
	}
	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}
	
	
}
