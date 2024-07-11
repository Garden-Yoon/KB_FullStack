USE sqldb;
SHOW tables;
DESCRIBE buytbl;
DESCRIBE usertbl;

-- 2page : sqldb에서 아래 조건을 처리
-- 사용자별로 구매이력을 출력, 모든 컬럼을 출력, 구매 이력이 없는 정보는 출력하지 않음
select * from buytbl
	inner join usertbl
		on buytbl.userID = usertbl.userID;

-- 위의 결과에서 userID가 'JYP'인 데이터만 출력
select * from buytbl
	inner join usertbl
		on buytbl.userID = usertbl.userID
	where buytbl.userID = 'JYP';



-- 3page : sqldb에서 아래 조건을 처리
-- 각 사용자별 구매 이력 출력, 연결 컬럼은 userID, userID 기준 오름차순 정렬, 구매이력 X도 출력
-- (userID, name, prodName, addr, 연락처 출력)
select U.userID, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처'
	from buytbl B
	left outer join usertbl U
		on B.userID = U.userID
	order by userID;



-- 4page
-- sqldb의 사용자를 모두 조회하되, 전화가 없는 사람은 제외하고 출력
select name, concat(U.mobile1, U.mobile2) as '연락처'
	from usertbl U
    where name not IN (select name from usertbl where mobile1 IS null);

-- sqldb의 사용자를 모두 조회하되, 전화기가 없는 사람만 출력
select name, concat(U.mobile1, U.mobile2) as '연락처'
	from usertbl U
    where name IN (select name from usertbl where mobile1 IS null);


