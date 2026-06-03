package com.team404.visualwith.entity;

import com.team404.visualwith.dto.calendar.CalAddRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
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
    private LocalDate createdDate;

    @Column(nullable = false)
    private LocalTime createdTime;

    // 일정이 시작될 시간
    private LocalDate startDate;
    private LocalTime startTime;
    
    private LocalDate completeDate;
    private LocalTime completeTime;
    private Boolean wholeDay;

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String userId;

    public Calendar() {
    }

    public Calendar(String teamId, String userId,
                    String title, String content,
                    LocalDate createdDate, LocalTime createdTime,
                    LocalDate startDate, LocalTime startTime,
                    LocalDate completeDate, LocalTime completeTime,
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

    public Calendar(CalAddRequest calAddRequest) {
        this.teamId = calAddRequest.getTeamId();
        this.userId = calAddRequest.getUserId();
        this.title = calAddRequest.getTitle();
        this.content = calAddRequest.getContent();
        this.startDate = LocalDate.parse(calAddRequest.getStartDate());
        this.startTime = LocalTime.parse(calAddRequest.getStartTime());
        this.createdDate = LocalDate.parse(calAddRequest.getCreatedDate());
        this.createdTime = LocalTime.parse(calAddRequest.getCreatedTime());
        this.completeDate = LocalDate.parse(calAddRequest.getCompleteDate());
        this.completeTime = LocalTime.parse(calAddRequest.getCompleteTime());
        this.wholeDay = calAddRequest.getWholeDay();
    }
}
