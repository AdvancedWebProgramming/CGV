package com.kit.cgv.controller.member;

import com.kit.cgv.dto.member.MemberSignUpDTO;
import com.kit.cgv.dto.member.MemberLoginDTO;
import com.kit.cgv.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    final private MemberService memberService;

    @PostMapping("login")
    public ResponseEntity<?> login(MemberLoginDTO dto) {
        return memberService.Login(dto);
    }

    @PostMapping("signup")
    public ResponseEntity<?> signUp(MemberSignUpDTO dto){
        return memberService.signUp(dto);
    }

}
