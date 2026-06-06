# 일정 API

---

## 1. 일정 조회
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

---

## 2. 일정 생성
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

---

## 3. 일정 내용수정
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

---

## 4. 일정 삭제
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
