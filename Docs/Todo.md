# 할 일 목록 API

## 1. 할 일 목록 조회
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

---

## 2. 할 일 생성
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

---

## 3. 할 일 내용 수정
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

---

## 4. 할 일 완료여부수정
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

---

## 5. 할일목록 삭제
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
