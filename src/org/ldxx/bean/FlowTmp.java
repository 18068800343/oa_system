package org.ldxx.bean;

import java.util.List;

public class FlowTmp {
    private String id;

    private String rownum;
    
    private String flowname;

    private String flowmemo;

    private String flowevententity;

    private Integer flowrunway;

    private Integer pmydept;

    private Integer ppmydept;

    private Integer ppdept;

    private Integer psamedept;

    private Integer pspecdept;

    private String pspecdeptext;

    private String pspecstaext;

    private String pspecempext;

    private String pspeclevel;

    private List<FlowNode> flowNodes;
    
    
    public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public List<FlowNode> getFlowNodes() {
		return flowNodes;
	}

	public void setFlowNodes(List<FlowNode> flowNodes) {
		this.flowNodes = flowNodes;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFlowname() {
        return flowname;
    }

    public void setFlowname(String flowname) {
        this.flowname = flowname == null ? null : flowname.trim();
    }

    public String getFlowmemo() {
        return flowmemo;
    }

    public void setFlowmemo(String flowmemo) {
        this.flowmemo = flowmemo == null ? null : flowmemo.trim();
    }

    public String getFlowevententity() {
        return flowevententity;
    }

    public void setFlowevententity(String flowevententity) {
        this.flowevententity = flowevententity == null ? null : flowevententity.trim();
    }

    public Integer getFlowrunway() {
        return flowrunway;
    }

    public void setFlowrunway(Integer flowrunway) {
        this.flowrunway = flowrunway;
    }

    public Integer getPmydept() {
        return pmydept;
    }

    public void setPmydept(Integer pmydept) {
        this.pmydept = pmydept;
    }

    public Integer getPpmydept() {
        return ppmydept;
    }

    public void setPpmydept(Integer ppmydept) {
        this.ppmydept = ppmydept;
    }

    public Integer getPpdept() {
        return ppdept;
    }

    public void setPpdept(Integer ppdept) {
        this.ppdept = ppdept;
    }

    public Integer getPsamedept() {
        return psamedept;
    }

    public void setPsamedept(Integer psamedept) {
        this.psamedept = psamedept;
    }

    public Integer getPspecdept() {
        return pspecdept;
    }

    public void setPspecdept(Integer pspecdept) {
        this.pspecdept = pspecdept;
    }

    public String getPspecdeptext() {
        return pspecdeptext;
    }

    public void setPspecdeptext(String pspecdeptext) {
        this.pspecdeptext = pspecdeptext == null ? null : pspecdeptext.trim();
    }

    public String getPspecstaext() {
        return pspecstaext;
    }

    public void setPspecstaext(String pspecstaext) {
        this.pspecstaext = pspecstaext == null ? null : pspecstaext.trim();
    }

    public String getPspecempext() {
        return pspecempext;
    }

    public void setPspecempext(String pspecempext) {
        this.pspecempext = pspecempext == null ? null : pspecempext.trim();
    }

    public String getPspeclevel() {
        return pspeclevel;
    }

    public void setPspeclevel(String pspeclevel) {
        this.pspeclevel = pspeclevel == null ? null : pspeclevel.trim();
    }
}