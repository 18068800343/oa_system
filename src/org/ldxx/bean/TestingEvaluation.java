package org.ldxx.bean;

import java.util.List;
/**
 * 检测评估类
 * @author hp
 */
public class TestingEvaluation {
	private String teId;// 编号
	private String prjName;//项目名称
	private String prjNo; //任务单号
	private int fileLengthJC;
	private List<Accessory> accessory1;//项目实际存档目录
    private List<Accessory> accessory2;//项目特点介绍、关键词
    private List<Accessory> accessory3;//合同资料（合同原件提交经营部综合部）
    private List<Accessory> accessory4;//出版报告
    private List<Accessory> accessory5;//计算模型、计算书
    private List<Accessory> accessory6;//外部审查意见
    private List<Accessory> accessory7;//校审资料
    private List<Accessory> accessory8;//技术方案
    private List<Accessory> accessory9;//重点项目的项目总结
    private List<Accessory> accessory10;//依据历史设计图纸
    
    
	
	public int getFileLengthJC() {
		return fileLengthJC;
	}
	public void setFileLengthJC(int fileLengthJC) {
		this.fileLengthJC = fileLengthJC;
	}
	public String getTeId() {
		return teId;
	}
	public void setTeId(String teId) {
		this.teId = teId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public List<Accessory> getAccessory1() {
		return accessory1;
	}
	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}
	public List<Accessory> getAccessory2() {
		return accessory2;
	}
	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}
	public List<Accessory> getAccessory3() {
		return accessory3;
	}
	public void setAccessory3(List<Accessory> accessory3) {
		this.accessory3 = accessory3;
	}
	public List<Accessory> getAccessory4() {
		return accessory4;
	}
	public void setAccessory4(List<Accessory> accessory4) {
		this.accessory4 = accessory4;
	}
	public List<Accessory> getAccessory5() {
		return accessory5;
	}
	public void setAccessory5(List<Accessory> accessory5) {
		this.accessory5 = accessory5;
	}
	public List<Accessory> getAccessory6() {
		return accessory6;
	}
	public void setAccessory6(List<Accessory> accessory6) {
		this.accessory6 = accessory6;
	}
	public List<Accessory> getAccessory7() {
		return accessory7;
	}
	public void setAccessory7(List<Accessory> accessory7) {
		this.accessory7 = accessory7;
	}
	public List<Accessory> getAccessory8() {
		return accessory8;
	}
	public void setAccessory8(List<Accessory> accessory8) {
		this.accessory8 = accessory8;
	}
	public List<Accessory> getAccessory9() {
		return accessory9;
	}
	public void setAccessory9(List<Accessory> accessory9) {
		this.accessory9 = accessory9;
	}
	public List<Accessory> getAccessory10() {
		return accessory10;
	}
	public void setAccessory10(List<Accessory> accessory10) {
		this.accessory10 = accessory10;
	}
    
    
    

}
