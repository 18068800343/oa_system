package org.ldxx.bean;

public class Business {
    private String id;

    private String floTmpId;

    private String businessname;

    private String businessurl;

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

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname == null ? null : businessname.trim();
    }

    public String getBusinessurl() {
        return businessurl;
    }

    public void setBusinessurl(String businessurl) {
        this.businessurl = businessurl == null ? null : businessurl.trim();
    }
}