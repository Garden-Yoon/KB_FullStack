package org.scoula.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.scoula.security.account.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // 스프링 생성자 주입을 통해 데이터 전달
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager, // SecurityConfig가 생성된 이후에 등록됨
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler) {
        super(authenticationManager);
        setFilterProcessesUrl("/api/auth/login"); // POST 로그인 요청 url
        setAuthenticationSuccessHandler(loginSuccessHandler); // 로그인 성공 핸들러 등록
        setAuthenticationFailureHandler(loginFailureHandler); // 로그인 실패 핸들러 등록
    }
    // 로그인 요청이 필터의 처리 url과 일치할 때, 로그인 작업 처리하는 메소드
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 요청 BODY의 JSON에서 사용자 이름(username), 비밀번호(password) 추출하여  LoginDTO 생성
        LoginDTO login = LoginDTO.of(request);
        // 사용자 이름과 비밀번호 사용하여 인증 토큰(UsernamePasswordAuthenticationToken) 구성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        // AuthenticationManager에게 인증 요청 (인증 위임해서 처리)
        return getAuthenticationManager().authenticate(authenticationToken);
    }
}