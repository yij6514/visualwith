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

    public CalAddResponse createCal(CalAddRequest calAddRequest, String userId) {
        Calendar cal = calRepository.save(new Calendar(calAddRequest, userId));
        return new CalAddResponse(cal.getId());
    }

    public void updateCal(CalUpdateRequest calUpdateRequest, String userId) {
        Calendar cal = calRepository.findById(calUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Calenar 없음"));
        if(!(userId.equals(cal.getUserId())
                || calUpdateRequest.getUserTeamRole() != UserTeamRole.MEMBER)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        cal.update(calUpdateRequest);
        calRepository.save(cal);
    }

    public void deleteCal(CalDeleteRequest calDeleteRequest, String userId) {
        Calendar cal = calRepository.findById(calDeleteRequest.getId())
                .orElseThrow(() -> new RuntimeException("Calenar 없음"));
        if(!(userId.equals(cal.getUserId())
                || calDeleteRequest.getUserTeamRole() != UserTeamRole.MEMBER)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        calRepository.deleteById(calDeleteRequest.getId());
    }
}
