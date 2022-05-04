package com.kit.cgv.pbh.repository;

import com.kit.cgv.pbh.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
