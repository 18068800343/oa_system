package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class FlowNode {
    private String id;

    private String floNodeLeft;

    private String floTmpId;

    private String flownodename;

    private String tip;

    private Integer step;

    private Integer nodeworktype;

    private BigDecimal tspanday;

    private BigDecimal tspanhour;

    private BigDecimal warningday;

    private BigDecimal warninghour;

    private String fwcnodename;

    private String doc;

    private Integer returnrole;

    private Integer isexpsender;

    private Integer cancelrole;

    private Integer whennoworker;

    private Integer ccrole;

    private Integer iscanover;

    private Integer isrm;

    private Boolean ishandover;

    private Integer readreceipts;

    private Integer autojumprole0;

    private Integer autojumprole1;

    private Integer autojumprole2;

    private String sfactiveflows;

    private Integer outtimedeal;

    private String doouttime;

    private String formurl;

    private String turntodealdoc;

    private Integer isccflow;

    private String hisstas;

    private String hisdeptstrs;
    
    private String editOrView;

    private String nodeActorNames;
    
    private List<NodeActors> nodeActors;
    
    private Object[] roleIds;
    
    public String getEditOrView() {
		return editOrView;
	}

	public void setEditOrView(String editOrView) {
		this.editOrView = editOrView;
	}

	public Object[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Object[] roleIds) {
		this.roleIds = roleIds;
	}

	public String getNodeActorNames() {
		return nodeActorNames;
	}

	public void setNodeActorNames(String nodeActorNames) {
		this.nodeActorNames = nodeActorNames;
	}

	public List<NodeActors> getNodeActors() {
		return nodeActors;
	}

	public void setNodeActors(List<NodeActors> nodeActors) {
		this.nodeActors = nodeActors;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFloNodeLeft() {
        return floNodeLeft;
    }

    public void setFloNodeLeft(String floNodeLeft) {
        this.floNodeLeft = floNodeLeft == null ? null : floNodeLeft.trim();
    }

    public String getFloTmpId() {
        return floTmpId;
    }

    public void setFloTmpId(String floTmpId) {
        this.floTmpId = floTmpId == null ? null : floTmpId.trim();
    }

    public String getFlownodename() {
        return flownodename;
    }

    public void setFlownodename(String flownodename) {
        this.flownodename = flownodename == null ? null : flownodename.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getNodeworktype() {
        return nodeworktype;
    }

    public void setNodeworktype(Integer nodeworktype) {
        this.nodeworktype = nodeworktype;
    }

    public BigDecimal getTspanday() {
        return tspanday;
    }

    public void setTspanday(BigDecimal tspanday) {
        this.tspanday = tspanday;
    }

    public BigDecimal getTspanhour() {
        return tspanhour;
    }

    public void setTspanhour(BigDecimal tspanhour) {
        this.tspanhour = tspanhour;
    }

    public BigDecimal getWarningday() {
        return warningday;
    }

    public void setWarningday(BigDecimal warningday) {
        this.warningday = warningday;
    }

    public BigDecimal getWarninghour() {
        return warninghour;
    }

    public void setWarninghour(BigDecimal warninghour) {
        this.warninghour = warninghour;
    }

    public String getFwcnodename() {
        return fwcnodename;
    }

    public void setFwcnodename(String fwcnodename) {
        this.fwcnodename = fwcnodename == null ? null : fwcnodename.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public Integer getReturnrole() {
        return returnrole;
    }

    public void setReturnrole(Integer returnrole) {
        this.returnrole = returnrole;
    }

    public Integer getIsexpsender() {
        return isexpsender;
    }

    public void setIsexpsender(Integer isexpsender) {
        this.isexpsender = isexpsender;
    }

    public Integer getCancelrole() {
        return cancelrole;
    }

    public void setCancelrole(Integer cancelrole) {
        this.cancelrole = cancelrole;
    }

    public Integer getWhennoworker() {
        return whennoworker;
    }

    public void setWhennoworker(Integer whennoworker) {
        this.whennoworker = whennoworker;
    }

    public Integer getCcrole() {
        return ccrole;
    }

    public void setCcrole(Integer ccrole) {
        this.ccrole = ccrole;
    }

    public Integer getIscanover() {
        return iscanover;
    }

    public void setIscanover(Integer iscanover) {
        this.iscanover = iscanover;
    }

    public Integer getIsrm() {
        return isrm;
    }

    public void setIsrm(Integer isrm) {
        this.isrm = isrm;
    }

    public Boolean getIshandover() {
        return ishandover;
    }

    public void setIshandover(Boolean ishandover) {
        this.ishandover = ishandover;
    }

    public Integer getReadreceipts() {
        return readreceipts;
    }

    public void setReadreceipts(Integer readreceipts) {
        this.readreceipts = readreceipts;
    }

    public Integer getAutojumprole0() {
        return autojumprole0;
    }

    public void setAutojumprole0(Integer autojumprole0) {
        this.autojumprole0 = autojumprole0;
    }

    public Integer getAutojumprole1() {
        return autojumprole1;
    }

    public void setAutojumprole1(Integer autojumprole1) {
        this.autojumprole1 = autojumprole1;
    }

    public Integer getAutojumprole2() {
        return autojumprole2;
    }

    public void setAutojumprole2(Integer autojumprole2) {
        this.autojumprole2 = autojumprole2;
    }

    public String getSfactiveflows() {
        return sfactiveflows;
    }

    public void setSfactiveflows(String sfactiveflows) {
        this.sfactiveflows = sfactiveflows == null ? null : sfactiveflows.trim();
    }

    public Integer getOuttimedeal() {
        return outtimedeal;
    }

    public void setOuttimedeal(Integer outtimedeal) {
        this.outtimedeal = outtimedeal;
    }

    public String getDoouttime() {
        return doouttime;
    }

    public void setDoouttime(String doouttime) {
        this.doouttime = doouttime == null ? null : doouttime.trim();
    }

    public String getFormurl() {
        return formurl;
    }

    public void setFormurl(String formurl) {
        this.formurl = formurl == null ? null : formurl.trim();
    }

    public String getTurntodealdoc() {
        return turntodealdoc;
    }

    public void setTurntodealdoc(String turntodealdoc) {
        this.turntodealdoc = turntodealdoc == null ? null : turntodealdoc.trim();
    }

    public Integer getIsccflow() {
        return isccflow;
    }

    public void setIsccflow(Integer isccflow) {
        this.isccflow = isccflow;
    }

    public String getHisstas() {
        return hisstas;
    }

    public void setHisstas(String hisstas) {
        this.hisstas = hisstas == null ? null : hisstas.trim();
    }

    public String getHisdeptstrs() {
        return hisdeptstrs;
    }

    public void setHisdeptstrs(String hisdeptstrs) {
        this.hisdeptstrs = hisdeptstrs == null ? null : hisdeptstrs.trim();
    }
}