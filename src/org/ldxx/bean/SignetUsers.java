package org.ldxx.bean;

import java.util.List;

public class SignetUsers {
    private String suId;
    
    private String useProject;//使用项目
    
    private String taskNo;//任务单号
    
    private String departId;//部门id

    private String beginTime;

    private String endTime;

    private String custodyMan;//保管人


    private String destroyTime;
    
    private String uName;//保管人名
    private String prjName;//使用的项目名
    private String omName;//部门
    
    private List<Accessory> accessory;


    
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

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
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

    public String getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(String destroyTime) {
        this.destroyTime = destroyTime == null ? null : destroyTime.trim();
    }
}