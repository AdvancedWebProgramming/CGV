package com.kit.cgv.service.impl;


import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.movie.MovieRepository;
import com.kit.cgv.jpa.domain.trailer.Trailer;
import com.kit.cgv.jpa.domain.trailer.TrailerRepository;
import com.kit.cgv.service.TrailerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TrailerServiceImpl implements TrailerService {
    private final TrailerRepository trailerRepository;
    private final MovieRepository movieRepository;
    @Value("${dir.path}")
    private String dirPath;

    @Override
    public ResponseEntity saveTrailer(MultipartFile trailer, Movie movie) {
        String filePath = dirPath + UUID.randomUUID();

        try {
            trailer.transferTo(new File(filePath));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("정상적으로 저장되지 않았습니다.");
        }

        Trailer saveTrailer = trailerRepository.save(Trailer.builder()
                .fileName(trailer.getName())
                .movie(movie)
                .path(filePath)
                .build());

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity saveTrailer(MultipartFile trailer, Long movieId) {
        Movie findMovie = movieRepository.getById(movieId);

        return saveTrailer(trailer, findMovie);
    }
}
