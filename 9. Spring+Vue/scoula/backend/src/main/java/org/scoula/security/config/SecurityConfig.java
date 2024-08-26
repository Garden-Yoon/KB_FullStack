package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.AuthenticationErrorFilter;
import org.scoula.security.filter.JwtAuthenticationFilter;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.scoula.security.handler.CustomAccessDeniedHandler;
import org.scoula.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity      // 모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;


    private final AuthenticationErrorFilter authenticationErrorFilter;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();     // PasswordEncoder의 구현체
    }

    // AuthenticationManager 빈 등록
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // cross origin 접근 허용
    // 다양한 도메인에서 서버에 요청을 보낼 수 있다
    @Bean
    public CorsFilter corsFilter() {
        // CORS 설정을 적용할 URL 소스 생성
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // CORS 설정을 위한 객체 생성
        CorsConfiguration config = new CorsConfiguration();
        // 자격 증명 (쿠키, 인증 헤더 등)을 포함한 요청을 허용하도록 설정
        config.setAllowCredentials(true);
        // 모든 도메인에서 오는 요청 허용 (*은 모두라는 의미)
        config.addAllowedOriginPattern("*");
        // 모든 헤더 허용
        config.addAllowedHeader("*");
        // 모든 HTTP 메소드 허용 (GET , POST, PUT, DELETE)
        config.addAllowedMethod("*");
        // 설정된 CORS 구성을 모든 경로("/**")에 적용 (하위 경로 포함)
        source.registerCorsConfiguration("/**", config);
        // 설정된 소스 기반으로 새로운 CorsFilter 반환
        return new CorsFilter(source);
    }

    // 특정 경로에 대한 보안 필터를 적용하지 않도록 접근 제한 무시 경로 설정 – resource
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 해당 경로들은 보안 검사 무시
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
    }



    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }



    @Override
    public void configure(HttpSecurity http) throws Exception {
        // addFilterBefore 메소드를 사용하여 CharacterEncodingFilter를 CsrfFilter 이전에 넣어준다
        // 이 설정은 모든 요청에 대해 UTF-8 인코딩 적용 후에 CSRF 보호가 이루어지도록 함
        http.addFilterBefore(encodingFilter(), CsrfFilter.class)   // 한글 인코딩 필터 설정
                // 기준필터로는 사용자 필터를 사용할 수 없다
                // 실행 순서 : jwtUsernamePasswordAuthenticationFilter -> jwtAuthenticationFilter
                // 인증 에러 필터
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class)
                // Jwt 인증 필터
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 로그인 인증 필터 (필터 순서 : jwtUsernamePasswordAuthenticationFilter -> UsernamePasswordAuthenticationFilter)
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // 예외 처리 설정
        http
                .exceptionHandling()
                // 인증 실패 시 처리할 객체
                .authenticationEntryPoint(authenticationEntryPoint)
                // 접근 거부 시 처리할 객체
                .accessDeniedHandler(accessDeniedHandler);



        http.httpBasic().disable() // 기본 HTTP 인증 비활성화
                .csrf().disable() // CSRF 비활성화
                .formLogin().disable() // formLogin 비활성화 관련 필터 해제
                // 세션 생성 모드 설정 (stateless : 세션 사용 안하겠다)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests() // 경로별 접근 권한 설정
                .antMatchers(HttpMethod.OPTIONS).permitAll()    // 모든 Options 요청 허용
                . anyRequest().permitAll(); // 나머지 요청들은 모두 접근 허용
//                .antMatchers("/api/security/all").permitAll() // 해당 경로의 모든 요청 허용
//                .antMatchers("/api/security/member").access("hasRole('ROLE_MEMBER')") // ROLE_MEMBER 이상 접근 허용
//                .antMatchers("/api/security/admin").access("hasRole('ROLE_ADMIN')") // ROLE_ADMIN 이상 접근 허용
//                .anyRequest().authenticated(); // 나머지는 로그인 된 경우 모두 허용

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // in memory user 정보 삭제 -> UserDetailsService와 같이 사용 불가
        // 메모리 정보 대신 UserDetailsService를 사용해서 인증처리하도록 설정
        auth
                .userDetailsService(userDetailsService)     // 사용자 정보 로드
                .passwordEncoder(passwordEncoder());        // 비밀번호 암호화
    }
}