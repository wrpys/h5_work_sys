package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class Message {
    private Integer msgId;

    private Integer msgPid;

    private Integer sendRole;

    private Integer studentId;

    private Integer userId;

    private String msgContent;

    private Date msgAddTime;

    private Integer msgIsReply;

    private Integer msgIsRead;

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

    public Integer getSendRole() {
        return sendRole;
    }

    public void setSendRole(Integer sendRole) {
        this.sendRole = sendRole;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getMsgIsReply() {
        return msgIsReply;
    }

    public void setMsgIsReply(Integer msgIsReply) {
        this.msgIsReply = msgIsReply;
    }

    public Integer getMsgIsRead() {
        return msgIsRead;
    }

    public void setMsgIsRead(Integer msgIsRead) {
        this.msgIsRead = msgIsRead;
    }
}