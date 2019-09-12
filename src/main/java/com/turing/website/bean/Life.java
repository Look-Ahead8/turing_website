package com.turing.website.bean;

import java.util.Date;

public class Life {
    private Integer lifeId;

    private Integer mId;

    private String context;

    private Date lifeDate;

    public Integer getLifeId() {
        return lifeId;
    }

    public void setLifeId(Integer lifeId) {
        this.lifeId = lifeId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Date getLifeDate() {
        return lifeDate;
    }

    public void setLifeDate(Date lifeDate) {
        this.lifeDate = lifeDate;
    }
}