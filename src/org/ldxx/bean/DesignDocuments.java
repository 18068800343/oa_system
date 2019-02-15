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
	private int fileLengthSJ;
	private List<Accessory> accessory1;//项目实际存档目录
    private List<Accessory> accessory2;//项目特点介绍、关键词（尤其施工图阶段）
    private List<Accessory> accessory3;//合同资料（合同原件提交经营部综合部）
    //工可/方案
    private List<Accessory> accessory4;//设计任务书
    private List<Accessory> accessory5;//建设用地批准书、规划要点
    private List<Accessory> accessory6;//用地红线图（地形图）
    private List<Accessory> accessory7;//用地实测图
    private List<Accessory> accessory8;//区域控制性详细规划
    private List<Accessory> accessory9;//开发可行性报告与市场调查
    private List<Accessory> accessory10;//工程地质勘察报告
    private List<Accessory> accessory11;//工程场地地震安评报告
    private List<Accessory> accessory12;//用地范围周边市政系统情况
    private List<Accessory> accessory13;//工可报告、图纸
    private List<Accessory> accessory14;//相关单位往来函、文
    private List<Accessory> accessory15;//效果图
    private List<Accessory> accessory16;//报批文本
    private List<Accessory> accessory17;//图纸
    private List<Accessory> accessory18;//审查意见
    private List<Accessory> accessory19;//校审单
    //初设阶段
    private List<Accessory> accessory20;//方案批文（规划、环评、安评等）
    private List<Accessory> accessory21;//施工图文件
    private List<Accessory> accessory22;//概算书
    private List<Accessory> accessory23;//地勘报告（初勘或详勘）
    private List<Accessory> accessory24;//审查意见
    private List<Accessory> accessory25;//校审单
    private List<Accessory> accessory26;//相关单位往来函、文
    //施工图阶段
    private List<Accessory> accessory27;//初设批文
    private List<Accessory> accessory28;//施工图文件
    private List<Accessory> accessory29;//预算书
    private List<Accessory> accessory30;//依据历史图纸和报告
    private List<Accessory> accessory31;//结构模型、计算书
    private List<Accessory> accessory32;//地勘报告（详勘）
    private List<Accessory> accessory33;//工程咨询报告
    private List<Accessory> accessory34;//审查意见
    private List<Accessory> accessory35;//校审单
    private List<Accessory> accessory36;//施工交底记录及回复
    private List<Accessory> accessory37;//设计变更资料
    private List<Accessory> accessory38;//重点项目项目总结
    private List<Accessory> accessory39;//交工验收文件（原件提交经营发展部，如施工任务由公司承担则不需要）
    private List<Accessory> accessory40;//获奖证书
    private List<Accessory> accessory41;//相关单位往来函、文
    
    
	
	public int getFileLengthSJ() {
		return fileLengthSJ;
	}
	public void setFileLengthSJ(int fileLengthSJ) {
		this.fileLengthSJ = fileLengthSJ;
	}
	public List<Accessory> getAccessory40() {
		return accessory40;
	}
	public void setAccessory40(List<Accessory> accessory40) {
		this.accessory40 = accessory40;
	}
	public List<Accessory> getAccessory41() {
		return accessory41;
	}
	public void setAccessory41(List<Accessory> accessory41) {
		this.accessory41 = accessory41;
	}
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
	public List<Accessory> getAccessory11() {
		return accessory11;
	}
	public void setAccessory11(List<Accessory> accessory11) {
		this.accessory11 = accessory11;
	}
	public List<Accessory> getAccessory12() {
		return accessory12;
	}
	public void setAccessory12(List<Accessory> accessory12) {
		this.accessory12 = accessory12;
	}
	public List<Accessory> getAccessory13() {
		return accessory13;
	}
	public void setAccessory13(List<Accessory> accessory13) {
		this.accessory13 = accessory13;
	}
	public List<Accessory> getAccessory14() {
		return accessory14;
	}
	public void setAccessory14(List<Accessory> accessory14) {
		this.accessory14 = accessory14;
	}
	public List<Accessory> getAccessory15() {
		return accessory15;
	}
	public void setAccessory15(List<Accessory> accessory15) {
		this.accessory15 = accessory15;
	}
	public List<Accessory> getAccessory16() {
		return accessory16;
	}
	public void setAccessory16(List<Accessory> accessory16) {
		this.accessory16 = accessory16;
	}
	public List<Accessory> getAccessory17() {
		return accessory17;
	}
	public void setAccessory17(List<Accessory> accessory17) {
		this.accessory17 = accessory17;
	}
	public List<Accessory> getAccessory18() {
		return accessory18;
	}
	public void setAccessory18(List<Accessory> accessory18) {
		this.accessory18 = accessory18;
	}
	public List<Accessory> getAccessory19() {
		return accessory19;
	}
	public void setAccessory19(List<Accessory> accessory19) {
		this.accessory19 = accessory19;
	}
	public List<Accessory> getAccessory20() {
		return accessory20;
	}
	public void setAccessory20(List<Accessory> accessory20) {
		this.accessory20 = accessory20;
	}
	public List<Accessory> getAccessory21() {
		return accessory21;
	}
	public void setAccessory21(List<Accessory> accessory21) {
		this.accessory21 = accessory21;
	}
	public List<Accessory> getAccessory22() {
		return accessory22;
	}
	public void setAccessory22(List<Accessory> accessory22) {
		this.accessory22 = accessory22;
	}
	public List<Accessory> getAccessory23() {
		return accessory23;
	}
	public void setAccessory23(List<Accessory> accessory23) {
		this.accessory23 = accessory23;
	}
	public List<Accessory> getAccessory24() {
		return accessory24;
	}
	public void setAccessory24(List<Accessory> accessory24) {
		this.accessory24 = accessory24;
	}
	public List<Accessory> getAccessory25() {
		return accessory25;
	}
	public void setAccessory25(List<Accessory> accessory25) {
		this.accessory25 = accessory25;
	}
	public List<Accessory> getAccessory26() {
		return accessory26;
	}
	public void setAccessory26(List<Accessory> accessory26) {
		this.accessory26 = accessory26;
	}
	public List<Accessory> getAccessory27() {
		return accessory27;
	}
	public void setAccessory27(List<Accessory> accessory27) {
		this.accessory27 = accessory27;
	}
	public List<Accessory> getAccessory28() {
		return accessory28;
	}
	public void setAccessory28(List<Accessory> accessory28) {
		this.accessory28 = accessory28;
	}
	public List<Accessory> getAccessory29() {
		return accessory29;
	}
	public void setAccessory29(List<Accessory> accessory29) {
		this.accessory29 = accessory29;
	}
	public List<Accessory> getAccessory30() {
		return accessory30;
	}
	public void setAccessory30(List<Accessory> accessory30) {
		this.accessory30 = accessory30;
	}
	public List<Accessory> getAccessory31() {
		return accessory31;
	}
	public void setAccessory31(List<Accessory> accessory31) {
		this.accessory31 = accessory31;
	}
	public List<Accessory> getAccessory32() {
		return accessory32;
	}
	public void setAccessory32(List<Accessory> accessory32) {
		this.accessory32 = accessory32;
	}
	public List<Accessory> getAccessory33() {
		return accessory33;
	}
	public void setAccessory33(List<Accessory> accessory33) {
		this.accessory33 = accessory33;
	}
	public List<Accessory> getAccessory34() {
		return accessory34;
	}
	public void setAccessory34(List<Accessory> accessory34) {
		this.accessory34 = accessory34;
	}
	public List<Accessory> getAccessory35() {
		return accessory35;
	}
	public void setAccessory35(List<Accessory> accessory35) {
		this.accessory35 = accessory35;
	}
	public List<Accessory> getAccessory36() {
		return accessory36;
	}
	public void setAccessory36(List<Accessory> accessory36) {
		this.accessory36 = accessory36;
	}
	public List<Accessory> getAccessory37() {
		return accessory37;
	}
	public void setAccessory37(List<Accessory> accessory37) {
		this.accessory37 = accessory37;
	}
	public List<Accessory> getAccessory38() {
		return accessory38;
	}
	public void setAccessory38(List<Accessory> accessory38) {
		this.accessory38 = accessory38;
	}
	public List<Accessory> getAccessory39() {
		return accessory39;
	}
	public void setAccessory39(List<Accessory> accessory39) {
		this.accessory39 = accessory39;
	}
	
}
