#### Jsp 모델2 블로그 프로젝트

## 오라클 12C 사용자 생성

```sql
alter session set "_ORACLE_SCRIPT"=true;  
CREATE USER love IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO love;

GRANT CREATE TABLESPACE TO love;
GRANT CREATE TABLE TO love;
GRANT CREATE SEQUENCE TO love;
alter user love default tablespace users quota unlimited on users;
GRANT RESOURCE, CONNECT TO love;
```

## 시퀀스

```sql
CREATE SEQUENCE USER_seq
START WITH 1 
INCREMENT BY 1;

CREATE SEQUENCE BOARD_seq
START WITH 1 
INCREMENT BY 1;

CREATE SEQUENCE REPLY_seq
START WITH 1 
INCREMENT BY 1;
```

## 테이블 생성
```sql
CREATE TABLE users(
	id number primary key,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    email varchar2(100) not null,
    address varchar2(100) not null,
    userProfile varchar2(200),
    userRole varchar2(20),
    createDate timestamp
);

CREATE TABLE board(
	id number primary key,
    userId number,
    title varchar2(100) not null,
    content clob,
    readCount number default 0,
    createDate timestamp,
    foreign key (userId) references users (id)
);

CREATE TABLE reply(
	id number primary key,
    userId number,
    boardId number,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
);
```