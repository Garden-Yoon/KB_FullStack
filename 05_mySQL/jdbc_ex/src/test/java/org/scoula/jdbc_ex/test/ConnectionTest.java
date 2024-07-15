package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("jdbc_ex 데이터베이스에 접속합니다")
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String id = "jdbc_ex";
        String password = "jdbc_ex";
        Connection conn = DriverManager.getConnection(url, id, password);
        System.out.println("DB 연결 성공");
        conn.close();
    }
}
