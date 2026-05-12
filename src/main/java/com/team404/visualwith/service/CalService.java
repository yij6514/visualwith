package com.team404.visualwith.service;

import com.team404.visualwith.dto.calendar.*;
import com.team404.visualwith.entity.Calendar;
import com.team404.visualwith.repository.CalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalService {
    private final CalRepository calRepository;

    public CalService(CalRepository calRepository) {
        this.calRepository = calRepository;
    }

    public List<CalGetResponse> getCal(String teamId) {
        //TODO
        List<Calendar> calList = calRepository.findByTeamId(teamId);
        List<CalGetResponse> list = new ArrayList<>();
        for(Calendar cal : calList) {
            list.add(new CalGetResponse(cal));
        }
        return list;
    }

    public CalAddResponse createCal(CalAddRequest calAddRequest) {
        //TODO
        return null;
    }

    public void updateCal(CalUpdateRequest calUpdateRequest) {
        //TODO
    }

    public void deleteCal(CalDeleteRequest calDeleteRequest) {
        //TODO
    }
}
