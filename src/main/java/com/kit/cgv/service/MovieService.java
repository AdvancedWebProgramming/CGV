package com.kit.cgv.service;

import com.kit.cgv.jpa.domain.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Page<Movie> listContents(Pageable pageable);
    Movie viewDetails (Long midx);
}
