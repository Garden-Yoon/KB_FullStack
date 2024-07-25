-- 2page
-- 현재 서버에 존재하는 데이터베이스 확인
SHOW DATABASES;
-- 현재 데이터베이스를 employees로 설정하기
USE employees;
-- employees 데이터베이스의 테이블 목록 보기 
SHOW TABLES;
-- employees 테이블의 열 목록 출력하기
describe employees;



-- 3page
-- tiltes 테이블의 데이터 출력하기
select * from titles;
-- employees 테이블에서 first_name 컬럼만 출력하기
select first_name from employees;
-- employees 테이블에서 firstname_last_name, gender 컬럼 출력하기
select first_name, last_name, gender from employees;



-- 4page
-- employess 테이블에서 first_name, gender, hire_date 컬럼만 출력
select first_name as 이름, gender as 성별, hire_date as '회사 입사일' from employees;



-- 5, 6page
-- usertbl 테이블에서 이름이 '김경호'인 행 출력
use sqldb;
select * from usertbl
where name ='김경호';

-- usertbl 테이블에서 생년이 1970 이상이고 키가 182 이상인 데이터 출력
select * from usertbl
where birthYear >= 1970 and
	  height >=182;
      
      

-- 7page
-- usertbl 테이블에서 키가 180~183 범위인 데이터를 출력
select * from usertbl
where height between 180 and 183; 

-- usertbl 테이블에서 주소가 '경남' 또는 '전남' 또는 '경북'인 데이터 출력
select * from usertbl
where addr in ('경남', '전남', '경북');

-- usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력
select * from usertbl
where name like '김%';



-- 8page
-- usertbl에서 김경호보다 큰 사람들의 이름과 키를 출력 (서브쿼리)
use sqldb;
select * from usertbl
where height >(select height from usertbl where name ='김경호');



-- 9page
-- usertbl을 mdate의 오름차순으로 정렬
select * from usertbl
order by mdate;

-- usertbl을 mdate의 내림차순으로 정렬
select * from usertbl
order by mdate desc;

-- userbl을 height의 내림차순으로 정렬하고
-- 동률인 경우 name의 내림차순으로 정렬
select * from usertbl
order by height desc, name desc;



-- 10page
-- useertbl의 주소지를 중복없이 오름차순으로 출력
select distinct addr from usertbl
order by addr asc;



-- 11page
-- world db에서 국가코드가 'KOR'인 도시를 찾아 인구수를 역순으로 표시하기
USE WORLD;
SELECT * from city
where countrycode = 'kor'
order by population desc;

-- city 테이블에서 국가코드와 인구수를 출력
-- 정렬은 국가코드 (오름차순), 동일 국가(코드) 내에서는 인구수의 역순
SELECT countrycode, population FROM city
ORDER BY countrycode, population DESC;

-- city 테이블에서 국가코드가 'kor'인 도시의 수를 표시
SELECT count(population) FROM city
where countrycode = 'kor';

-- city 테이블에서 국가코드가 'kor', 'chn', 'jpn' 인 도시를 찾으세요
SELECT * FROM city
WHERE countrycode in ('kor', 'chn', 'jpn');

-- city 테이블에서 국가코드가 'kor'이면서 인구가 1000만 이상인 도시를 찾으세요
SELECT * From city 
Where countrycode='kor' and population >= 1000000;

-- city 테이블에서 국가코드가 'kor'이면서 인구수가 많은 순서로 상위 10개만 표시
SELECT * From city 
Where countrycode='kor'
ORDER BY population desc
limit 10;

-- city 테이블에서 국가코드가 'kor'이면서 인구수가 100만 이상 500만 이하인 도시를 찾으세요
SELECT * From city 
Where countrycode='kor'
and population between 1000000 and 5000000;