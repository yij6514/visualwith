# 채팅 API

## 1. WebSocket 접속

- **URL**: `ws://localhost:8080/ws`
- **Description**: 웹소켓 서버 접속

---

## 2. 채팅방 구독 (Subscribe)

- **URL**: `/sub/chatroom/{teamId}`
- **COMMAND**: SUBSCRIBE
- **Description**: 팀 ID 로 채팅 연결, 이후 메세지 수신 <- 메시지 수신을 위해 꼭 필요

#### Body (JSON) 수신
````json
{
  "roomId" : String, // 팀 Id
  "sender" : String, // 보낸 사람
  "message" : String,
  "receivedDate" : LocalDate, // 서버기준 수신 시간
  "receivedTime" : LocalTime
}
````

---

## 3. 메시지 송신

- **URL**: `/pub/message/{teamId}`
- **COMMAND**: PUBLISH(stomp.js), SEND
- **Description**: 팀 채팅 송신

#### Body (JSON) 송신
````json
{
  "id" : String, // teamId
  "name" : String, // 보낸 사람
  "message" : String // 메시지 내용
}
````

---

## 4. 채팅 조회
#### !!! HTTP 프로토콜 사용 주의
- **URL**: `/chat/{teamId}`
- **Method**: `GET`
- **Description**: 이전 채팅을 불러옵니다. 일단 제한은 없습니다

#### Response
```json
{
  "roomId" : String, // 팀 Id
  "sender" : String, // 보낸 사람
  "message" : String,
  "receivedDate" : LocalDate, // 서버기준 수신 시간
  "receivedTime" : LocalTime
}
```