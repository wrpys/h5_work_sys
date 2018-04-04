package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class ViewAttendance {
    private Integer aId;

    private Integer sId;

    private Integer cId;

    private Integer tId;

    private Date aAddTime;

    private Integer aStatus;

    private String nickName;

    private String sNo;

    private String sName;

    private String cName;

    private Date cAttendTime;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Date getaAddTime() {
        return aAddTime;
    }

    public void setaAddTime(Date aAddTime) {
        this.aAddTime = aAddTime;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Date getcAttendTime() {
        return cAttendTime;
    }

    public void setcAttendTime(Date cAttendTime) {
        this.cAttendTime = cAttendTime;
    }
}