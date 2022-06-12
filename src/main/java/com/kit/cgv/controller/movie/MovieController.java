package com.kit.cgv.controller.movie;

import com.kit.cgv.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/")
public class MovieController {

    private final MovieService movieService;

    public ResponseEntity getMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }
}
