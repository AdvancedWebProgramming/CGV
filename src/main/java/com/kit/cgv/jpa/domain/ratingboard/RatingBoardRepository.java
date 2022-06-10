package com.kit.cgv.jpa.domain.ratingboard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingBoardRepository extends JpaRepository<RatingBoard, Long> {
    List<RatingBoard> getRatingBoardsByMovieId(Long movieId);
}
