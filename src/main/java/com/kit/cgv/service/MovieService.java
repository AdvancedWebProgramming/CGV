package com.kit.cgv.service;


import com.kit.cgv.dto.movie.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getMovies();

    List<MovieDTO> getMoviesWithSort(String sort_by);
}
