package com.kit.cgv.service.impl;

import com.kit.cgv.dto.manager.ManagerLoginDTO;
import com.kit.cgv.jpa.domain.member.Manager;
import com.kit.cgv.jpa.domain.member.ManagerRepository;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.service.ManagerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public ResponseEntity login(ManagerLoginDTO dto) {
        Manager findManager = managerRepository.findById(dto.getLoginId()).get();
        if(null == findManager){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("아이디가 존재하지 않습니다.");
        }
        if(!findManager.getPassword().equals(dto.getPassword())){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("비밀번호가 맞지 않습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
