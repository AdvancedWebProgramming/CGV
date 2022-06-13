package com.kit.cgv.service.impl;

import com.kit.cgv.dto.movie.MovieDTO;
import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.movie.MovieRepository;
import com.kit.cgv.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getMovies() {
        return movieRepository.findAll().stream().map(movie -> movie.toDTO()).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMoviesWithSort(String sort_by) {
        String input = null;
        List<Movie> data = null;
        if(sort_by.equals("salerate"))
            data = movieRepository.getAllByOrderBySaleRateDesc();

        if(sort_by.equals("rating"))
            data = movieRepository.getAllByOrderByEvaluationRateDesc();

        return data.stream().map(movie -> movie.toDTO()).collect(Collectors.toList());
    }


}
