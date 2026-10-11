package com.team404.visualwith.entity;

import com.team404.visualwith.dto.calendar.CalAddRequest;
import com.team404.visualwith.dto.calendar.CalUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schedule")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "schedule_id")
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content;

    // 생성된 날짜와 시간 사용자가 임의 조작 불가
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
//    @Column(nullable = false)
//    private LocalDate createdDate;
//
//    @Column(nullable = false)
//    private LocalTime createdTime;

    // 일정이 시작될 시간
    @Column(name = "start_time")
    private LocalDateTime startAt;
//    private LocalDate startDate;
//    private LocalTime startTime;

    @Column(name="end_time")
    private LocalDateTime completeAt;
//    private LocalDate completeDate;
//    private LocalTime completeTime;
    private Boolean wholeDay;

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false, name = "creator_id")
    private String userId;

    public Calendar(CalAddRequest calAddRequest, String userId) {
        this.teamId = calAddRequest.getTeamId();
        this.userId = userId;
        this.title = calAddRequest.getTitle();
        this.content = calAddRequest.getContent();
        this.wholeDay = calAddRequest.getWholeDay();
        this.createdAt = LocalDate.parse(calAddRequest.getCreatedDate()).atTime(LocalTime.parse(calAddRequest.getCreatedTime()));
//        this.createdDate = LocalDate.parse(calAddRequest.getCreatedDate());
//        this.createdTime = LocalTime.parse(calAddRequest.getCreatedTime());

        // start 시간
        if(calAddRequest.getStartDate().isEmpty()) {
            this.startAt = null;
        }
        else {
            this.startAt = LocalDate.parse(calAddRequest.getStartDate()).atTime(LocalTime.parse(calAddRequest.getStartTime()));
        }
//        if(calAddRequest.getStartDate().isEmpty()){
//            this.startDate = null;
//        }
//        else{
//            this.startDate = LocalDate.parse(calAddRequest.getStartDate());
//        }
//
//        if(calAddRequest.getStartTime().isEmpty()){
//            this.startTime = null;
//        }
//        else{
//            this.startTime = LocalTime.parse(calAddRequest.getStartTime());
//        }

        // complete 시간
        if(calAddRequest.getCompleteDate().isEmpty()) {
            this.completeAt = null;
        }
        else {
            this.completeAt = LocalDate.parse(calAddRequest.getCompleteDate()).atTime(LocalTime.parse(calAddRequest.getCompleteTime()));
        }
//        if(calAddRequest.getCompleteDate().isEmpty()){
//            this.completeDate = null;
//        }
//        else{
//            this.completeDate = LocalDate.parse(calAddRequest.getCompleteDate());
//        }

//        if(calAddRequest.getCompleteTime().isEmpty()){
//            this.completeTime = null;
//        }
//        else{
//            this.completeTime = LocalTime.parse(calAddRequest.getCompleteTime());
//        }
    }

    public void update(CalUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.wholeDay = request.getWholeDay();

        // start 시간
        if(request.getStartDate().isEmpty()) {
            this.startAt = null;
        }
        else {
            this.startAt = LocalDate.parse(request.getStartDate()).atTime(LocalTime.parse(request.getStartTime()));
        }
//        if(request.getStartDate().isEmpty()){
//            this.startDate = null;
//        }
//        else {
//            this.startDate = LocalDate.parse(request.getStartDate());
//        }
//
//        if(request.getStartTime().isEmpty()) {
//            this.startTime = null;
//        }
//        else {
//            this.startTime = LocalTime.parse(request.getStartTime());
//        }

        // complete 시간
        if(request.getCompleteDate().isEmpty()) {
            this.completeAt = null;
        }
        else {
            this.completeAt = LocalDate.parse(request.getCompleteDate()).atTime(LocalTime.parse(request.getCompleteTime()));
        }
//        if(request.getCompleteDate().isEmpty()){
//            this.completeDate = null;
//        }
//        else {
//            this.completeDate = LocalDate.parse(request.getCompleteDate());
//        }
//
//        if(request.getCompleteTime().isEmpty()) {
//            this.completeTime = null;
//        }
//        else {
//            this.completeTime = LocalTime.parse(request.getCompleteTime());
//        }
    }
}
