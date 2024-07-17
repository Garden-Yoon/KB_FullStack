-- sqldb의 usertbl의 내용, 인덱스 목록, 데이터크기와 인덱스 크기 확인
USE sqldb;
SELECT * FROM usertbl;
-- 인덱스 목록 확인 (PK -> 클러스터형 인덱스)
SHOW INDEX FROM usertbl;
-- 데이터크기와 인덱스 크기 확인 (SHOW TABLE STATUS LIKE '테이블명')
SHOW TABLE STATUS LIKE 'usertbl';

-- addr 컬럼에 인덱스 만들기
CREATE INDEX idx_usertbl_addr
ON usertbl(addr);
SHOW INDEX FROM usertbl;

-- 인덱스 크기 확인 시, Index_length가 0으로 나온다 (analyze하지 않았기때문)
SHOW TABLE STATUS LIKE 'usertbl';

-- 생성한 인덱스를 실제 적용하려면 ANALYZE TABLE문으로 먼저 테이블을 분석/처리해줘야 함
ANALYZE TABLE usertbl;
-- Index_length 0이었는데, 분석 후 제대로 나오는걸 볼 수 있음
SHOW TABLE STATUS LIKE 'usertbl';

-- 출생년도(birthYear)에 보조 인덱스 생성
-- 범수랑 시경이 생일이 둘 다 1979이므로 중복값때문에 인덱스 생성 에러 발생
CREATE UNIQUE INDEX idx_usertbl_birthYear
ON usertbl(birthYear);


-- 이름(name)에 보조인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_name
ON usertbl(name);
SHOW INDEX FROM usertbl;

-- 이름(name)에 보조인덱스 삭제
DROP INDEX idx_usertbl_name ON usertbl;

-- name, birthYear 조합으로 인덱스 생성
-- 컬럼 조합 시 ,로 이어서 넣어준다
CREATE UNIQUE INDEX idx_usertbl_name_birthYear
ON usertbl(name, birthyear);

SHOW INDEX FROM usertbl;

-- 인덱스 삭제 : DROP INDEX 또는 ALTER TABLE 구문
DROP INDEX idx_usertbl_addr ON usertbl;
ALTER TABLE usertbl DROP INDEX idx_usertbl_name_birthYear;

SHOW INDEX FROM usertbl;