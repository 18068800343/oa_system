package org.ldxx.bean;

public class ResultManagementSignet {
    private String usId;

    private String prjId;//项目
    
    private String usNo;//编号
    
    private String prjHead;//项目负责人
    
    private String projectPhase;//项目阶段

    private String divisionEngineer;//分项主任工程师

    private String headEngineer;//（副）总工程师

    private String userSignetMan;//保管人

    private String projectDesc;

    private String usType;//印章类型
    
    private String uName;

    
    
    public String getUsType() {
		return usType;
	}

	public void setUsType(String usType) {
		this.usType = usType;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getUsNo() {
		return usNo;
	}

	public void setUsNo(String usNo) {
		this.usNo = usNo;
	}


	public String getPrjHead() {
		return prjHead;
	}

	public void setPrjHead(String prjHead) {
		this.prjHead = prjHead;
	}

	public String getUsId() {
        return usId;
    }

    public void setUsId(String usId) {
        this.usId = usId == null ? null : usId.trim();
    }

    public String getPrjId() {
        return prjId;
    }

    public void setPrjId(String prjId) {
        this.prjId = prjId == null ? null : prjId.trim();
    }

    public String getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(String projectPhase) {
        this.projectPhase = projectPhase == null ? null : projectPhase.trim();
    }

    public String getDivisionEngineer() {
        return divisionEngineer;
    }

    public void setDivisionEngineer(String divisionEngineer) {
        this.divisionEngineer = divisionEngineer == null ? null : divisionEngineer.trim();
    }

    public String getHeadEngineer() {
        return headEngineer;
    }

    public void setHeadEngineer(String headEngineer) {
        this.headEngineer = headEngineer == null ? null : headEngineer.trim();
    }

    public String getUserSignetMan() {
        return userSignetMan;
    }

    public void setUserSignetMan(String userSignetMan) {
        this.userSignetMan = userSignetMan == null ? null : userSignetMan.trim();
    }


    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }
}