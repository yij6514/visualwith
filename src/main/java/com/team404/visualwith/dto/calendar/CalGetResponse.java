package com.team404.visualwith.dto.calendar;

import com.team404.visualwith.entity.Calendar;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalGetResponse {
    private Long id;
    private String userId;
    private String title;
    private String content;
    private String startDate;
    private String startTime;
    private String completeDate;
    private String completeTime;
    private boolean wholeDay;

    public CalGetResponse() {}

    public CalGetResponse(Calendar cal) {
        this.id = cal.getId();
        this.userId = cal.getUserId();
        this.title = cal.getTitle();
        this.content = cal.getContent();

        if(cal.getStartAt() == null) {
            this.startDate = "";
            this.startTime = "";
        }
        else {
            this.startDate = cal.getStartAt().toLocalDate().toString();
            this.startTime = cal.getStartAt().toLocalTime().toString();
        }
//        if(cal.getStartDate() == null) {
//            this.startDate = "";
//        }
//        else {
//            this.startDate = cal.getStartDate().toString();
//        }
//        if(cal.getStartTime() == null) {
//            this.startTime = "";
//        }
//        else {
//            this.startTime = cal.getStartTime().toString();
//        }


        // complete
        if(cal.getCompleteAt() == null) {
            this.completeDate = "";
            this.completeTime = "";
        }
        else {
            this.completeDate = cal.getCompleteAt().toLocalDate().toString();
            this.completeTime = cal.getCompleteAt().toLocalTime().toString();
        }
//        if(cal.getCompleteDate() == null) {
//            this.completeDate = "";
//        }
//        else {
//            this.completeDate = cal.getCompleteDate().toString();
//        }
//        if(cal.getCompleteTime() == null) {
//            this.completeTime = "";
//        }
//        else {
//            this.completeTime = cal.getCompleteTime().toString();
//        }

        this.wholeDay = cal.getWholeDay();
    }
}
