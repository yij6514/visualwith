package com.team404.visualwith.entity;

import jakarta.persistence.*;

@Entity
@Table(name="todos")
public class Todo {

    // 할일목록 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String creatorId; // 작성자 ID
    private String modifierId; // 수정자 ID

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String title;
    private String content;

    @Column(nullable = false)
    private Boolean completed;

    private String createdDate;
    private String createdTime;

    private String completeDate;
    private String completeTime;

    public Todo() {}

    public Todo(Long id, String title, String content,
                String createdDate, String createdTime,
                String completeDate, String completeTime,
                Boolean completed, String creatorId, String modifier, String teamId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.completeDate = completeDate;
        this.completeTime = completeTime;
        this.completed = completed;
        this.creatorId = creatorId;
        this.modifierId = modifier;
        this.teamId = teamId;
    }

    //getter

    public Long getId() {return id;}

    public String getCreatorId() {return creatorId;}
    public String getModifierId() {return modifierId;}
    public String getTeamId() {return teamId;}

    public String getTitle() {return title;}
    public String getContent() {return content;}

    public Boolean getCompleted() {return completed;}

    public String getCreatedDate() {return createdDate;}
    public String getCreatedTime() {return createdTime;}

    public String getCompleteDate() {return completeDate;}
    public String getCompleteTime() {return completeTime;}

    //setter

    public void setCreatorId(String creatorId) {this.creatorId = creatorId;}
    public void setModifierId(String modifierId) {this.modifierId = modifierId;}
    public void setTeamId(String teamId) {this.teamId = teamId;}

    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}

    public void setCompleted(Boolean completed) {this.completed = completed;}

    public void setCreatedDate(String createdDate) {this.createdDate = createdDate;}
    public void setCreatedTime(String createdTime) {this.createdTime = createdTime;}

    public void setCompleteDate(String completeDate) {this.completeDate = completeDate;}
    public void setCompleteTime(String completeTime) {this.completeTime = completeTime;}
}
