package com.kit.cgv.jpa.domain.screendetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreenDetailRepository extends JpaRepository<ScreenDetail, Long> {
    @Query("Select sd FROM ScreenDetail sd JOIN Screen s ON sd.screen.screenId = s.screenId WHERE sd.screen.movie.movieId = :movieId")
    List<ScreenDetail> findWithMovieId(Long movieId);
}
