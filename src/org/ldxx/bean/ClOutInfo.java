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
	private int num;
	private float price;
	private float sumPrice;
	private outRemain outRemain;
	
	
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(float sumPrice) {
		this.sumPrice = sumPrice;
	}
	
}
