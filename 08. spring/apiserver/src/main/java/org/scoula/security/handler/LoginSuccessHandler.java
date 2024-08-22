package org.scoula.security.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.dto.AuthResultDTO;
import org.scoula.security.account.dto.UserInfoDTO;
import org.scoula.security.util.JsonResponse;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtProcessor jwtProcessor;    // jtt 토큰 관련 메소드 처리

    // 인증 결과로 AuthResultDTO 생성하는 메소드
    private AuthResultDTO makeAuthResult(CustomUser user) {
        String username = user.getUsername();
        // 토큰 생성
        String token = jwtProcessor.generateToken(username);
        // 토큰 + 사용자 기본 정보 (사용자명, ...)를 묶어서 AuthResultDTO 구성
        return new AuthResultDTO(token, UserInfoDTO.of(user.getMember()));
    }


    // 인증 성공 시 호출되는 메소드
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 인증 결과 Principal, 인증 결과에서 사용자 정보 가져옴
        CustomUser user = (CustomUser) authentication.getPrincipal();
        // 인증 성공 결과를 생성하고, JSON으로 직접 응답
        AuthResultDTO result = makeAuthResult(user);
        JsonResponse.send(response, result);
    }
}


