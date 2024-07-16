package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

// 테스트 메소드의 실행 순서를 지정해주는 어노테이션
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    // JDBC 연결 객체를 생성하여 초기화
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown(){
        // 모든 테스트가 완료된 후 JDBC 연결 종료
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException {
        // 사용자 정보를 데이터베이스에 삽입하는 SQL 쿼리
        String sql = "insert into users(id,password,name,role) values(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            // SQL 쿼리의 매개변수 설정
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            // SQL 쿼리 실행 및 삽입된 행의 수를 반환
            int count = pstmt.executeUpdate();
            // 삽입된 행의 수가 1인지 확인하는 테스트
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user 목록을 추출")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        }
    }
}
