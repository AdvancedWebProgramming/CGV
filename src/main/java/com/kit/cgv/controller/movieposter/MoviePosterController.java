package com.kit.cgv.controller.movieposter;

import com.kit.cgv.service.MoviePosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/movieposter")
public class MoviePosterController {

    private final MoviePosterService moviePosterService;

    @GetMapping("/{moviePosterId}")
    public ResponseEntity getMoviePoster(@PathVariable Long moviePosterId){
        return ResponseEntity.status(HttpStatus.OK).body(moviePosterService.getFileUrl(moviePosterId));
    }

}
