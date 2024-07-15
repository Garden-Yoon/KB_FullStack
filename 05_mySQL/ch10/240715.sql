-- 10.1. JDBC 프로그래밍
-- JDBC 데이터베이스 생성
CREATE DATABASE jdbc_ex;

-- 사용자 준비
CREATE USER 'jdbc_ex'@'%' IDENTIFIED BY 'jdbc_ex';
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'jdbc_ex'@'%';
FLUSH PRIVILEGES;