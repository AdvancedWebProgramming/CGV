package com.kit.cgv.service;


import com.kit.cgv.dto.member.MemberLoginDTO;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity Login(MemberLoginDTO dto);
}
