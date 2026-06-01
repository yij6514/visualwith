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
| 이름 | 타입     | 설명 |
|----|--------|----|
| teamId | String | 팀 ID |

#### Request Body (JSON)
```json
{
  "userId": "string" // 초대할 사용자의 id
}
```

#### Response (200 OK)
```json
{
  "invitationId": 10,
  "teamId": "string",
  "userId": "string",
  "status": "PENDING"
}
```


#### Error Response
- `403 Forbidden : 요청자의 정보가 올바르지 않거나 요청자가 관리자나 서브관리자가 아님
- `404 Not Found` : 팀 또는 초대될 사용자 없음

---
### 5-3 팀 초대 수락

- **URL**: `/api/teams/invitation/{teamId}/{userId}`
- **Method**: `PUT`
- **Description**: 초대된 사용자가 초대를 수락한다.

#### Path Variable
| 이름     | 타입     | 설명     |
|--------|--------|--------|
| teamId | String | 팀 ID   |
| userId | String | 사용자 ID |

#### Response (200 OK)
```json
{
  "message" : "팀 멤버가 수락하였습니다."
}
```
#### Error Response
- `400 Bad_Request : 팀이 없거나 대상 사용자가 없거나 팀에 초대되지 않았을 경우

---
### 5-4 팀 초대 URL

- **URL**: `/api/teams/invitation/{teamId}/geturl`
- **Method**: `GET`
- **Description**: 팀의 초대 url을 호출합니다.

#### Path Variable
| 이름     | 타입     | 설명     |
|--------|--------|--------|
| teamId | String | 팀 ID   |

#### Response (200 OK)
```json
{
  "url" : "{teamId}/{teamurl}"
}
```
#### Error Response
- `404 NOT_FOUND : 팀이 없을 경우

---
### 5-5 팀 초대 수락 (URL)

- **URL**: `/api/teams/invitation/{teamId}/{invitationCode}`
- **Method**: `POST`
- **Description**: 팀의 초대를 수락합니다. (URL버전)

#### Path Variable
| 이름             | 타입     | 설명     |
|----------------|--------|--------|
| teamId         | String | 팀 ID   |
| invitationCode | String | 팀 초대 url |

#### Response (200 OK)
```json
{
  "message" : "팀 멤버로 추가되었습니다."
}
```
#### Error Response
- `400 BAD_REQUEST : 팀이 없거나 대상 사용자가 없을 경우

---
### 5-6 팀원 조회

- **URL**: `/api/{teamId}/memberlist`
- **Method**: `GET`
- **Description**: 팀의 팀원을 호출합니다.

#### Path Variable
| 이름             | 타입     | 설명     |
|----------------|--------|--------|
| teamId         | String | 팀 ID   |

#### Response (200 OK)
```json
{
  "userId" : "string",
  "teamId" : "string",
  "userTeamRole" : "userTeamRole", // ADMIN, SUB_ADMIN, MEMBER
  "invitationStatus" : "invitationStatus" // PENDING, ACCEPTED
}
```

---

### 5-7 팀 조회

- **URL**: `/api/users/{userId}/teamList`
- **Method**: `GET`
- **Description**: 사용자가 속해 있는 팀을 호출합니다.

#### Path Variable
| 이름  | 타입     | 설명     |
|-----|--------|--------|
| userId | String | 사용자 ID |

#### Response (200 OK)
```json
{
  "userId" : "string",
  "teamId" : "string",
  "userTeamRole" : "userTeamRole" // ADMIN, SUB_ADMIN, MEMBER
}
```

---

## 6. 할일목록

### 6.1 할일목록 조회
- **URL**: `/api/todo/{teamId}`
- **Method**: `GET`
- **Description**: 팀의 할일목록 리스트를 반환한다.

#### Response (200 OK)
```json
{
  "id": "Long",
  "userId": "string", //생성한 사람 ID
  "title": "string",
  "content": "string",
  "completed": "Boolean"
}
```

### 6.2 할일목록 생성
- **URL**: `/api/todo`
- **Method**: `POST`
- **Description**: 할일 목록을 생성합니다.

#### Request Body (JSON)
```json
{
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string",
  "title": "string",
  "content": "string",
  "createdDate": "string",
  "createdTime": "string"
}
```

