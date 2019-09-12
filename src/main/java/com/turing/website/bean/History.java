package com.turing.website.bean;

import java.util.Date;

public class History {
    private Integer historyId;

    private String message;

    private Date histroyDate;

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getHistroyDate() {
        return histroyDate;
    }

    public void setHistroyDate(Date histroyDate) {
        this.histroyDate = histroyDate;
    }
}