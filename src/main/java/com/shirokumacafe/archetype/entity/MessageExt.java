package com.shirokumacafe.archetype.entity;

public class MessageExt extends Message {

    private String operRoleName;

    private String operName;

    private MessageExt messageExt;

    public String getOperRoleName() {
        return operRoleName;
    }

    public void setOperRoleName(String operRoleName) {
        this.operRoleName = operRoleName;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public MessageExt getMessageExt() {
        return messageExt;
    }

    public void setMessageExt(MessageExt messageExt) {
        this.messageExt = messageExt;
    }
}