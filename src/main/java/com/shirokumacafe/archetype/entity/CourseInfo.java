package com.shirokumacafe.archetype.entity;

public class CourseInfo {
    private Integer ciId;

    private Integer cId;

    private Integer ctId;

    private Integer sId;

    private Integer attendanceInfo;

    private Integer workInfo;

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
}