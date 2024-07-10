use shopdb;
-- * : 모두 선택, From뒤에는 테이블명, Select 뒤에는 컬럼(열)
select * from productTBL;
-- 데이터를 두 개 이상 검색할 때는 ,로 이어준다
select memberName, memberAddress from memberTBL;
-- where절 뒤에는 조건식, =이 같다는 뜻으로 쓰임
select * from memberTBL where membername='지운이';