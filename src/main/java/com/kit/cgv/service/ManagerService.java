package com.kit.cgv.service;


import com.kit.cgv.dto.manager.ManagerLoginDTO;
import org.springframework.http.ResponseEntity;

public interface ManagerService {

    ResponseEntity login(ManagerLoginDTO dto);
}
