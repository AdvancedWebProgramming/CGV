package com.kit.cgv.service.impl;


import com.kit.cgv.dto.member.MemberEnrollDTO;
import com.kit.cgv.dto.member.MemberLoginDTO;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import com.kit.cgv.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
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
        Member findMember = memberRepository.findByMemberLoginID(dto.getLoginId());
        if(null == findMember){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("아이디가 존재하지 않습니다.");
        }
        if(!findMember.getMemberPWD().equals(dto.getPassword())){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("비밀번호가 맞지 않습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @Override
    public ResponseEntity enroll(MemberEnrollDTO dto) {
        Member findMember = findMemberByLoginId(dto.getId());
        if(null != findMember){
            return new ResponseEntity("아이디가 존재합니다.",HttpStatus.FORBIDDEN);
        }

        Member member = memberRepository.save(dto.toEntity());
        return new ResponseEntity(member,HttpStatus.OK);
    }

    @Override
    public Member findMemberByLoginId(String loginId) {
        return memberRepository.findByMemberLoginID(loginId);
    }
}
