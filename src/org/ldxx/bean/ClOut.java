/**
 * <p>Title: ClOut.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月13日 下午4:24:42
 */

package org.ldxx.bean;

/** 
* @ClassName: ClOut 
* @Description: 项目材料出库
* @author zhaohui
* @date 2018年10月13日 下午4:24:42 
*  
*/
public class ClOut {

	private String outId;
	private String clName;
	private String clType;
	private String modeType;
	private String unit;
	private int num;
	private float price;
	private float sumPrice;
	private String getTime;
	private String getPerson;
	private String infos;
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
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	public String getGetPerson() {
		return getPerson;
	}
	public void setGetPerson(String getPerson) {
		this.getPerson = getPerson;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	
	
}
