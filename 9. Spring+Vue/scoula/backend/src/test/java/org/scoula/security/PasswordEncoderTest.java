package org.scoula.security;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class})
@Log4j
public class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder pwEncoder;

    @Test
    public void testEncode() {
        String str = "1234";
        
        // 비밀번호 인코딩 및 로그 출력
        String enStr = pwEncoder.encode(str); // 암호화
        log.info("password: " + enStr);
        
        // 동일한 비밀번호 다시 인코딩
        String enStr2 = pwEncoder.encode(str); // 암호화
        log.info("password: " + enStr2);

        // 인코딩된 비밀번호와 원본 비밀번호 비교 시에는 matches 사용
        log.info("match :" + pwEncoder.matches(str, enStr)); // 비밀번호 일치 여부 검사
        log.info("match :" + pwEncoder.matches(str, enStr2)); // 비밀번호 일치 여부 검사
        // 각각의 인코딩 된 비밀번호 비교 시에는 다르다고 나온다
        log.info("match :" + pwEncoder.matches(enStr, enStr2));
    }
}
