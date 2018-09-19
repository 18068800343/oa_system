package org.ldxx.bean;

public class NodeActors {
    private String id;

    private String rolecode;

    private String floNodeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getFloNodeId() {
        return floNodeId;
    }

    public void setFloNodeId(String floNodeId) {
        this.floNodeId = floNodeId == null ? null : floNodeId.trim();
    }
}