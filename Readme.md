# API 문서

본 문서는 사용자 인증 및 팀 관리 기능을 제공하는 REST API에 대한 설명이다.

---

## 1. 회원가입

### 1-1. 회원가입 요청

- **URL**: `/api/register`
- **Method**: `POST`

#### Request Body (JSON)
```json
{
  "userId": "string",
  "password": "string",
  "email": "string",
  "name": "string"
}
```

#### Response (200 OK)
```json
{
  "id": 1,
  "userId": "string",
  "email": "string",
  "name": "string"
}
```

#### Error Response
- `400 Bad Request` : 요청 값이 올바르지 않은 경우
- `409 Conflict` : 이미 존재하는 사용자 ID

---

### 1-2. 아이디 중복 확인

- **URL**: `/api/checkid`
- **Method**: `GET`

#### Request Body (JSON)
```json
{
  "userId": "string"
}
```

- 아이디가 없을 경우
#### Response (200 OK)
```json
{
  "available": true
}
```

- 아이디가 있을 경우
```json
{
  "available": false
}
```

---

## 2. 로그인


- **URL**: `/api/login`
- **Method**: `POST`

#### Request Body (JSON)
```json
{
  "userId": "string",
  "password": "string"
}
```

#### Response (200 OK)
```json
{
  "userId": "string",
  "userName": "string",
  "userEmail": "string",
  "token": "jwt-token",
  "message": "ok"
}
```

#### Error Response
- `401 Unauthorized` : 아이디 또는 비밀번호 불일치

---

## 3. Get Me API

**URL**: `/api/users/me`
- **Method**: `GET`

#### Response (200 OK)
```json
{
  "userId": "string",
  "name": "String",
  "email": "string"
}
```

#### Error Response
- `400 Bad Request` : 대상 사용자가 없습니다
- JWT 토큰이 인증이 다되었을 경우도 error response

---
## A. 팀 API

#### [- 팀 API 문서](Docs/Team.md)

---
## B. 할 일 목록

#### [- 할 일 목록 API 문서](Docs/Todo.md)

---
## C. 일정관리

#### [- 일정관리 API 문서](Docs/Calendar.md)

---

## D. 채팅

#### [- 채팅 API 문서](Docs/Chat.md)

---
## 공통 사항

- 응답 데이터 형식은 `application/json`이다.