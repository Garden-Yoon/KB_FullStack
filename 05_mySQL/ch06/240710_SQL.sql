use employees;
create table users
(select first_name as 성, gender from employees);
select * from users;

use world;
create table kor_city
(select id, name, district, population from city
where countrycode = 'kor');
select * from kor_city;

-- city 테이블을 사용해서 국가별 총 인구수 출력
use world;
select countrycode, sum(population) as '인구수'
from city
group by countrycode
order by countrycode;