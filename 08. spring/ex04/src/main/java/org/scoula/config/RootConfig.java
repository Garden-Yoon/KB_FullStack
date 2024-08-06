package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//@Configuration : 설정
@Configuration
// @PropertySource : 프로퍼티 파일을 어디서 가져올 지 설정 (classpath를 붙여줘야 프로젝트의 루트로 접근)
// 그냥 / 를 사용하면 webapp 폴더가 루트가 된다
@PropertySource({"classpath:/application.properties"})
public class RootConfig {
    // application.properties 파일에서 값을 읽어와서 변수에 주입
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // 설정 객체에 데이터베이스 연결 정보를 설정
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

//        HikariDataSource 객체 생성 후 설정을 적용
        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }
}
