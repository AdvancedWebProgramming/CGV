package com.kit.cgv.controller.screendetail;

import com.kit.cgv.dto.screendetail.ScreenDetailUpdateDTO;
import com.kit.cgv.service.ScreenDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class ScreenDetailController {

    private final ScreenDetailService screenDetailService;

    @GetMapping("/screens")
    public ResponseEntity getLists(){
        return ResponseEntity.status(HttpStatus.OK).body(screenDetailService.getLists());
    }

    @PostMapping("/{managerId}/fixedrate")
    public ResponseEntity fixedRateUpdate(@RequestBody ScreenDetailUpdateDTO dto){
        return screenDetailService.updateScreenDetailWithFixedRate(dto);
    }

    @PostMapping("/{managerId}/discount")
    public ResponseEntity discountUpdate(@RequestBody ScreenDetailUpdateDTO dto){
        return screenDetailService.updateScreenDetailWithDiscount(dto);
    }
}
