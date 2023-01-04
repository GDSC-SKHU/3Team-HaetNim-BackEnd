use jwt;

insert into member(member_id, password) values ('member_A', '1234');
insert into member_roles(member_member_id, roles) values ('member_A', 'USER');


-- Post 임시 저장
insert into post(create_date, last_modified_date,title,content, disclosure, img)
values (CURRENT_DATE, CURRENT_DATE,'스프링 너무 어렵다~~','너무 어려워서 포기하고 싶은데 어떻하나요..?ㅠㅠㅠ', true, 'testImg');

insert into post(create_date, last_modified_date,title,content, disclosure)
values (CURRENT_DATE, CURRENT_DATE,'jpa 너무 빡친다~','너무 어려워도 악으로 깡으로 버티세요! 그럼 언젠가는 빛을 볼거예요!!', false);

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

insert into post_hashtag(post_id,hashtag_id)
values (2,1);
