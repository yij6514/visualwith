package com.team404.visualwith.controller;

import com.team404.visualwith.dto.chat.ChatReceived;
import com.team404.visualwith.dto.chat.ChatResponse;
import com.team404.visualwith.entity.ChatMessage;
import com.team404.visualwith.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations template;
    private final ChatService chatService;

    // 채팅 리스트 반환
    @GetMapping("/chat/{id}")
    public ResponseEntity<?> getChatMessages(@PathVariable String id){
        //임시로 리스트 형식으로 구현, 실제론 DB 접근 필요
        List<ChatResponse> list = chatService.chatLoad(id);
        return ResponseEntity.ok().body(list);
    }

    //메시지 송신 및 수신, /pub가 생략된 모습. 클라이언트 단에선 /pub/message로 요청
    @MessageMapping("/message/{teamId}")
    public ResponseEntity<Void> receiveMessage(@RequestBody ChatReceived chat, @DestinationVariable String teamId) {
        chatService.chatSave(chat);

        // 메시지를 해당 채팅방 구독자들에게 전송
        template.convertAndSend("/sub/chatroom/" + teamId, chat);
        return ResponseEntity.ok().build();
    }
}