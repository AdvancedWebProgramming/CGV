package com.kit.cgv.jpa.domain.ratingboard;

import com.kit.cgv.jpa.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingBoardRepository extends JpaRepository<RatingBoard, Long> {
    List<RatingBoard> getRatingBoardsByMovie(Movie movie);
}