#### Response (200 OK)
```json
{
  "id": "Long"
}
```

### 6.3 할일목록 내용수정
- **URL**: `/api/todo/update`
- **Method**: `PUT`
- **Description**: 할일 목록의 내용을 수정합니다

#### Request Body (JSON)
```json
{
  "id" : "String",
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string", // 수정한 사람의 ID
  "userTeamRole": "userTeamRole", // ADMIN, SUB_ADMIN, MEMBER
  "title": "string",
  "content": "string"
}
```

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `400 Bad Request` : 권한이 없거나 생성한 사람이 아닐 경우,   
혹은 할일 목록이 없을 경우

### 6.4 할일목록 완료여부수정
- **URL**: `/api/todo/complete`
- **Method**: `PUT`
- **Description**: 할일 목록의 완료 여부를 수정한다.

#### Request Body (JSON)
```json
{
  "id" : "String",
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string", // 수정한 사람의 ID
  "userTeamRole": "userTeamRole", // ADMIN, SUB_ADMIN, MEMBER
  "complete": "Boolean",
  "completeDate": "string",
  "completeTime": "string"
}
```

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `400 Bad Request` : 권한이 없거나 생성한 사람이 아닐 경우,   
  혹은 할일 목록이 없을 경우

### 6.5 할일목록 삭제
- **URL**: `/api/todo/delete`
- **Method**: `DELETE`
- **Description**: 할일목록을 삭제한다.

#### Request Body (JSON)
```json
{
  "id" : "String",
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string", // 삭제한 사람의 ID
  "userTeamRole": "userTeamRole" // ADMIN, SUB_ADMIN, MEMBER
}
```

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `400 Bad Request` : 권한이 없거나 생성한 사람이 아닐 경우,   
  혹은 할일 목록이 없을 경우

---

## 7. 일정관리

### 7.1 일정 조회
- **URL**: `/api/cal/{teamId}`
- **Method**: `GET`
- **Description**: 팀의 일정 리스트를 반환한다.

#### Response (200 OK)
```json
{
  "id": "Long",
  "userId": "string", //생성한 사람 ID
  "title": "string",
  "content": "string",
  "startDate": "string",
  "startTime": "string",
  "completeDate": "String",
  "completeTime": "string"
}
```

### 7.2 일정 생성
- **URL**: `/api/cal`
- **Method**: `POST`
- **Description**: 일정을 생성합니다.

#### Request Body (JSON)
```json
{
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string",
  "title": "string",
  "content": "string",
  "startDate": "string",
  "startTime": "string",
  "completeDate": "String",
  "completeTime": "string",
  "wholeDay": "Boolean", // 일정이 특정시간대가 아닌 하루 종일 일때
  "createdDate": "string",
  "createdTime": "string"
}
```

#### Response (200 OK)
```json
{
  "id": "Long"
}
```

### 7.3 일정 내용수정
- **URL**: `/api/cal`
- **Method**: `PUT`
- **Description**: 일정의 내용을 수정합니다

#### Request Body (JSON)
```json
{
  "id" : "String",
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string", // 수정한 사람의 ID
  "userTeamRole": "userTeamRole", // ADMIN, SUB_ADMIN, MEMBER
  "title": "string",
  "content": "string",
  "startDate": "string",
  "startTime": "string",
  "completeDate": "String",
  "completeTime": "string",
  "wholeDay": "Boolean", // 일정이 특정시간대가 아닌 하루 종일 일때
}
```

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `400 Bad Request` : 권한이 없거나 생성한 사람이 아닐 경우,   
혹은 해당 일정이 없을 경우

### 7.4 일정 삭제
- **URL**: `/api/cal`
- **Method**: `DELETE`
- **Description**: 일정을 삭제한다.

#### Request Body (JSON)
```json
{
  "id" : "String",
  "teamId": "string", // 팀이름이 아니고 팀ID
  "userId": "string", // 삭제한 사람의 ID
  "userTeamRole": "userTeamRole" // ADMIN, SUB_ADMIN, MEMBER
}
```

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `400 Bad Request` : 권한이 없거나 생성한 사람이 아닐 경우,   
  혹은 해당 일정이 없을 경우

---
## 공통 사항

- 응답 데이터 형식은 `application/json`이다.