/**
 * <p>Title: ClOutInfo.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月17日 下午5:14:23
 */

package org.ldxx.bean;

/** 
* @ClassName: ClOutInfo 
* @Description:  项目材料信息
* @author zhaohui
* @date 2018年10月17日 下午5:14:23 
*  
*/
public class ClOutInfo {
	private String outId;
	private String clName;
	private String clType;
	private String modeType;
	private String unit;
	private String num;//库存数量
	private Double price;//单价
	private String lingNum;//认领数量
	private Double sumPrice;//认领金额
	private String clPrjSupplier;
	private String clGsSupplier;
	private String clDesc;
	private String clComeUnit;		//来货单位
	private String clManufacturer;	//生产厂家

	private String clspNamexm;//项目部推荐供应商名称
	private String clspNamegs;//公司推荐供应商名称
	
	private outRemain outRemain;
	
	
	public String getLingNum() {
		return lingNum;
	}
	public void setLingNum(String lingNum) {
		this.lingNum = lingNum;
	}
	public String getClPrjSupplier() {
		return clPrjSupplier;
	}
	public void setClPrjSupplier(String clPrjSupplier) {
		this.clPrjSupplier = clPrjSupplier;
	}
	public String getClGsSupplier() {
		return clGsSupplier;
	}
	public void setClGsSupplier(String clGsSupplier) {
		this.clGsSupplier = clGsSupplier;
	}
	public String getClDesc() {
		return clDesc;
	}
	public void setClDesc(String clDesc) {
		this.clDesc = clDesc;
	}
	public String getClComeUnit() {
		return clComeUnit;
	}
	public void setClComeUnit(String clComeUnit) {
		this.clComeUnit = clComeUnit;
	}
	public String getClManufacturer() {
		return clManufacturer;
	}
	public void setClManufacturer(String clManufacturer) {
		this.clManufacturer = clManufacturer;
	}
	public String getClspNamexm() {
		return clspNamexm;
	}
	public void setClspNamexm(String clspNamexm) {
		this.clspNamexm = clspNamexm;
	}
	public String getClspNamegs() {
		return clspNamegs;
	}
	public void setClspNamegs(String clspNamegs) {
		this.clspNamegs = clspNamegs;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public outRemain getOutRemain() {
		return outRemain;
	}
	public void setOutRemain(outRemain outRemain) {
		this.outRemain = outRemain;
	}
	public String getOutId() {
		return outId;
	}
	public void setOutId(String outId) {
		this.outId = outId;
	}
	public String getClName() {
		return clName;
	}
	public void setClName(String clName) {
		this.clName = clName;
	}
	public String getClType() {
		return clType;
	}
	public void setClType(String clType) {
		this.clType = clType;
	}
	public String getModeType() {
		return modeType;
	}
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	
}
