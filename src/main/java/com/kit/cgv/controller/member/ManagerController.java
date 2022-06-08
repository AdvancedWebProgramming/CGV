package com.kit.cgv.controller.member;

import com.kit.cgv.dto.manager.ManagerLoginDTO;
import com.kit.cgv.dto.member.MemberLoginDTO;
import com.kit.cgv.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
@RequiredArgsConstructor

public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/login")
    public ResponseEntity login(ManagerLoginDTO dto){
        return managerService.login(dto);
    }

}
