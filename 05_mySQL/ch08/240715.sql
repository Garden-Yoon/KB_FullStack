use sqldb;
select * from buytbl;

-- 데이터 롤백 안되면 추가하는 용도
INSERT INTO buytbl VALUES(1, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(2, 'KBS', '노트북', '전자', 1000, 1);
select * from buytbl;

-- 트랜잭션의 시작을 명시적으로 지정
START TRANSACTION;

-- 데이터 삭제
DELETE FROM buytbl WHERE num = 1;
DELETE FROM buytbl WHERE num = 2;
select * from buytbl;

-- 되돌리기 : ROLL BACK
ROLLBACK;
select * from buytbl;

SELECT @@autocommit;


