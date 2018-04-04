package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class ViewMessage {
    private Integer msgId;

    private Integer msgPid;

    private Integer userId;

    private Integer studentId;

    private Integer sendRole;

    private String msgContent;

    private Date msgAddTime;

    private Integer msgIsRead;

    private String roleName;

    private Integer msgIsReply;

    private String teacherName;

    private String studentName;

    private String sNo;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgPid() {
        return msgPid;
    }

    public void setMsgPid(Integer msgPid) {
        this.msgPid = msgPid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSendRole() {
        return sendRole;
    }

    public void setSendRole(Integer sendRole) {
        this.sendRole = sendRole;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Date getMsgAddTime() {
        return msgAddTime;
    }

    public void setMsgAddTime(Date msgAddTime) {
        this.msgAddTime = msgAddTime;
    }

    public Integer getMsgIsRead() {
        return msgIsRead;
    }

    public void setMsgIsRead(Integer msgIsRead) {
        this.msgIsRead = msgIsRead;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getMsgIsReply() {
        return msgIsReply;
    }

    public void setMsgIsReply(Integer msgIsReply) {
        this.msgIsReply = msgIsReply;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }
}