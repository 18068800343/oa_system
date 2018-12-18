package org.ldxx.model;

import java.util.Date;

public class CurrentFlowVo {
    private String id;

    private String floNodeId;

    private String floTmpId;

    private String busId;

    private String businessname;
    
    private String url;

    private String params;

    private String title;

    private Integer wfstate;

    private String starter;

    private String startername;

    private String actor;

    private String actorname;

    private Date rdt;

    private String fkDept;

    private String deptname;

    private String nodename;

    private Integer pri;

    private Date sdtofnode;

    private Date sdtofflow;

    private String agent;

    private String agenttype;

    private String memo;

    private Integer readreceipts;

    private Date doDate;

    private String modeId;
    
    private String editOrView;
    
	public String getEditOrView() {
		return editOrView;
	}

	public void setEditOrView(String editOrView) {
		this.editOrView = editOrView;
	}

	public String getModeId() {
		return modeId;
	}

	public void setModeId(String modeId) {
		this.modeId = modeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFloNodeId() {
		return floNodeId;
	}

	public void setFloNodeId(String floNodeId) {
		this.floNodeId = floNodeId;
	}

	public String getFloTmpId() {
		return floTmpId;
	}

	public void setFloTmpId(String floTmpId) {
		this.floTmpId = floTmpId;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWfstate() {
		return wfstate;
	}

	public void setWfstate(Integer wfstate) {
		this.wfstate = wfstate;
	}

	public String getStarter() {
		return starter;
	}

	public void setStarter(String starter) {
		this.starter = starter;
	}

	public String getStartername() {
		return startername;
	}

	public void setStartername(String startername) {
		this.startername = startername;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public Date getRdt() {
		return rdt;
	}

	public void setRdt(Date rdt) {
		this.rdt = rdt;
	}

	public String getFkDept() {
		return fkDept;
	}

	public void setFkDept(String fkDept) {
		this.fkDept = fkDept;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getNodename() {
		return nodename;
	}

	public void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public Integer getPri() {
		return pri;
	}

	public void setPri(Integer pri) {
		this.pri = pri;
	}

	public Date getSdtofnode() {
		return sdtofnode;
	}

	public void setSdtofnode(Date sdtofnode) {
		this.sdtofnode = sdtofnode;
	}

	public Date getSdtofflow() {
		return sdtofflow;
	}

	public void setSdtofflow(Date sdtofflow) {
		this.sdtofflow = sdtofflow;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAgenttype() {
		return agenttype;
	}

	public void setAgenttype(String agenttype) {
		this.agenttype = agenttype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getReadreceipts() {
		return readreceipts;
	}

	public void setReadreceipts(Integer readreceipts) {
		this.readreceipts = readreceipts;
	}

	public Date getDoDate() {
		return doDate;
	}

	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}

	@Override
	public String toString() {
		return "CurrentFlowVo [id=" + id + ", floNodeId=" + floNodeId + ", floTmpId=" + floTmpId + ", busId=" + busId
				+ ", businessname=" + businessname + ", url=" + url + ", params=" + params + ", title=" + title
				+ ", wfstate=" + wfstate + ", starter=" + starter + ", startername=" + startername + ", actor=" + actor
				+ ", actorname=" + actorname + ", rdt=" + rdt + ", fkDept=" + fkDept + ", deptname=" + deptname
				+ ", nodename=" + nodename + ", pri=" + pri + ", sdtofnode=" + sdtofnode + ", sdtofflow=" + sdtofflow
				+ ", agent=" + agent + ", agenttype=" + agenttype + ", memo=" + memo + ", readreceipts=" + readreceipts
				+ ", doDate=" + doDate + "]";
	}
    
	
}
