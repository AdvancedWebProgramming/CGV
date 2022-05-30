package com.kit.cgv.service;

import com.kit.cgv.jpa.domain.movie.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface TrailerService {

    ResponseEntity saveTrailer(MultipartFile trailer, Movie movie);

    ResponseEntity saveTrailer(MultipartFile trailer, Long movieId);
}
