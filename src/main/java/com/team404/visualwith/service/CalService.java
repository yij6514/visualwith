package com.team404.visualwith.service;

import com.team404.visualwith.dto.calendar.*;
import com.team404.visualwith.entity.Calendar;
import com.team404.visualwith.entity.UserTeamRole;
import com.team404.visualwith.repository.CalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalService {
    private final CalRepository calRepository;

    public CalService(CalRepository calRepository) {
        this.calRepository = calRepository;
    }

    public List<CalGetResponse> getCal(String teamId) {
        List<Calendar> calList = calRepository.findByTeamId(teamId);
        List<CalGetResponse> list = new ArrayList<>();
        for(Calendar cal : calList) {
            list.add(new CalGetResponse(cal));
        }
        return list;
    }

    public CalAddResponse createCal(CalAddRequest calAddRequest) {
        Calendar cal = calRepository.save(new Calendar(calAddRequest));
        return new CalAddResponse(cal.getId());
    }

    public void updateCal(CalUpdateRequest calUpdateRequest) {
        Calendar cal = calRepository.findById(calUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Calenar 없음"));
        if(!(calUpdateRequest.getUserId().equals(cal.getUserId())
                || calUpdateRequest.getUserTeamRole() == UserTeamRole.ADMIN
                || calUpdateRequest.getUserTeamRole() == UserTeamRole.SUB_ADMIN)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        cal.setTitle(calUpdateRequest.getTitle());
        cal.setContent(calUpdateRequest.getContent());
        cal.setStartDate(LocalDate.parse(calUpdateRequest.getStartDate()));
        cal.setStartTime(LocalTime.parse(calUpdateRequest.getStartTime()));
        cal.setCompleteDate(LocalDate.parse(calUpdateRequest.getCompleteDate()));
        cal.setCompleteTime(LocalTime.parse(calUpdateRequest.getCompleteTime()));
        cal.setWholeDay(calUpdateRequest.getWholeDay());
        calRepository.save(cal);
    }

    public void deleteCal(CalDeleteRequest calDeleteRequest) {
        Calendar cal = calRepository.findById(calDeleteRequest.getId())
                .orElseThrow(() -> new RuntimeException("Calenar 없음"));
        if(!(calDeleteRequest.getUserId().equals(cal.getUserId())
                || calDeleteRequest.getUserTeamRole() == UserTeamRole.ADMIN
                || calDeleteRequest.getUserTeamRole() == UserTeamRole.SUB_ADMIN)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        calRepository.deleteById(calDeleteRequest.getId());
    }
}
