package com.shirokumacafe.archetype.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-12
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class AttendanceWorkInfo {

    private Integer sId;
    private String sNo;
    private String sName;
    private String attendances;
    private String attendanceInfos;
    private String works;
    private String workInfos;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getAttendances() {
        return attendances;
    }

    public void setAttendances(String attendances) {
        this.attendances = attendances;
    }

    public String getAttendanceInfos() {
        return attendanceInfos;
    }

    public void setAttendanceInfos(String attendanceInfos) {
        this.attendanceInfos = attendanceInfos;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public String getWorkInfos() {
        return workInfos;
    }

    public void setWorkInfos(String workInfos) {
        this.workInfos = workInfos;
    }
}
