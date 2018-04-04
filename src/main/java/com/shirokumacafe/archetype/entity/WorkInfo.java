package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class WorkInfo {
    private Integer wiId;

    private Integer wId;

    private Integer sId;

    private Date wiAddTime;

    private String wiFileName;

    private String wiFileAddr;

    private Integer wiFileSize;

    private String wIDesc;

    public Integer getWiId() {
        return wiId;
    }

    public void setWiId(Integer wiId) {
        this.wiId = wiId;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Date getWiAddTime() {
        return wiAddTime;
    }

    public void setWiAddTime(Date wiAddTime) {
        this.wiAddTime = wiAddTime;
    }

    public String getWiFileName() {
        return wiFileName;
    }

    public void setWiFileName(String wiFileName) {
        this.wiFileName = wiFileName == null ? null : wiFileName.trim();
    }

    public String getWiFileAddr() {
        return wiFileAddr;
    }

    public void setWiFileAddr(String wiFileAddr) {
        this.wiFileAddr = wiFileAddr == null ? null : wiFileAddr.trim();
    }

    public Integer getWiFileSize() {
        return wiFileSize;
    }

    public void setWiFileSize(Integer wiFileSize) {
        this.wiFileSize = wiFileSize;
    }

    public String getwIDesc() {
        return wIDesc;
    }

    public void setwIDesc(String wIDesc) {
        this.wIDesc = wIDesc == null ? null : wIDesc.trim();
    }
}