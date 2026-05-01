package com.team404.visualwith.service;

import com.team404.visualwith.dto.calendar.*;
import com.team404.visualwith.repository.CalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalService {
    private final CalRepository calRepository;

    public CalService(CalRepository calRepository) {
        this.calRepository = calRepository;
    }

    public List<CalGetResponse> getCal(String teamId) {
        //TODO
        return null;
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
