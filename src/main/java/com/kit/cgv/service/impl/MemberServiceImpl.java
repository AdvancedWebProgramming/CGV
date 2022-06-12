package com.kit.cgv.service.impl;


import com.kit.cgv.dto.member.MemberSignUpDTO;
import com.kit.cgv.dto.member.MemberLoginDTO;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import com.kit.cgv.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public ResponseEntity<?> Login(MemberLoginDTO dto) {
        Member findMember = memberRepository.findByMemberLoginID(dto.getLoginID());
        if(null == findMember){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디가 존재하지 않습니다.");
        }
        if(!findMember.getMemberPWD().equals(dto.getPassword())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호가 맞지 않습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("로그인 성공");
    }

    @Override
    public ResponseEntity signUp(MemberSignUpDTO dto) {
        Member findMember = findMemberByLoginId(dto.getLoginId());
        if(null != findMember){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("아이디가 존재합니다.");
        }

        if(!dto.getPassword().equals(dto.getConfrimPassword())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호와 비밀번호 확인은 같아야합니다.");
        }

        Member member = memberRepository.save(dto.toEntity());
        return ResponseEntity.status(HttpStatus.OK).body(member.toSignUpDTO(dto.getConfrimPassword()));
    }

    @Override
    public Member findMemberByLoginId(String loginId) {
        return memberRepository.findByMemberLoginID(loginId);
    }
}
