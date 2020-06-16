#### Jsp 버전1~버전3

```sql
## 오라클 12C 사용자 생성
alter session set "_ORACLE_SCRIPT"=true;  
CREATE USER base IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO base;

GRANT CREATE TABLESPACE TO base;
GRANT CREATE TABLE TO base;
GRANT CREATE SEQUENCE TO base;
alter user base default tablespace users quota unlimited on users;
GRANT RESOURCE, CONNECT TO base;

-- ver1 ~ 2
CREATE TABLE product(
    id number primary key,
    name varchar2(100) not null,
    type varchar2(20) not null,
    price number not null,
    count number not null
);

CREATE SEQUENCE product_SEQ
START WITH 1 
INCREMENT BY 1;

INSERT INTO product(id, name, type, price, count)
VALUES(product_SEQ.NEXTVAL,'바나나','과일',1000,200);

INSERT INTO product(id, name, type, price, count)
VALUES(product_SEQ.NEXTVAL,'딸기','과일',2000,10);

INSERT INTO product(id, name, type, price, count)
VALUES(product_SEQ.NEXTVAL,'연필','문구',500,2000);
```

```
-- ver3
CREATE TABLE team(
    id number primary key,
    name varchar2(100) not null
);

CREATE TABLE player(
    id number primary key,
    teamId number,
    name varchar2(100) not null,
    position varchar2(100) not null,
    foreign key (teamId) references team (id) on delete cascade
);

CREATE SEQUENCE team_SEQ
START WITH 1 
INCREMENT BY 1;

CREATE SEQUENCE player_SEQ
START WITH 1 
INCREMENT BY 1;

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'두산');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'키움');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'SK');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'LG');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'NC');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'KT');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'KIA');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'삼성');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'한화');

INSERT INTO team(id, name)
VALUES(team_SEQ.NEXTVAL,'롯데');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,70,'이동욱','감독');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,27,'이호준','코치');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,00,'임형원','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,12,'라이트','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,30,'박진우','투수');

---------------------------

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,38,'임정호','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,40,'루친스키','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,45,'임창민','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,25,'양의지','포수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,2,'박민우','내야수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,23,'알테어','외야수');

-------------------------------

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,75,'류중일','감독');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,6,'유지현','코치');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,1,'임찬규','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,4,'이성우','포수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,5,'김용의','내야수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,5,22,'김현수','외야수');

-------------------------------
INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,1,88,'김태형','감독');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,1,70,'김원형','코치');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,1,1,'함덕주','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,1,10,'박세혁','포수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,1,6,'서예일','내야수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,1,15,'국해성','외야수');

-------------------------------
INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,2,83,'김태형','감독');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,2,71,'김원형','코치');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,2,1,'함덕주','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,2,10,'박세혁','포수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,2,6,'서예일','내야수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,2,15,'국해성','외야수');


-------------------------------
INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,3,83,'김태형','감독');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,3,71,'김원형','코치');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,3,1,'함덕주','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,3,10,'박세혁','포수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,3,6,'서예일','내야수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,3,15,'국해성','외야수');

-------------------------------
INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,10,83,'김태형','감독');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,10,71,'김원형','코치');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,10,1,'함덕주','투수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,10,10,'박세혁','포수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,10,6,'서예일','내야수');

INSERT INTO player(id, teamId, uniformNumber, name, position)
VALUES(player_SEQ.NEXTVAL,10,15,'국해성','외야수');
```