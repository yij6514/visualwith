### 초대 백엔드 로직

// 추가해야됨
팀 엔티티
초대상태 invitation state
pending accepted

// 완성
팀마다 초대 url 있음
팀 처음 초대할때 팀 url이 없으면 url 생성 메소드 호출
있으면 teamurl get 이후 유효기간 검사후 지났으면 다시 생성
이후 teamid/invitaionurl 형식으로 반환

ㄴ> 만들어야 할 메소드 2개 url 생성 메소드 반환 메소드 (teamservice)
controller-> teamservice.geturl -> 없으면 -> teamservice.geturl에서 createurl 호출 -> url 반환
-> 있으면 유효성 검사 -> 지났음녀 createurl 호출 -> url 반환
-> 안지났으면 url 반환

// 만들어야함
초대수락(url)을 누르면 백엔드 호출 (post)
여기서 userteam의 invitation state 를 accept로 바꿈
controller -> teamservice.invitationAccept -> teamuser 생성 (userteamid(userid, teamid)생성 후 userteamid(id, role, accepted)) -> 데이터베이스 저장
받아야할 정보 teamid, invitationcode, 로그인정보로 userid

ㄴ> 고민중인 이유 invitationcode만 받고 이걸로 데이터베이스에서 team 정보 찾을까? 없으면 유효하지 않은 초대로 구분. 이상태일경우 받아야할 데이터는 invitationcode와 userid만 받으면 됨 teamid는 데이터베이스에서 getbyinvitationcode로 찾아서 사용(invitationcode가 겹칠 위험이 있나? 사실 그런 경우가 없게 만들긴했음 근데 한팀이 예전에 만든 코드로 접속했는데 지금 팀의 url이 바뀌고 다른 팀에서 이 코드로 생성 되면 팀이 잘못된 곳으로 갈 수 있음 아 이경우를 위해서 teamid도 정보를 받는게 나을듯 teamid로 팀 찾고 여기의 invitationcode가 같은지 확인하는게 나을듯)
ㄴ> 결론 teamid도 정보를 받아야 된다

// 수정해야됨
초대 요청(지정초대) 메소드 변경 (post)
이 메소드에서는 userteam 생성 후 state를 pending으로 생성
controller -> teamservice.addmember(teamid, adminid, requestdto) -> userteam 생성 pending으로 생성 -> 데이터베이스 저장
dto addteammemberrequest    (userid)

// 만들어야함
초대 수락(지정초대)를 누르면 백엔드 호출 (put)
여기서 userteam생성 이대 inviation state는 accepted로 생성
controller -> teamservice.invitationurlaccept(teamid, userid) -> userteam 호출 -> state accepted로 변경 -> 데이터베이스 저장





### develop 브랜치에서 할것

usercontroller 팀리스트 호출 메소드 필요
/{userid}
해당 유저가 속해 있는 팀리스트를 반환
userteamservice에서 userid로 userteam의 데이터베이스 호출 팀리스트를 teamname, teamid로 호출