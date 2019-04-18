/**
 * <p>Title: GsClOut.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月17日 上午10:46:53
 */

package org.ldxx.bean;

/** 
* @ClassName: GsClOut 
* @Description: 公司材料出库材料实体
* @author zhaohui
* @date 2018年10月17日 上午10:46:53 
*  
*/
public class GsClOut {

	private String gsId;//编号
	private String gsOutId;//公司材料出库单号
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String specificationModel;//规格型号
	private String cmoUnit;//单位
	private Double cmoUnitPrice;//单价
	private int cmoNumber;// 出库总数量
	private int remainNumber;//剩余数量
	private Double cmoMoney;//出库的金额
	private String pickDate;//领料日期
	
	public String getGsId() {
		return gsId;
	}
	public void setGsId(String gsId) {
		this.gsId = gsId;
	}
	public String getPickDate() {
		return pickDate;
	}
	public void setPickDate(String pickDate) {
		this.pickDate = pickDate;
	}
	public String getGsOutId() {
		return gsOutId;
	}
	public void setGsOutId(String gsOutId) {
		this.gsOutId = gsOutId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public String getSpecificationModel() {
		return specificationModel;
	}
	public void setSpecificationModel(String specificationModel) {
		this.specificationModel = specificationModel;
	}
	public String getCmoUnit() {
		return cmoUnit;
	}
	public void setCmoUnit(String cmoUnit) {
		this.cmoUnit = cmoUnit;
	}
	public int getCmoNumber() {
		return cmoNumber;
	}
	public void setCmoNumber(int cmoNumber) {
		this.cmoNumber = cmoNumber;
	}
	public int getRemainNumber() {
		return remainNumber;
	}
	public void setRemainNumber(int remainNumber) {
		this.remainNumber = remainNumber;
	}
	public Double getCmoUnitPrice() {
		return cmoUnitPrice;
	}
	public void setCmoUnitPrice(Double cmoUnitPrice) {
		this.cmoUnitPrice = cmoUnitPrice;
	}
	public Double getCmoMoney() {
		return cmoMoney;
	}
	public void setCmoMoney(Double cmoMoney) {
		this.cmoMoney = cmoMoney;
	}
	
	
}
