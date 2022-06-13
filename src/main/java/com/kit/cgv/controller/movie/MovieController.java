package com.kit.cgv.controller.movie;

import com.kit.cgv.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }

    @GetMapping("/movie/")
    public ResponseEntity getMoviesWithSort(@RequestParam String sort_by) {
        log.error(sort_by);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMoviesWithSort(sort_by));
    }
}
