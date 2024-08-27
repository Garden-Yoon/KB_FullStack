package org.scoula.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

// 회원가입 시 회원이 직접 입력하는 정보
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberJoinDTO {
    String username;
    String password;
    String email;
    
    // 회원이 업로드한 아바타 이미지 파일 저장
    MultipartFile avatar;

    // MemberJoinDTO 객체를 MemberVO 객체로 변환하는 메소드
    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}

