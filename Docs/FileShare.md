# 파일공유 API

## 0. API 요약

| 번호 | 기능    | HTTP Method | URL | Body 형식 |
|----|----------|-------------|-----|---------|
| 1  | 파일 목록 조회 | GET         | `/api/share/list/{teamId}` | 없음 |
| 2  | 파일 업로드   | POST        | `/api/share/{teamId}` |  multipart/form-data |
| 3  | 파일 다운로드  | GET         | `/api/share/{fileId}` | 없음 |
| 4  | 파일 이름 변경 | PUT         | `/api/share/rename/{fileId}` | application/json |
| 5  | 파일 삭제 | DELETE     | `/api/share/delete/{fileId}` | 없음 |

---

## 1. 파일공유 목록 조회
- **URL**: `/api/share/list/{teamId}`
- **Method**: `GET`
- **Description**: 팀의 할일목록 리스트를 반환한다.

#### Path Variable
| 이름     | 타입   | 설명       |
| ------ | ---- |----------|
| teamId | Long | 조회할 팀 ID |

#### Response (200 OK)
```json
{
  "id": "Long",
  "fileName": "string", // 파일 이름
  "filePath": "string", // 파일 경로 (파일이름 없음)
  "fileType": "string", // 파일 형식
  "fileSize": "Long", // 파일 크기
  "senderId": "Boolean", // 파일 업로드한 사람 id
  "createdAt": "Boolean" // 파일 업로드한 시간
}
```

---

## 2. 파일 업로드
- **URL**: `/api/share/{teamId}`
- **Method**: `POST`
- **Body 형식**: `multipart/form-data`
- **Description**: 파일을 업로드 합니다.

#### Path Variable
| 이름     | 타입   | 설명        |
| ------ | ---- |-----------|
| teamId | Long | 업로드할 팀 ID |

#### Body 내용
| 이름   | 타입   | 설명       |
|------| ---- |----------|
| file | File | 업로드할 실제 파일 |

#### Response (200 OK)
```json
{
  "id": "Long"
}
```

---

## 3. 파일 다운로드
- **URL**: `/api/share/{fileId}`
- **Method**: `GET`
- **Description**: 파일을 다운로드 합니다

#### Path Variable
| 이름     | 타입   | 설명       |
|--------| ---- |----------|
| fileId | Long | 다운로드할 ID |

#### Response (200 OK)
- 파일 바이너리 데이터 반환
- Content-Type : application/octet-stream
- Content-Disposition : attachment, filename="파일명"

#### Error Response
- `404 NOT FOUND` : 해당 파일이 없는 경우

---

## 4. 파일 제목 수정
- **URL**: `/api/share/rename/{fileId}`
- **Method**: `POST`
- **Description**: 파일의 제목을 수정합니다

#### Path Variable
| 이름     | 타입   | 설명           |
|--------| ---- |--------------|
| fileId | Long | 제목을 바꿀 파일 ID |

#### Request Body (JSON)
```json
{
  "fileName" : string // 수정할 파일 제목
}
```

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `404 NOT FOUND` : 해당 파일이 없는 경우

---

## 5. 파일 삭제
- **URL**: `/api/share/delete/fileId`
- **Method**: `DELETE`
- **Description**: 파일을 삭제한다

#### Path Variable
| 이름     | 타입   | 설명        |
|--------| ---- |-----------|
| fileId | Long | 삭제할 파일 ID |

#### Response (200 OK)
```json
반환목록 없음
```

#### Error Response
- `404 Bad Request` : 해당 파일이 없습니다.

---
