package com.kit.cgv.service;


import com.kit.cgv.dto.ratingboard.RatingBoardDTO;
import org.springframework.http.ResponseEntity;

public interface RatingBoardService {
    ResponseEntity findAllWithMovieId(Long movieId);

    ResponseEntity createRatingBoard(RatingBoardDTO dto);

    ResponseEntity updateRatingBoard(RatingBoardDTO dto);

    ResponseEntity deleteRatingBoard(Long ratingBoardId);
}
