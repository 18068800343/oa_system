package org.ldxx.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class CurrentFlow {
    private String id;

    private String floNodeId;

    private String floTmpId;

    private String busId;

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

    private Integer flowEndState;

    private String flowNodeLast;
    
    private String flowNodeName;//待审批步骤
    

    
    public String getFlowNodeName() {
		return flowNodeName;
	}

	public void setFlowNodeName(String flowNodeName) {
		this.flowNodeName = flowNodeName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFloNodeId() {
        return floNodeId;
    }

    public void setFloNodeId(String floNodeId) {
        this.floNodeId = floNodeId == null ? null : floNodeId.trim();
    }

    public String getFloTmpId() {
        return floTmpId;
    }

    public void setFloTmpId(String floTmpId) {
        this.floTmpId = floTmpId == null ? null : floTmpId.trim();
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId == null ? null : busId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
        this.starter = starter == null ? null : starter.trim();
    }

    public String getStartername() {
        return startername;
    }

    public void setStartername(String startername) {
        this.startername = startername == null ? null : startername.trim();
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public String getActorname() {
        return actorname;
    }

    public void setActorname(String actorname) {
        this.actorname = actorname == null ? null : actorname.trim();
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
        this.fkDept = fkDept == null ? null : fkDept.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
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
        this.agent = agent == null ? null : agent.trim();
    }

    public String getAgenttype() {
        return agenttype;
    }

    public void setAgenttype(String agenttype) {
        this.agenttype = agenttype == null ? null : agenttype.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getReadreceipts() {
        return readreceipts;
    }

    public void setReadreceipts(Integer readreceipts) {
        this.readreceipts = readreceipts;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getDoDate() {
        return doDate;
    }

    public void setDoDate(Date doDate) {
        this.doDate = doDate;
    }

    public String getModeId() {
        return modeId;
    }

    public void setModeId(String modeId) {
        this.modeId = modeId == null ? null : modeId.trim();
    }

    public Integer getFlowEndState() {
        return flowEndState;
    }

    public void setFlowEndState(Integer flowEndState) {
        this.flowEndState = flowEndState;
    }

    public String getFlowNodeLast() {
        return flowNodeLast;
    }

    public void setFlowNodeLast(String flowNodeLast) {
        this.flowNodeLast = flowNodeLast == null ? null : flowNodeLast.trim();
    }
}