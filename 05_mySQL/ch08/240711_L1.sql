-- 2page
-- tabledb 데이터 베이스 생성 (이미 존재한다면 삭제)
DROP DATABASE IF EXISTS tabledb;
CREATE DATABASE tabledb;

-- usertbl 테이블 생성
USE tabledb;
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    addr CHAR(2) NOT NULL,
    mobile1 CHAR(3),
    mobile2 CHAR(8),
    height SMALLINT,
    mDate DATE
);



-- 3page
-- buytbl 테이블 생성
USE tabledb;
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl(
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
	userid CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL,
    groupName CHAR(4),
    price INT NOT NULL,
    amount SMALLINT NOT NULL,
    FOREIGN KEY(userid) REFERENCES usertbl(userID)
);



-- 4page
-- 회원테이블에 데이터 추가 (userID, name, birthyear, addr, mobile1, mobile2, height, mDate 순)
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
select * from usertbl;

-- 구매테이블에 데이터 추가 (순서: userid, prodName, groupName, price, amount)
-- 에러 발생 시 원인 설명





