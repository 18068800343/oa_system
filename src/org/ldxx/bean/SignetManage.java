package org.ldxx.bean;

import java.util.List;
/**
 * 项目印章刻制申请
 * @author hp
 *
 */
public class SignetManage {
    private String smId;

    private String prjId;

    private String taskNo;

    private String omId;

    private String applicationDate;

    private String signetName;

    private String signetMan;
    private String omName;

    private String signetNo;
    
    private String signetAttribute;//印章属性
    private String signetDesc;//备注
    
    private String status;
    private String stopTime;
    private String preserver;
    
    
    private List<Accessory> accessory;
    
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getPreserver() {
		return preserver;
	}

	public void setPreserver(String preserver) {
		this.preserver = preserver;
	}

	public String getSignetNo() {
		return signetNo;
	}

	public void setSignetNo(String signetNo) {
		this.signetNo = signetNo;
	}

	public String getSignetAttribute() {
		return signetAttribute;
	}

	public void setSignetAttribute(String signetAttribute) {
		this.signetAttribute = signetAttribute;
	}

	public String getSignetDesc() {
		return signetDesc;
	}

	public void setSignetDesc(String signetDesc) {
		this.signetDesc = signetDesc;
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


	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}


	public String getSmId() {
        return smId;
    }

    public void setSmId(String smId) {
        this.smId = smId == null ? null : smId.trim();
    }

    public String getPrjId() {
        return prjId;
    }

    public void setPrjId(String prjId) {
        this.prjId = prjId == null ? null : prjId.trim();
    }


    public String getOmId() {
        return omId;
    }

    public void setOmId(String omId) {
        this.omId = omId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate == null ? null : applicationDate.trim();
    }

    public String getSignetName() {
        return signetName;
    }

    public void setSignetName(String signetName) {
        this.signetName = signetName == null ? null : signetName.trim();
    }

    public String getSignetMan() {
        return signetMan;
    }

    public void setSignetMan(String signetMan) {
        this.signetMan = signetMan == null ? null : signetMan.trim();
    }

}