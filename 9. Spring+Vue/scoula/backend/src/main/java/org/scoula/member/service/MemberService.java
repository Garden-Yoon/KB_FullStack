package org.scoula.member.service;


import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;

public interface MemberService {
    // 주어진 사용자 이름이 중복되는지 확인
    boolean checkDuplicate(String username);
    // 주어진 사용자 이름으로 회원 정보를 가져옴
    MemberDTO get(String username);
    // 회원가입 처리, MemberJoinDTO를 받아 회원정보를 저장하고, 저장된 회원 정보를 반환
    MemberDTO join(MemberJoinDTO member);
}