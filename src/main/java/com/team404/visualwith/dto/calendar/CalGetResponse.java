package com.team404.visualwith.dto.calendar;

import com.team404.visualwith.entity.Calendar;

public class CalGetResponse {
    private Long id;
    private String userId;
    private String title;
    private String content;
    private String startDate;
    private String startTime;
    private String completeDate;
    private String compltetTime;

    public CalGetResponse() {

    }

    public CalGetResponse(Calendar cal) {
        this.id = cal.getId();
        this.userId = cal.getUserId();
        this.title = cal.getTitle();
        this.content = cal.getContent();
        this.startDate = cal.getStartDate();
        this.startTime = cal.getStartTime();
        this.completeDate = cal.getCompleteDate();
        this.compltetTime = cal.getCompleteTime();
    }

    //Getter
    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public String getCompltetTime() {
        return compltetTime;
    }

    //Setter
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public void setCompltetTime(String compltetTime) {
        this.compltetTime = compltetTime;
    }
}
