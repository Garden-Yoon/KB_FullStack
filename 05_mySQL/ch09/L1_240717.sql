-- page2 : sqldb 데이터베이스에 아래 컬럼을 가지는 테이블 tbl1을 생성하고,
-- 자동 생성된 인덱스 목록을 확인하기
-- 컬럼 목록 : a INT PRIMARY KEY, b INT, C INT
USE sqldb;
CREATE TABLE tbl1 (
	a INT PRIMARY KEY,
    b INT,
    c INT
);
-- 해당 테이블에 대한 인덱스를 보여줌
-- PK 제약조건 : 해당 속성이 클러스터형 인덱스로 자동생성됨
SHOW INDEX FROM tbl1;


-- 3page : sqldb 데이터베이스에 아래 컬럼을 가지는 테이블 tbl2을 생성하고,
-- 자동 생성된 인덱스 목록을 확인하기
-- 컬럼 목록 : a INT PRIMARY KEY UNIQUE, b INT UNIQUE, C INT UNIQUE, D INT
USE sqldb;
CREATE TABLE tbl2(
     -- PK : 클러스터형 인덱스 자동생성 (테이블 당 1개만 생성)
     a INT PRIMARY KEY,
     -- UNIQUE : 보조 인덱스 자동 생성 (보조 인덱스는 여러개 생성 가능)
     b INT UNIQUE,
     c INT UNIQUE,
     d INT
);
SHOW INDEX FROM tbl2;



-- 4page : sqldb 데이터베이스에 아래 컬럼을 가지는 테이블 tbl3을 생성하고,
-- 자동 생성된 인덱스 목록을 확인하기
-- 컬럼 목록 : a INT UNIQUE, b INT UNIQUE, C INT UNIQUE, D INT
USE sqldb;
CREATE TABLE tbl3(
     -- UNIQUE : 보조 인덱스 자동 생성 (보조 인덱스는 여러개 생성 가능)
	 a INT UNIQUE,
     b INT UNIQUE,
     c INT UNIQUE,
     d INT
);
SHOW INDEX FROM tbl3;



-- 5page : sqldb 데이터베이스에 아래 컬럼을 가지는 테이블 tbl4을 생성하고,
-- 자동 생성된 인덱스 목록을 확인하기
-- 컬럼 목록 : a INT UNIQUE NOT NULL, b INT UNIQUE, C INT UNIQUE, D INT
USE sqldb;
CREATE TABLE tbl4(
     -- UNIQUE, NOT NULL 조건 -> 클러스터형 인덱스가 됨
	 a INT UNIQUE NOT NULL,
     -- UNIQUE : 보조 인덱스 자동 생성 (보조 인덱스는 여러개 생성 가능)
     b INT UNIQUE,
     c INT UNIQUE,
     d INT
);
SHOW INDEX FROM tbl4;



-- 6page : sqldb 데이터베이스에 아래 컬럼을 가지는 테이블 tbl5을 생성하고,
-- 자동 생성된 인덱스 목록을 확인하기
-- 컬럼 목록 : a INT UNIQUE NOT NULL, b INT UNIQUE, c INT UNIQUE, d INT PRIMARY KEY
USE sqldb;
CREATE TABLE tbl5(
	 -- UNIQUE, NOT NULL 조건이지만 클러스터형 인덱스는 1개만 생성가능하므로 보조인덱스로 생성된다
     a INT UNIQUE NOT NULL,
     -- UNIQUE : 보조 인덱스 자동 생성 (보조 인덱스는 여러개 생성 가능)
     b INT UNIQUE,
     c INT UNIQUE,
     d INT PRIMARY KEY
);
SHOW INDEX FROM tbl5;



-- 7page (1) :testdb에 usertbl을 만드세요
-- testdb가 존재하지 않으면 database 생성
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

-- usertbl이 존재하면 지운다
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr NCHAR(2) NOT NULL
);
select * from testdb.usertbl;


-- 7page (2) : 테이블에 데이터 추가하고 클러스터형 인덱스의테이블 내용 확인
INSERT INTO usertbl VALUES('LSG', '이승기',  1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수',  1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호',  1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필',  1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경',  1979, '서울');
-- PK인 userID 기준으로 데이터 정렬되어있음
select * FROM usertbl;


-- 8page(1) : PK 제약조건 삭제 하고, name컬럼에 pk_name이라는 제약조건명으로 기본키 설정하기
-- 8page(2) : usertbl 내용을 출력하여 새로운 클러스터형 인덱스 확인하기
-- ALTER TABLE 키워드로 제약조건을 추가/삭제할 수 있음
-- PK 제약조건 삭제
ALTER TABLE usertbl DROP PRIMARY KEY;
-- PK 제약조건을 name 컬럼에 추가
ALTER TABLE usertbl
	ADD CONSTRAINT pk_name PRIMARY KEY(name);
-- PK가 변경되면서 클러스터형 인덱스도 함께 변경되어, 정렬순서가 name 순으로 변경됨 (가나다순)
select * FROM usertbl;



 