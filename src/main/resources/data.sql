use jwt;

insert into member(member_id, nickname, password, is_letter_write, status_message) values ('member_B','helloee','1234', true,'굳!!');
insert into member_roles(member_id, roles) values (1, 'USER');

-- -- follow 임시 저장
-- insert into follow(follower_Id,following_Id) values (1,2);
-- insert into follow(follower_Id,following_Id) values (2,1);


-- Post 임시 저장
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'jpa 너무 빡친다~','너무 어려워도 악으로 깡으로 버티세요! 그럼 언젠가는 빛을 볼거예요!!','2020-09-02',false,1);

-- 편지
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'1월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-02-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'2월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-03-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'3월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-04-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'4월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-05-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'5월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-06-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'6월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-07-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'7월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-08-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'8월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-09-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'9월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-10-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'10월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-11-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'11월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2023-12-01',true,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'12월 스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', '2024-01-01',true,1);

insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'jpa 너무 빡친다~','너무 어려워도 악으로 깡으로 버티세요! 그럼 언젠가는 빛을 볼거예요!!','2020-09-02',false,1);
insert into post(create_date, last_modified_date,title, content,date, letter,member_id)
values (CURRENT_DATE, CURRENT_DATE,'jpa 너무 빡친다~','너무 어려워도 악으로 깡으로 버티세요! 그럼 언젠가는 빛을 볼거예요!!','2020-09-02',false,1);

-- 즐겨찾기 임시 저장

insert into post_like(post_id,member_id)
values (1,1);
insert into post_like(post_id,member_id)
values (14,1);

-- Hashtag 임시 저장

insert into hashtag(tag)
values ('SpringBoot');

insert into hashtag(tag)
values ('JPA');

-- Post_Hashtag 임시 저장

insert into post_hashtag(post_id,hashtag_id)
values (1,1);

insert into post_hashtag(post_id,hashtag_id)
values (1,2);

