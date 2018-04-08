package com.shirokumacafe.archetype.entity;

public class Answer {
    private Integer aId;

    private String aAnswer;

    private Integer qId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaAnswer() {
        return aAnswer;
    }

    public void setaAnswer(String aAnswer) {
        this.aAnswer = aAnswer == null ? null : aAnswer.trim();
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }
}