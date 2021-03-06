package org.ldxx.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlowHistoryVo {
	    private String id;

	    private String floTmpId;

	    private String floNodeId;

	    private String busId;

	    private String businessname;
	    
	    private String flowNodeName;
	    
	    private String status;
	    
	    private String url;

	    private String params;

	    private String title;

	    private String starter;

	    private String startername;

	    private Date rdt;

	    private String fkDept;

	    private String deptname;

	    private String nodename;

	    private Integer pri;

	    private String actor;

	    private String actorname;

	    private Integer actorresult;
	    
	    private String flowStatus;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")  
	    private Date doDate;

	    private String modeId;

	    private String view;
	    
	    private String flowNodeLast;

	    private Integer operateType;

	    private Integer step;
	    
	    public Integer getStep() {
			return step;
		}

		public void setStep(Integer step) {
			this.step = step;
		}

		public String getFlowStatus() {
			return flowStatus;
		}

		public void setFlowStatus(String flowStatus) {
			this.flowStatus = flowStatus;
		}

		public String getFlowNodeName() {
			return flowNodeName;
		}

		public void setFlowNodeName(String flowNodeName) {
			this.flowNodeName = flowNodeName;
		}

		public String getFlowNodeLast() {
			return flowNodeLast;
		}

		public void setFlowNodeLast(String flowNodeLast) {
			this.flowNodeLast = flowNodeLast;
		}

		public Integer getOperateType() {
			return operateType;
		}

		public void setOperateType(Integer operateType) {
			this.operateType = operateType;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getBusinessname() {
			return businessname;
		}

		public void setBusinessname(String businessname) {
			this.businessname = businessname;
		}

		public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id == null ? null : id.trim();
	    }

	    public String getFloTmpId() {
	        return floTmpId;
	    }

	    public void setFloTmpId(String floTmpId) {
	        this.floTmpId = floTmpId == null ? null : floTmpId.trim();
	    }

	    public String getFloNodeId() {
	        return floNodeId;
	    }

	    public void setFloNodeId(String floNodeId) {
	        this.floNodeId = floNodeId == null ? null : floNodeId.trim();
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

	    public Integer getActorresult() {
	        return actorresult;
	    }

	    public void setActorresult(Integer actorresult) {
	        this.actorresult = actorresult;
	    }

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

	    public String getView() {
	        return view;
	    }

	    public void setView(String view) {
	        this.view = view == null ? null : view.trim();
	    }
}
