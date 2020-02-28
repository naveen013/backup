drop table owner;
create table owner(
userid varchar2(20) not null,
username varchar2(40)primary key,
password varchar2(20) not null,
mobile varchar2(15) unique,
email varchar2(40)not null,
gender varchar2(10) not null,
address varchar2(30) not null,
img_name varchar2(20) not null,
photo blob not null
);


desc owner;
select *from owner;
commit;
drop table house;
create table house(
name varchar2(40) primary key,
location varchar2(30) not null,
category varchar2(40) not null,
bedroom number(10) not null,
email varchar2(40) unique,
mobile number(15) unique,
img_name varchar2(30) not null,
photo blob not null);

desc house;
select *from house;
commit;

drop table customer;
create table customer(
username varchar2(20)primary key,
password varchar2(20) not null,
email varchar2(30) unique,
mobile number(17) unique,
gender varchar2(30) not null,
address varchar2(50),
img_name varchar2(30) not null,
photo blob);
desc customer;

select * from customer;
commit;

create table forgot123(
username varchar2(40),
address varchar2(50),
email varchar2(30)  primary key,
password varchar2(20) not null
);
desc forgot123;

drop table client;
create table client(
ID number(20)primary key,
NAME varchar2(30) not null,
LOGIN_ID varchar2(30) not null,
LOGIN_PASSWORD varchar2(12) not null,
ROLE varchar2(20)
);

desc client;
insert into client(ID,NAME,LOGIN_ID,LOGIN_PASSWORD,ROLE)values(101,'naveen','nit','123','ADMIN');
select * from client;
commit;