package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class CourseTime {
    private Integer ctId;

    private Integer cId;

    private Date ctTime;

    private Integer isAttendance;

    private Integer isWork;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
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