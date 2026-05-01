package com.team404.visualwith.controller;

import com.team404.visualwith.dto.calendar.CalAddRequest;
import com.team404.visualwith.dto.calendar.CalDeleteRequest;
import com.team404.visualwith.dto.calendar.CalGetResponse;
import com.team404.visualwith.dto.calendar.CalUpdateRequest;
import com.team404.visualwith.service.CalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cal")
public class CalController {
    private final CalService calService;

    public CalController(CalService calService) {
        this.calService = calService;
    }

    @GetMapping("/{teamId}")
    public List<CalGetResponse> getCalList(@PathVariable String teamId) {
        //TODO
        return null;
    }

    @PostMapping
    public ResponseEntity<?> postCal(@RequestBody CalAddRequest calAddRequest) {
        //TODO
        return null;
    }

    @PutMapping
    public ResponseEntity<?> updateCal(@RequestBody CalUpdateRequest calUpdateRequest) {
        //TODO
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCal(@RequestBody CalDeleteRequest calDeleteRequest) {
        //TODO
        return null;
    }
}
