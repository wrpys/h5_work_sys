package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class ViewAttendanceWork {
    private Integer cId;

    private Integer sId;

    private Integer attendance;

    private Integer work;

    private String sNo;

    private String sName;

    private String cName;

    private Date cAttendTime;

    private Integer isAttendance;

    private Integer isWork;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
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

    public Integer getIsAttendance() {
        return isAttendance;
    }

    public void setIsAttendance(Integer isAttendance) {
        this.isAttendance = isAttendance;
    }

    public Integer getIsWork() {
        return isWork;
    }

    public void setIsWork(Integer isWork) {
        this.isWork = isWork;
    }
}