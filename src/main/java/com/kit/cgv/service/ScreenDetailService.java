package com.kit.cgv.service;


import com.kit.cgv.dto.screendetail.ScreenDetailDTO;
import com.kit.cgv.dto.screendetail.ScreenDetailUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScreenDetailService {

    List<ScreenDetailDTO> getLists();

    ResponseEntity updateScreenDetailWithFixedRate(ScreenDetailUpdateDTO dto);

    ResponseEntity updateScreenDetailWithDiscount(ScreenDetailUpdateDTO dto);
}
