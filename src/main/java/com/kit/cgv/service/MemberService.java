package com.kit.cgv.service;


import com.kit.cgv.dto.member.MemberSignUpDTO;
import com.kit.cgv.dto.member.MemberLoginDTO;
import com.kit.cgv.jpa.domain.member.Member;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity Login(MemberLoginDTO dto);

    ResponseEntity signUp(MemberSignUpDTO dto);

    Member findMemberByLoginId(String loginId);
}
