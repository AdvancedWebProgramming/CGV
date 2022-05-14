package com.kit.cgv.controller;

import com.kit.cgv.dto.member.MemberLoginDTO;
import com.kit.cgv.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    final private MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(MemberLoginDTO dto) {
        return memberService.Login(dto);
    }
}
