use sakila;
select * from actor_info;

use sqldb;
select * from buytbl;
select userID, sum(amount)
from buytbl
group by userID;

-- 구매목록을 볼 때
use sqldb;
select * from buytbl;
-- group_Concat : 그룹별로 연결시키겠다는 의미 (,로 구분지어줌)
select userID, group_concat(prodName separator ',')
from buytbl
group by userID;