package org.ldxx.bean;

public class ProjectOver {
	/*编号*/
    private String poId;
    /*日期*/
    private String poDate;
    /*序号*/
    private String poNo;

    /*项目名称*/
    private String prjName;
    /*项目编号*/
    private String prjNo;
    
    /*标段编号*/
    private String bdNo;
    //项目类型
    private String prjType;

    /*业主单位*/
    private String productOwners;
    
    /*项目概况*/
    private String prjDesc;

    /*合同金额*/
    private Float contractAmount;

    /*项目工期*/
    private String projectDuration;

    /*中标项目经理*/
    private String projectManager;

    /*中标项目总工*/
    private String projectEngineer;

    /*管理模式*/
    private String managementModel;
    
    /*中标单位*/
    private String tenderCompany;

    /*跟踪部门或信息来源*/
    private String messageSource;

    /*经营负责人*/
    private String businessDirector;

    /*交接内容*/
    private String transferContent;

    /*代办内容*/
    private String contentBacklog;

    /*是否移交状态*/
    private int status;

    
    public String getBdNo() {
		return bdNo;
	}

	public void setBdNo(String bdNo) {
		this.bdNo = bdNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPrjType() {
		return prjType;
	}

	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}

	public String getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}


	public String getTenderCompany() {
		return tenderCompany;
	}

	public void setTenderCompany(String tenderCompany) {
		this.tenderCompany = tenderCompany;
	}

	public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId == null ? null : poId.trim();
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate == null ? null : poDate.trim();
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo == null ? null : poNo.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getProductOwners() {
        return productOwners;
    }

    public void setProductOwners(String productOwners) {
        this.productOwners = productOwners == null ? null : productOwners.trim();
    }

    public String getPrjDesc() {
        return prjDesc;
    }

    public void setPrjDesc(String prjDesc) {
        this.prjDesc = prjDesc == null ? null : prjDesc.trim();
    }

    

    public Float getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(Float contractAmount) {
		this.contractAmount = contractAmount;
	}

	public String getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(String projectDuration) {
        this.projectDuration = projectDuration == null ? null : projectDuration.trim();
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager == null ? null : projectManager.trim();
    }

    public String getProjectEngineer() {
        return projectEngineer;
    }

    public void setProjectEngineer(String projectEngineer) {
        this.projectEngineer = projectEngineer == null ? null : projectEngineer.trim();
    }

    public String getManagementModel() {
        return managementModel;
    }

    public void setManagementModel(String managementModel) {
        this.managementModel = managementModel == null ? null : managementModel.trim();
    }

    public String getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(String messageSource) {
        this.messageSource = messageSource == null ? null : messageSource.trim();
    }

    public String getBusinessDirector() {
        return businessDirector;
    }

    public void setBusinessDirector(String businessDirector) {
        this.businessDirector = businessDirector == null ? null : businessDirector.trim();
    }

    public String getTransferContent() {
        return transferContent;
    }

    public void setTransferContent(String transferContent) {
        this.transferContent = transferContent == null ? null : transferContent.trim();
    }

    public String getContentBacklog() {
        return contentBacklog;
    }

    public void setContentBacklog(String contentBacklog) {
        this.contentBacklog = contentBacklog == null ? null : contentBacklog.trim();
    }

}