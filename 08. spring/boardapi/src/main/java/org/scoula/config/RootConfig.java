package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration : 설정
@Configuration
// @PropertySource : 프로퍼티 파일을 어디서 가져올 지 설정 (classpath를 붙여줘야 프로젝트의 루트로 접근)
// 그냥 / 를 사용하면 webapp 폴더가 루트가 된다
@ComponentScan(basePackages = {"org.scoula.board.service"})
@PropertySource({"classpath:/application.properties"})
@MapperScan(basePackages = {"org.scoula.board.mapper"})   // mapper의 위치 알려주기
public class RootConfig {
    // application.properties 파일에서 값을 읽어와서 변수에 주입
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

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


    // application scope
    @Autowired
    ApplicationContext applicationContext;

    // mybatis의 SqlSessionFactory를 Bean으로 등록해주는 메소드
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        // SqlSessionFactoryBean 객체 생성
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        // mybatis 설정 파일의 위치 알려줌
        sqlSessionFactory.setConfigLocation(
                applicationContext.getResource("classpath:/mybatis-config.xml"));
//        DataSource 설정
        sqlSessionFactory.setDataSource(dataSource());
        // 객체 반환
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    // DataSourceTransactionManager를 Bean으로 등록하는 메소드
    @Bean
    public DataSourceTransactionManager transactionManager() {
//         dataSource를 넣어서 DataSourceTransactionManager 객체 생성
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }

}
