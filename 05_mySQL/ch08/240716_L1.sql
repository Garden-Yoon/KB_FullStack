-- ch08 L1 7page
use sqldb;
select * from buytbl;
select * from usertbl;

-- 가상의 테이블인 view 만들기
CREATE VIEW v_userbuytbl
AS SELECT U.userid, U.name, B.prodName, CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
	INNER JOIN buytbl B
		ON U.userid = B.userid;
        
select * FROM v_userbuytbl;
-- 위에서 정의한 뷰에서 이름이 김범수인 데이터만 출력하기
select * FROM v_userbuytbl
WHERE name = '김범수';


-- ---------------------------------------------
-- 