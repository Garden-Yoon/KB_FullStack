package org.scoula.persistence;


import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j
public class JDBCTests {
    // 정적 블록 사용해서 JDBC 드라이버 로드
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다.")
    public void testConnection() {
        String url = "jdbc:mysql://localhost:3306/scoula_db";
        try(Connection con = DriverManager.getConnection(url, "scoula", "1234")){
            // url 설정 후 데이터베이스 연결 객체를 로그에 출력    
            log.info(con);
        } catch (Exception e) {
            // 예외 발생 시 메세지 출력 후 테스트 실패처리함
            fail(e.getMessage());
        }
    }
}
