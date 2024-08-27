package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    // passwordEncoder는 Security Config파일에 Bean으로 등록
    final PasswordEncoder passwordEncoder;  // 비밀번호 암호화를 위한 인코더
    final MemberMapper mapper;  // DB 접근을 위한 매퍼
    
    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username);  // 주어진 사용자 이름으로 회원 정보 조회
        return member != null ? true : false;   // null이 아니면 (이미 있는 ID, 중복이면) true, 아니면 false 반환
    }
    
    @Override
    public MemberDTO get(String username) {
        // 주어진 사용자 이름으로 회원 정보 조회, 없으면 예외 발생
        MemberVO member = Optional.ofNullable(mapper.get(username))
                .orElseThrow(NoSuchElementException::new);  
        return MemberDTO.of(member);    // 회원정보를 DTO로 변환하여 반환
    }
    
    // 아바타 이미지를 저장하는 메소드
    private void saveAvatar(MultipartFile avatar, String username) {
        //아바타 업로드
        if(avatar != null && !avatar.isEmpty()) {   // avatar가 존재하는 경우에만 조건문 실행
            File dest = new File("c:/upload/avatar", username + ".png");    // 저장할 경로 설정
            try {
                avatar.transferTo(dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Transactional
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member = dto.toVO();   // DTO를 VO로 변환

        // 비밀번호 암호화
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        mapper.insert(member);

        // 기본 회원 권한 설정 및 저장
        AuthVO auth = new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");
        mapper.insertAuth(auth);// 테이블 쪽에 권한 정보 저장
        
        // 해당 유저의 아바타 이미지 저장
        saveAvatar(dto.getAvatar(), member.getUsername());  

        // 저장된 회원 정보 반환
        return get(member.getUsername());
    }
}