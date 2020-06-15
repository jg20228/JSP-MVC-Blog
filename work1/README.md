#### Jsp 버전1~버전3

'''sql
## 오라클 12C 사용자 생성
alter session set "_ORACLE_SCRIPT"=true;  
CREATE USER base IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO base;

GRANT CREATE TABLESPACE TO base;
GRANT CREATE TABLE TO base;
GRANT CREATE SEQUENCE TO base;
alter user base default tablespace users quota unlimited on users;
GRANT RESOURCE, CONNECT TO base;

-- 시퀀스
CREATE SEQUENCE product_SEQ
START WITH 1 
INCREMENT BY 1;

INSERT INTO product(id, name, type, price, count)
VALUES(product_SEQ.NEXTVAL,'바나나','과일',1000,200);

INSERT INTO product(id, name, type, price, count)
VALUES(product_SEQ.NEXTVAL,'딸기','과일',2000,10);

INSERT INTO product(id, name, type, price, count)
VALUES(product_SEQ.NEXTVAL,'연필','문구',500,2000);
'''