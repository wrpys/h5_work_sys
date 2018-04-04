package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class ViewCourse {
    private Integer cId;

    private String cName;

    private Integer tId;

    private Date cAttendTime;

    private Integer cAttendAddr;

    private String nickName;

    private String aaName;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAaName() {
        return aaName;
    }

    public void setAaName(String aaName) {
        this.aaName = aaName == null ? null : aaName.trim();
    }
}