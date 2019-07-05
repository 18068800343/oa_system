package org.ldxx.bean;

import java.util.List;
//使用管理
public class SignetUsers {
    private String suId;
    
    private String useProject;//使用项目
    
    private String taskNo;//任务单号
    
    private String signetNo;

    private String beginTime;

    private String custodyMan;//保管人
    
    private String endTime;//归还时间
    
    private String returnPerson;//归还人

    private String status;//归还状态 1已归还 0未归还 2归还中

    private List<Accessory> accessory;
    
    private String yinzhangName;//印章全称


    
	public String getYinzhangName() {
		return yinzhangName;
	}

	public void setYinzhangName(String yinzhangName) {
		this.yinzhangName = yinzhangName;
	}

	public String getReturnPerson() {
		return returnPerson;
	}

	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSignetNo() {
		return signetNo;
	}

	public void setSignetNo(String signetNo) {
		this.signetNo = signetNo;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getSuId() {
        return suId;
    }

    public void setSuId(String suId) {
        this.suId = suId == null ? null : suId.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getCustodyMan() {
        return custodyMan;
    }

    public void setCustodyMan(String custodyMan) {
        this.custodyMan = custodyMan == null ? null : custodyMan.trim();
    }

    public String getUseProject() {
        return useProject;
    }

    public void setUseProject(String useProject) {
        this.useProject = useProject == null ? null : useProject.trim();
    }
}