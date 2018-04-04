package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class Work {
    private Integer wId;

    private Integer cId;

    private String cName;

    private Date wAddTime;

    private String wDesc;

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Date getwAddTime() {
        return wAddTime;
    }

    public void setwAddTime(Date wAddTime) {
        this.wAddTime = wAddTime;
    }

    public String getwDesc() {
        return wDesc;
    }

    public void setwDesc(String wDesc) {
        this.wDesc = wDesc == null ? null : wDesc.trim();
    }
}