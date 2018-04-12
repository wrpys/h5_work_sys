package com.shirokumacafe.archetype.entity;

/**
 * @since 2018/4/12
 */
public class WorkQuestionExt extends  WorkQuestion {

    private String wWorkName;
    private String qTitle;

    public String getwWorkName() {
        return wWorkName;
    }

    public void setwWorkName(String wWorkName) {
        this.wWorkName = wWorkName;
    }

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle;
    }
}
