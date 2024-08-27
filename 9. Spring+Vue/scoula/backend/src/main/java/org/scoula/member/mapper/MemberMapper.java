package org.scoula.member.mapper;

import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

public interface MemberMapper {
    MemberVO get(String username);  // 주어진 사용자 이름으로 MemberVO 객체 가져오기
    MemberVO findByUsername(String username); // id 중복 체크시 사용
    int insert(MemberVO member); // 회원 정보 추가
    int insertAuth(AuthVO auth); // 회원 권한 정보 추가
}