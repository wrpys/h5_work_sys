package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class Course {
    private Integer cId;

    private String cName;

    private Integer tId;

    private Date cAttendTime;

    private Integer cAttendAddr;

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

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Date getcAttendTime() {
        return cAttendTime;
    }

    public void setcAttendTime(Date cAttendTime) {
        this.cAttendTime = cAttendTime;
    }

    public Integer getcAttendAddr() {
        return cAttendAddr;
    }

    public void setcAttendAddr(Integer cAttendAddr) {
        this.cAttendAddr = cAttendAddr;
    }
}