package com.shirokumacafe.archetype.entity;

public class Department {
    private Integer dId;

    private Boolean leaf;

    private String dName;

    private Integer dPid;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getdPid() {
        return dPid;
    }

    public void setdPid(Integer dPid) {
        this.dPid = dPid;
    }
}