package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class ViewCourseInfo {
    private Integer ciId;

    private Integer cId;

    private Integer ctId;

    private Integer sId;

    private Integer attendanceInfo;

    private Integer workInfo;

    private String sNo;

    private String sName;

    private String cName;

    private Date ctTime;

    public Integer getCiId() {
        return ciId;
    }

    public void setCiId(Integer ciId) {
        this.ciId = ciId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getAttendanceInfo() {
        return attendanceInfo;
    }

    public void setAttendanceInfo(Integer attendanceInfo) {
        this.attendanceInfo = attendanceInfo;
    }

    public Integer getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(Integer workInfo) {
        this.workInfo = workInfo;
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

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }
}