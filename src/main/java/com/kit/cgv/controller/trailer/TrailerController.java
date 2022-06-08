package com.kit.cgv.controller.trailer;

import com.kit.cgv.service.TrailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trailer")
public class TrailerController {

    private final TrailerService trailerService;

    //application/json 타입이 아닌, multipart/form-data 형식
    @PostMapping("/{movieId}")
    public ResponseEntity saveTrailer(@RequestParam MultipartFile multipartFile, @PathVariable Long movieId){
        return trailerService.saveTrailer(multipartFile, movieId);
    }

}
