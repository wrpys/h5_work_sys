package com.shirokumacafe.archetype.entity;

public class AttendAddr {
    private Integer aaId;

    private String aaName;

    private Integer aaPid;

    public Integer getAaId() {
        return aaId;
    }

    public void setAaId(Integer aaId) {
        this.aaId = aaId;
    }

    public String getAaName() {
        return aaName;
    }

    public void setAaName(String aaName) {
        this.aaName = aaName == null ? null : aaName.trim();
    }

    public Integer getAaPid() {
        return aaPid;
    }

    public void setAaPid(Integer aaPid) {
        this.aaPid = aaPid;
    }
}