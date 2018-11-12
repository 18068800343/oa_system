package org.ldxx.bean;
//项目风险评估
public class RiskAssessment {
    private String raId;

    private String prjId;
    
    private String prjNo;
    
    private String prjScale;
    
    private String prjType;

    private String pecificAssessment;

    private String flows;

    private String profitability;

    private String contractModel;

    private String conditionsTerms;

    private String priceAdjustment;

    private String paymentClause;

    private String culturalEnvironment;

    private String geographicalConditions;

    private String technicalDifficulty;

    private String safetyManagementDifficulty;

    private String evaluationMethod;


    
    public String getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}

	public String getPrjScale() {
		return prjScale;
	}

	public void setPrjScale(String prjScale) {
		this.prjScale = prjScale;
	}

	public String getPrjType() {
		return prjType;
	}

	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}

	public String getRaId() {
        return raId;
    }

    public void setRaId(String raId) {
        this.raId = raId == null ? null : raId.trim();
    }

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getPecificAssessment() {
        return pecificAssessment;
    }

    public void setPecificAssessment(String pecificAssessment) {
        this.pecificAssessment = pecificAssessment == null ? null : pecificAssessment.trim();
    }

    public String getFlows() {
        return flows;
    }

    public void setFlows(String flows) {
        this.flows = flows == null ? null : flows.trim();
    }

    public String getProfitability() {
        return profitability;
    }

    public void setProfitability(String profitability) {
        this.profitability = profitability == null ? null : profitability.trim();
    }

    public String getContractModel() {
        return contractModel;
    }

    public void setContractModel(String contractModel) {
        this.contractModel = contractModel == null ? null : contractModel.trim();
    }

    public String getConditionsTerms() {
        return conditionsTerms;
    }

    public void setConditionsTerms(String conditionsTerms) {
        this.conditionsTerms = conditionsTerms == null ? null : conditionsTerms.trim();
    }

    public String getPriceAdjustment() {
        return priceAdjustment;
    }

    public void setPriceAdjustment(String priceAdjustment) {
        this.priceAdjustment = priceAdjustment == null ? null : priceAdjustment.trim();
    }

    public String getPaymentClause() {
        return paymentClause;
    }

    public void setPaymentClause(String paymentClause) {
        this.paymentClause = paymentClause == null ? null : paymentClause.trim();
    }

    public String getCulturalEnvironment() {
        return culturalEnvironment;
    }

    public void setCulturalEnvironment(String culturalEnvironment) {
        this.culturalEnvironment = culturalEnvironment == null ? null : culturalEnvironment.trim();
    }


    public String getGeographicalConditions() {
        return geographicalConditions;
    }

    public void setGeographicalConditions(String geographicalConditions) {
        this.geographicalConditions = geographicalConditions == null ? null : geographicalConditions.trim();
    }

    public String getTechnicalDifficulty() {
        return technicalDifficulty;
    }

    public void setTechnicalDifficulty(String technicalDifficulty) {
        this.technicalDifficulty = technicalDifficulty == null ? null : technicalDifficulty.trim();
    }

    public String getSafetyManagementDifficulty() {
        return safetyManagementDifficulty;
    }

    public void setSafetyManagementDifficulty(String safetyManagementDifficulty) {
        this.safetyManagementDifficulty = safetyManagementDifficulty == null ? null : safetyManagementDifficulty.trim();
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    public void setEvaluationMethod(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod == null ? null : evaluationMethod.trim();
    }


}