package com.team404.visualwith.controller;

import com.team404.visualwith.dto.calendar.CalAddRequest;
import com.team404.visualwith.dto.calendar.CalDeleteRequest;
import com.team404.visualwith.dto.calendar.CalGetResponse;
import com.team404.visualwith.dto.calendar.CalUpdateRequest;
import com.team404.visualwith.service.CalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<?> getCalList(@PathVariable String teamId, Authentication auth) {
        if(auth == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 토큰이 만료되었습니다"));
        }

        return ResponseEntity.ok(calService.getCal(teamId));
    }

    @PostMapping
    public ResponseEntity<?> postCal(@RequestBody CalAddRequest calAddRequest, Authentication auth) {
        if(auth == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 토큰이 만료되었습니다"));
        }

        return ResponseEntity.ok(calService.createCal(calAddRequest, auth.getName()));
    }

    @PutMapping
    public ResponseEntity<?> updateCal(@RequestBody CalUpdateRequest calUpdateRequest, Authentication auth) {
        if(auth == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 토큰이 만료되었습니다"));
        }

        try{
            calService.updateCal(calUpdateRequest, auth.getName());
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message",e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCal(@RequestBody CalDeleteRequest calDeleteRequest, Authentication auth) {
        if(auth == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 토큰이 만료되었습니다"));
        }

        try {
            calService.deleteCal(calDeleteRequest, auth.getName());
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message",e.getMessage()));
        }
        return ResponseEntity.noContent().build();
    }
}
