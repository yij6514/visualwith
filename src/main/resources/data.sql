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