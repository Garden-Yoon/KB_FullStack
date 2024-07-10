use sqldb;
describe buytbl;

-- 2page
-- buytbl에서 총 구매개수로 그룹
select userID as '사용자 아이디', sum(amount) as '총 구매개수'
from buytbl
group by userID;

-- buytbl에서 총 구매액으로 그룹
select userID as '사용자 아이디', sum(amount*price) as '총 구매금액'
from buytbl
group by userID;



-- 3page
-- buytbl에서 평균 구매 개수
select avg(amount) as '평균 구매 개수'
from buytbl;

-- buytbl에서 userID별 평균 구매 개수
select userID, avg(amount) as '평균 구매 개수'
from buytbl
group by userID;



-- 4page
-- usertbl에서 가장 키가 큰 사람과 가장 키가 작은 사람 출력
describe usertbl;
select name, height
from usertbl
where height = (select max(height) from usertbl)
	or height = (select min(height) from usertbl);



-- 5page
-- usertbl에서 휴대폰이 있는 사용자의 합을 출력
select count(mobile1) as '휴대폰이 있는 사용자'
from usertbl;



-- 6page
-- buytbl 테이블에서 사용자별 총 구매액을 출력함
select userID as '사용자', sum(price*amount) as '총 구매액'
from buytbl
group by userID;

-- buytbl 테이블에서 총 구매액이 1,000이상인 사용자만 출력하기
select userID as '사용자', sum(price*amount) as '총 구매액'
from buytbl
group by userID
having sum(price*amount) >= 1000;



-- 7page
-- city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 총합
use world;
describe city;
select countrycode, sum(population) as '인구수'
from city
where countrycode = 'kor';

-- city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최소값 (단, 필드는 최소값으로 표시)
SELECT MIN(population) AS'최솟값'
FROM city
where countrycode = 'kor';

-- city 테이블에서 국가코드가 'KOR'인 도시들의 인구수의 평균
SELECT AVG(population) AS'평균값'
FROM city
where countrycode = 'kor';

-- city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최대값 (단, 필드는 최대값으로 표시)
SELECT MAX(population) AS'최대값'
FROM city
where countrycode = 'kor';

-- country 테이블 각 레코드의 Name 칼럼의 글자 수를 표시
SELECT name, length(name) AS'name컬럼의 글자수'
FROM country;

-- country 테이블의 나라명(Name 칼럼)을 앞 세글자만 대문자로 표시
SELECT UPPER(MID(name, 1, 3)) FROM Country;

-- country 테이블의 기대수명(LifeExpectancy)을 소수점 첫째자리에서 반올림
SELECT name as '이름', ROUND(MID(LifeExpectancy, 1)) as '기대수명'
FROM Country;