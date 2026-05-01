package com.team404.visualwith.entity;

import jakarta.persistence.*;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content;

    // 생성된 날짜와 시간 사용자가 임의 조작 불가
    @Column(nullable = false)
    private String createdDate;

    @Column(nullable = false)
    private String createdTime;

    // 일정이 시작될 시간
    private String startDate;
    private String startTime;
    
    private String completeDate;
    private String completeTime;
    private Boolean wholeDay;

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String userId;

    public Calendar() {
    }

    public Calendar(String teamId, String userId,
                    String title, String content,
                    String createdDate, String createdTime,
                    String startDate, String startTime,
                    String completeDate, String completeTime,
                    Boolean wholeDay) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.startDate = startDate;
        this.startTime = startTime;
        this.completeDate = completeDate;
        this.completeTime = completeTime;
        this.wholeDay = wholeDay;
        this.teamId = teamId;
        this.userId = userId;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
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

    public String getCompleteTime() {
        return completeTime;
    }

    public Boolean getWholeDay() {
        return wholeDay;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getUserId() {
        return userId;
    }


    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
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

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public void setWholeDay(Boolean wholeDay) {
        this.wholeDay = wholeDay;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
