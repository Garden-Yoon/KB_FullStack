-- 2, 3page
USE sqldb;
CREATE TABLE stdtbl(
	stdName VARCHAR(10) NOT NULL PRIMARY KEY,
    addr CHAR(4) NOT NULL
    );
    
CREATE TABLE clubtbl(
	clubName VARCHAR(10) NOT NULL PRIMARY KEY,
    roomNO CHAR(4) NOT NULL
    );
    
CREATE TABLE stdclubtbl(
	num int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	stdName VARCHAR(10) NOT NULL,
    clubName VARCHAR(10) NOT NULL,
    FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
    FOREIGN KEY(clubName) REFERENCES clubtbl(clubName) 
    );

INSERT INTO stdtbl VALUES ('김범수', '경남'), ('성시경', '서울'), ('조용필', '경기'), ('은지원','경북'), ('바비킴', '서울');
INSERT INTO clubtbl VALUES ('수영', '101호'), ('바둑', '102호'), ('축구', '103호'), ('봉사', '104호');
INSERT INTO stdclubtbl VALUES (NULL, '김범수', '바둑'), (NULL, '김범수', '축구'), (NULL, '조용필', '축구'), (NULL, '은지원', '축구'), (NULL, '은지원', '봉사'), (NULL, '바비킴', '봉사'); 

-- page3
-- 학생 테이블, 동아리 테이블, 학생 동아리 테이블을 이용해서 학생을 기준으로 학생이름/지역/가입한 동아리/동아리방 출력
-- SELECT
-- FROM stdbl S
-- 	INNER JOIN stdclubtbl SC
-- 		ON 



-- page4