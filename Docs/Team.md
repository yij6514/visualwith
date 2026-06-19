# 팀 API

## 1. 팀 생성

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

## 2. 팀 삭제

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

## 3. 팀 초대

### 3.1 회원 검색

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

### 3.2 팀 초대 요청

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
### 3.3 팀 초대 수락

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
### 3.4 팀 초대 URL

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
### 3.5 팀 초대 수락 (URL)

- **URL**: `/api/teams/invitation/{teamId}/{invitationCode}`
- **Method**: `POST`
- **Description**: 팀의 초대를 수락합니다. (URL버전)

#### Path Variable
| 이름             | 타입     | 설명     |
|----------------|--------|--------|
| teamId         | String | 팀 ID   |
| invitationCode | String | 팀 초대 url |

#### Request Body (JSON)
```json
{
  "userId": "string" // 초대할 사용자의 id
}
```

#### Response (200 OK)
```json
{
  "message" : "팀 멤버로 추가되었습니다."
}
```
#### Error Response
- `400 BAD_REQUEST : 팀이 없거나 대상 사용자가 없을 경우

---
### 3.6 팀원 조회

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
  "invitationStatus" : "invitationStatus", // PENDING, ACCEPTED
  "userName": "string",
  "userEmail": "string"
}
```

---

### 3.7 팀 조회

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
