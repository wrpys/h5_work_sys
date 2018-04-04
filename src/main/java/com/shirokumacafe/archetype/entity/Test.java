package com.shirokumacafe.archetype.entity;

import java.util.Date;

public class Test {
    private Integer testId;

    private String testTitle;

    private String testOptionA;

    private String testOptionB;

    private String testOptionC;

    private String testOptionD;

    private Integer testAnswer;

    private Date addTime;

    private Integer trueAnswer;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle == null ? null : testTitle.trim();
    }

    public String getTestOptionA() {
        return testOptionA;
    }

    public void setTestOptionA(String testOptionA) {
        this.testOptionA = testOptionA == null ? null : testOptionA.trim();
    }

    public String getTestOptionB() {
        return testOptionB;
    }

    public void setTestOptionB(String testOptionB) {
        this.testOptionB = testOptionB == null ? null : testOptionB.trim();
    }

    public String getTestOptionC() {
        return testOptionC;
    }

    public void setTestOptionC(String testOptionC) {
        this.testOptionC = testOptionC == null ? null : testOptionC.trim();
    }

    public String getTestOptionD() {
        return testOptionD;
    }

    public void setTestOptionD(String testOptionD) {
        this.testOptionD = testOptionD == null ? null : testOptionD.trim();
    }

    public Integer getTestAnswer() {
        return testAnswer;
    }

    public void setTestAnswer(Integer testAnswer) {
        this.testAnswer = testAnswer;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(Integer trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}