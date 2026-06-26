insert into users (id, user_id, email, password, name)
values(100000, 'testuser', 'test@test.com', '$2a$10$jqL34UVrbkn3SsQc1hyVUeuEVvuaPDbD1vlbGjhZKGX/x8aqXvEwG', '인준');

insert into users (id, user_id, email, password, name)
values(100001, 'amu', 'amu@test.com', '$2a$10$/g.qVAm3kOJDNXfPV1azbOtPivVfAQaj4/ah0NVe96EeKjjciiWQC', '아무');

insert into teams (id, team_name, creator_id)
values('testteam', '테스트팀', 'testuser');

insert into teams (id, team_name, creator_id)
values('amuteam1', '아무팀', 'amu');

insert into user_teams (user_id, team_id, role, status)
values('testuser', 'testteam', 'ADMIN', 'ACCEPTED');

insert into user_teams (user_id, team_id, role, status)
values('amu', 'testteam', 'MEMBER', 'ACCEPTED');

insert into user_teams (user_id, team_id, role, status)
values('amu', 'amuteam1', 'ADMIN', 'ACCEPTED');

insert into todos (id, creator_id, team_id, title, content, completed, created_date, created_time)
values(9999, 'testuser', 'testteam', 'testtitle', 'test content', false, '26-06-19', '00:19');

insert into todos (id, creator_id, team_id, title, content, completed, created_date, created_time)
values(9998, 'testuser', 'testteam', 'testtitle2', 'slay the spire', false, '26-06-15', '08:19');

insert into todos (id, creator_id, team_id, title, content, completed, created_date, created_time)
values(9997, 'amu', 'amuteam1', 'testtitle3', '캡스톤 기말고사', false, '26-06-15', '08:19');

insert into todos (id, creator_id, team_id, title, content, completed, created_date, created_time)
values(9996, 'amu', 'amuteam1', 'testtitle4', '자바 기말고사', false, '26-06-13', '09:49');

insert into calendar (id, title, content, created_date, created_time, whole_day, team_id, user_id)
values (9999, 'test Title', '프로젝트 발표', '26-06-18', '12:00', false, 'amuteam1', 'amu');

insert into calendar (id, title, content, created_date, created_time, whole_day, team_id, user_id)
values (9998, 'test Title1', '자바 프로젝트', '26-06-16', '12:00', false, 'amuteam1', 'amu');

insert into calendar (id, title, content, created_date, created_time, whole_day, team_id, user_id)
values (9997, 'test Title2', '논문 발표', '26-06-17', '12:00', false, 'testteam', 'amu');

insert into calendar (id, title, content, created_date, created_time, whole_day, team_id, user_id)
values (9996, 'test Title3', '휴일', '26-06-10', '12:00', true, 'testteam', 'testuser');

insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99991, 'amuteam1', 'testuser', 'test chatting', '26-06-19', '00:01');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99992, 'amuteam1', 'testuser', '뭐함', '26-06-19', '00:02');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99993, 'amuteam1', 'amu', '집임', '26-06-19', '00:02');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99994, 'amuteam1', 'amu', '과제 했음?', '26-06-19', '00:03');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99995, 'amuteam1', 'testuser', 'ㄴㄴ', '26-06-19', '00:05');

insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99996, 'testteam', 'testuser', '혼잣말', '26-06-15', '00:01');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99997, 'testteam', 'testuser', '혼잣말1', '26-06-15', '00:05');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99998, 'testteam', 'testuser', '같이 할 사람', '26-06-15', '00:10');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(99999, 'testteam', 'testuser', '일 없는 사람', '26-06-15', '08:01');
insert into chat_message (id, room_id, sender, message, received_date, received_time)
values(100000, 'testteam', 'testuser', '중괄호', '26-06-15', '09:23');