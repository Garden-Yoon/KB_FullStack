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
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
-- usertbl의 userID에 'JYP'가 없으므로 외래키 참조 제약을 위반하여 에러가 발생한다
-- INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);



-- 5page
-- 기존 usertbl이 존재하는 경우 삭제하고
DROP TABLE IF EXISTS usertbl;
-- 기본키는 테이블 레벨에서 정의하고 제약조건명을 함께 지정한다
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthyear INT NOT NULL,
    CONSTRAINT PRIMARY KEY PK__userTBL_userID(userID)
);



-- 6page
-- 기존 prodTbl 존재 시 삭제하고 새로 만들기
DROP TABLE IF EXISTS prodTbl;
CREATE TABLE prodTbl(
	prodCode CHAR(3) NOT NULL,
    prodID CHAR(4) NOT NULL,
    prodDate DATE NOT NULL,
    prodCur CHAR(10) NULL,
    -- 복합키로 기본키 정의함
    CONSTRAINT PK_prodTbl_prodCode_prodID
			   PRIMARY KEY (prodCode, prodID)
);