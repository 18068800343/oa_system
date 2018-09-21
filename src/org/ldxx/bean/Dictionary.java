package org.ldxx.bean;

public class Dictionary {
    private String dId;

    private String idFirst;

    private String nameSecond;
    
    
	public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId == null ? null : dId.trim();
    }

    public String getIdFirst() {
        return idFirst;
    }

    public void setIdFirst(String idFirst) {
        this.idFirst = idFirst == null ? null : idFirst.trim();
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond == null ? null : nameSecond.trim();
    }
}