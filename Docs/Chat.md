# 채팅 API

## 1. WebSocket 접속

- **URL**: `ws://localhost:8080/ws`
- **Description**: 웹소켓 서버 접속

---

## 2. 채팅방 구독 (Subscribe)

- **URL**: `/sub/chatroom/{teamId}`
- **COMMAND**: SUBSCRIBE
- **Description**: 팀 ID 로 채팅 연결, 이후 메세지 수신 <- 메시지 수신을 위해 꼭 필요

---

## 3. 메시지 송신

- **URL**: `/pub/message/{teamId}`
- **COMMAND**: SEND
- **Description**: 팀 ID 로 채팅 연결, 이후 메세지 수신 <- 메시지 수신을 위해 꼭 필요
