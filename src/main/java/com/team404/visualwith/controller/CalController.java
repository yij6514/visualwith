package com.team404.visualwith.controller;

import com.team404.visualwith.dto.calendar.CalAddRequest;
import com.team404.visualwith.dto.calendar.CalDeleteRequest;
import com.team404.visualwith.dto.calendar.CalGetResponse;
import com.team404.visualwith.dto.calendar.CalUpdateRequest;
import com.team404.visualwith.service.CalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cal")
public class CalController {
    private final CalService calService;

    public CalController(CalService calService) {
        this.calService = calService;
    }

    @GetMapping("/{teamId}")
    public List<CalGetResponse> getCalList(@PathVariable String teamId) {
        return calService.getCal(teamId);
    }

    @PostMapping
    public ResponseEntity<?> postCal(@RequestBody CalAddRequest calAddRequest) {
        return ResponseEntity.ok(calService.createCal(calAddRequest));
    }

    @PutMapping
    public ResponseEntity<?> updateCal(@RequestBody CalUpdateRequest calUpdateRequest) {
        try{
            calService.updateCal(calUpdateRequest);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message",e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCal(@RequestBody CalDeleteRequest calDeleteRequest) {
        try {
            calService.deleteCal(calDeleteRequest);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message",e.getMessage()));
        }
        return ResponseEntity.noContent().build();
    }
}
