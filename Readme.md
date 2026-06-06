# API 문서 (초안)

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
  "username": "string",
  "token": "jwt-token",
  "message": "login success"
}
```

#### Error Response
- `401 Unauthorized` : 아이디 또는 비밀번호 불일치

---
## 3. 팀 API

#### [- 팀 API 문서](Docs/Team.md)

---
## 4. 할 일 목록

#### [- 할 일 목록 API 문서](Docs/Todo.md)

---
## 5. 일정관리

#### [- 일정관리 API 문서](Docs/Calendar.md)

---
## 공통 사항

- 응답 데이터 형식은 `application/json`이다.