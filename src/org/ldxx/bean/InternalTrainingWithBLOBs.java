package org.ldxx.bean;

public class InternalTrainingWithBLOBs extends InternalTraining {
    private String trainingDesc;

    private String trainingReason;

    public String getTrainingDesc() {
        return trainingDesc;
    }

    public void setTrainingDesc(String trainingDesc) {
        this.trainingDesc = trainingDesc == null ? null : trainingDesc.trim();
    }

    public String getTrainingReason() {
        return trainingReason;
    }

    public void setTrainingReason(String trainingReason) {
        this.trainingReason = trainingReason == null ? null : trainingReason.trim();
    }
}