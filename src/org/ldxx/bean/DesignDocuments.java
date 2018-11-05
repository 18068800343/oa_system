package org.ldxx.bean;
import java.util.List;
/**
 * 新建设计文件资料
 * @author hp
 *
 */
public class DesignDocuments {
	private String ddId;// 编号
	private String prjName;//项目名称
	private String prjNo; //任务单号
	
	private List<Accessory> accessory1;//项目实际存档目录
    private List<Accessory> accessory2;//项目特点介绍、关键词
    private List<Accessory> accessory3;//招投标文件
    private List<Accessory> accessory4;//合同资料
    //工可/方案
    private List<Accessory> accessorygk1;//设计任务书
    private List<Accessory> accessorygk2;//建设用地批准书、规划要点
    private List<Accessory> accessorygk3;//用地红线图（地形图）
    private List<Accessory> accessorygk4;//用地实测图
    private List<Accessory> accessorygk5;//区域控制性详细规划
    private List<Accessory> accessorygk6;//开发可行性报告与市场调查
    private List<Accessory> accessorygk7;//工程地质勘察报告
    private List<Accessory> accessorygk8;//工程场地地震安评报告
    private List<Accessory> accessorygk9;//用地范围周边市政系统情况
    private List<Accessory> accessorygk10;//效果图
    private List<Accessory> accessorygk11;//工可报告、图纸
    private List<Accessory> accessorygk12;//相关单位往来函、文
    //报批方案
    private List<Accessory> accessorybp1;//效果图
    private List<Accessory> accessorybp2;//报批文本
    private List<Accessory> accessorybp3;//图纸
    private List<Accessory> accessorybp4;//审查意见
    private List<Accessory> accessorybp5;//校审单
    //初设阶段
    private List<Accessory> accessorycs1;//方案批文（规划、环评、安评等）
    private List<Accessory> accessorycs2;//施工图文件
    private List<Accessory> accessorycs3;//概算书
    private List<Accessory> accessorycs4;//地勘报告（初勘或详勘）
    private List<Accessory> accessorycs5;//审查意见
    private List<Accessory> accessorycs6;//校审单
    private List<Accessory> accessorycs7;//相关单位往来函、文
    //施工图阶段
    private List<Accessory> accessorysgt1;//初设批文
    private List<Accessory> accessorysgt2;//施工图文件
    private List<Accessory> accessorysgt3;//结构模型、计算书
    private List<Accessory> accessorysgt4;//地勘报告（详勘）
    private List<Accessory> accessorysgt5;//审查意见
    private List<Accessory> accessorysgt6;//校审单
    private List<Accessory> accessorysgt7;//施工交底记录及回复
    private List<Accessory> accessorysgt8;//设计变更资料
    private List<Accessory> accessorysgt9;//重点项目项目总结
    private List<Accessory> accessorysgt10;//相关单位往来函、文
    private List<Accessory> accessorysgt11;//重点项目质量流程内部控制文件
    
    
	public String getDdId() {
		return ddId;
	}
	public void setDdId(String ddId) {
		this.ddId = ddId;
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
	public List<Accessory> getAccessorygk1() {
		return accessorygk1;
	}
	public void setAccessorygk1(List<Accessory> accessorygk1) {
		this.accessorygk1 = accessorygk1;
	}
	public List<Accessory> getAccessorygk2() {
		return accessorygk2;
	}
	public void setAccessorygk2(List<Accessory> accessorygk2) {
		this.accessorygk2 = accessorygk2;
	}
	public List<Accessory> getAccessorygk3() {
		return accessorygk3;
	}
	public void setAccessorygk3(List<Accessory> accessorygk3) {
		this.accessorygk3 = accessorygk3;
	}
	public List<Accessory> getAccessorygk4() {
		return accessorygk4;
	}
	public void setAccessorygk4(List<Accessory> accessorygk4) {
		this.accessorygk4 = accessorygk4;
	}
	public List<Accessory> getAccessorygk5() {
		return accessorygk5;
	}
	public void setAccessorygk5(List<Accessory> accessorygk5) {
		this.accessorygk5 = accessorygk5;
	}
	public List<Accessory> getAccessorygk6() {
		return accessorygk6;
	}
	public void setAccessorygk6(List<Accessory> accessorygk6) {
		this.accessorygk6 = accessorygk6;
	}
	public List<Accessory> getAccessorygk7() {
		return accessorygk7;
	}
	public void setAccessorygk7(List<Accessory> accessorygk7) {
		this.accessorygk7 = accessorygk7;
	}
	public List<Accessory> getAccessorygk8() {
		return accessorygk8;
	}
	public void setAccessorygk8(List<Accessory> accessorygk8) {
		this.accessorygk8 = accessorygk8;
	}
	public List<Accessory> getAccessorygk9() {
		return accessorygk9;
	}
	public void setAccessorygk9(List<Accessory> accessorygk9) {
		this.accessorygk9 = accessorygk9;
	}
	public List<Accessory> getAccessorygk10() {
		return accessorygk10;
	}
	public void setAccessorygk10(List<Accessory> accessorygk10) {
		this.accessorygk10 = accessorygk10;
	}
	public List<Accessory> getAccessorygk11() {
		return accessorygk11;
	}
	public void setAccessorygk11(List<Accessory> accessorygk11) {
		this.accessorygk11 = accessorygk11;
	}
	public List<Accessory> getAccessorygk12() {
		return accessorygk12;
	}
	public void setAccessorygk12(List<Accessory> accessorygk12) {
		this.accessorygk12 = accessorygk12;
	}
	public List<Accessory> getAccessorybp1() {
		return accessorybp1;
	}
	public void setAccessorybp1(List<Accessory> accessorybp1) {
		this.accessorybp1 = accessorybp1;
	}
	public List<Accessory> getAccessorybp2() {
		return accessorybp2;
	}
	public void setAccessorybp2(List<Accessory> accessorybp2) {
		this.accessorybp2 = accessorybp2;
	}
	public List<Accessory> getAccessorybp3() {
		return accessorybp3;
	}
	public void setAccessorybp3(List<Accessory> accessorybp3) {
		this.accessorybp3 = accessorybp3;
	}
	public List<Accessory> getAccessorybp4() {
		return accessorybp4;
	}
	public void setAccessorybp4(List<Accessory> accessorybp4) {
		this.accessorybp4 = accessorybp4;
	}
	public List<Accessory> getAccessorybp5() {
		return accessorybp5;
	}
	public void setAccessorybp5(List<Accessory> accessorybp5) {
		this.accessorybp5 = accessorybp5;
	}
	public List<Accessory> getAccessorycs1() {
		return accessorycs1;
	}
	public void setAccessorycs1(List<Accessory> accessorycs1) {
		this.accessorycs1 = accessorycs1;
	}
	public List<Accessory> getAccessorycs2() {
		return accessorycs2;
	}
	public void setAccessorycs2(List<Accessory> accessorycs2) {
		this.accessorycs2 = accessorycs2;
	}
	public List<Accessory> getAccessorycs3() {
		return accessorycs3;
	}
	public void setAccessorycs3(List<Accessory> accessorycs3) {
		this.accessorycs3 = accessorycs3;
	}
	public List<Accessory> getAccessorycs4() {
		return accessorycs4;
	}
	public void setAccessorycs4(List<Accessory> accessorycs4) {
		this.accessorycs4 = accessorycs4;
	}
	public List<Accessory> getAccessorycs5() {
		return accessorycs5;
	}
	public void setAccessorycs5(List<Accessory> accessorycs5) {
		this.accessorycs5 = accessorycs5;
	}
	public List<Accessory> getAccessorycs6() {
		return accessorycs6;
	}
	public void setAccessorycs6(List<Accessory> accessorycs6) {
		this.accessorycs6 = accessorycs6;
	}
	public List<Accessory> getAccessorycs7() {
		return accessorycs7;
	}
	public void setAccessorycs7(List<Accessory> accessorycs7) {
		this.accessorycs7 = accessorycs7;
	}
	public List<Accessory> getAccessorysgt1() {
		return accessorysgt1;
	}
	public void setAccessorysgt1(List<Accessory> accessorysgt1) {
		this.accessorysgt1 = accessorysgt1;
	}
	public List<Accessory> getAccessorysgt2() {
		return accessorysgt2;
	}
	public void setAccessorysgt2(List<Accessory> accessorysgt2) {
		this.accessorysgt2 = accessorysgt2;
	}
	public List<Accessory> getAccessorysgt3() {
		return accessorysgt3;
	}
	public void setAccessorysgt3(List<Accessory> accessorysgt3) {
		this.accessorysgt3 = accessorysgt3;
	}
	public List<Accessory> getAccessorysgt4() {
		return accessorysgt4;
	}
	public void setAccessorysgt4(List<Accessory> accessorysgt4) {
		this.accessorysgt4 = accessorysgt4;
	}
	public List<Accessory> getAccessorysgt5() {
		return accessorysgt5;
	}
	public void setAccessorysgt5(List<Accessory> accessorysgt5) {
		this.accessorysgt5 = accessorysgt5;
	}
	public List<Accessory> getAccessorysgt6() {
		return accessorysgt6;
	}
	public void setAccessorysgt6(List<Accessory> accessorysgt6) {
		this.accessorysgt6 = accessorysgt6;
	}
	public List<Accessory> getAccessorysgt7() {
		return accessorysgt7;
	}
	public void setAccessorysgt7(List<Accessory> accessorysgt7) {
		this.accessorysgt7 = accessorysgt7;
	}
	public List<Accessory> getAccessorysgt8() {
		return accessorysgt8;
	}
	public void setAccessorysgt8(List<Accessory> accessorysgt8) {
		this.accessorysgt8 = accessorysgt8;
	}
	public List<Accessory> getAccessorysgt9() {
		return accessorysgt9;
	}
	public void setAccessorysgt9(List<Accessory> accessorysgt9) {
		this.accessorysgt9 = accessorysgt9;
	}
	public List<Accessory> getAccessorysgt10() {
		return accessorysgt10;
	}
	public void setAccessorysgt10(List<Accessory> accessorysgt10) {
		this.accessorysgt10 = accessorysgt10;
	}
	public List<Accessory> getAccessorysgt11() {
		return accessorysgt11;
	}
	public void setAccessorysgt11(List<Accessory> accessorysgt11) {
		this.accessorysgt11 = accessorysgt11;
	}
}
