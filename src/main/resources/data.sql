use jwt;

insert into member(id, nickname, password,profile_img,status_message) values (1,"hello","qw12",false,"hh");
# insert into member_roles(member_member_id, roles) values ('member_A', 'USER');


insert into post_likes(member_id,post_id)values (1,1);
insert into follow(follower_Id,following_Id) values (1,1);

