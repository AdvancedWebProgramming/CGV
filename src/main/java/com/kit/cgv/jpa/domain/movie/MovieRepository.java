package com.kit.cgv.jpa.domain.movie;

import com.kit.cgv.jpa.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
