# API 문서 (초안)

본 문서는 사용자 인증 및 팀 관리 기능을 제공하는 REST API에 대한 설명이다.

---

## 1. 회원가입

<details>

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

</details>

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

## 3. 팀 생성

- **URL**: `/api/createteam`
- **Method**: `POST`
- **Description**: 새로운 팀을 생성한다.

#### Request Body (JSON)
```json
{
  "teamName": "string"
}
```

#### Response (200 OK)
```json
{
  "id": "string",
  "teamName": "string",
  "creatorId": "string"
}
```

---

## 4. 팀 삭제

- **URL**: `/api/teams/{teamId}`
- **Method**: `DELETE`
- **Description**: 특정 팀을 삭제한다.

#### Request Headers
| 이름        | 타입     | 설명          |
| --------- | ------ | ----------- |
| X-USER-ID | String | 요청한 사용자의 ID |

#### Path Variable
| 이름     | 타입   | 설명       |
| ------ | ---- | -------- |
| teamId | Long | 삭제할 팀 ID |

#### Response (200 OK)
```json
{
  "message": "팀 삭제 완료"
}
```

#### Error Response
- `403 Forbidden` : 요청자의 역할이 팀 관리자가 아님
- `404 Not Found` : 팀이 존재하지 않음

---

## 5. 팀 초대

### 5-1. 회원 검색

- **URL**: `/api/users/{userId}`
- **Method**: `GET`
- **Description**: 초대할 사용자를 검색한다.

#### Path Variable
| 이름 | 타입 | 설명 |
|----|----|----|
| userId | String | 검색할 사용자 ID |

#### Response (200 OK)
```json
{
  "userId": "string",
  "name": "string",
  "email": "string"
}
```

#### Error Response
- `404 Not Found` : 사용자를 찾을 수 없음

---

### 5-2. 팀 초대 요청

- **URL**: `/api/teams/invitation/{teamId}`
- **Method**: `POST`
- **Description**: 특정 팀에 사용자를 초대한다.

#### Request Headers
| 이름        | 타입     | 설명          |
| --------- | ------ | ----------- |
| X-USER-ID | String | 요청한 사용자의 ID |
#### Path Variable
| 이름 | 타입 | 설명 |
|----|----|----|
| teamId | Long | 팀 ID |

#### Request Body (JSON)
```json
{
  "userId": "string"
}
```

#### Response (200 OK)
```json
{
  "invitationId": 10,
  "teamId": 1,
  "userId": "string",
  "status": "PENDING"
}
```


#### Error Response
- `403 Forbidden : 요청자의 정보가 올바르지 않거나 요청자가 관리자나 서브관리자가 아님
- `404 Not Found` : 팀 또는 초대될 사용자 없음

---

## 공통 사항

- 응답 데이터 형식은 `application/json`이다.

