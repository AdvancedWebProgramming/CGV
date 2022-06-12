package com.kit.cgv.service.impl;

import com.kit.cgv.dto.movie.MovieDTO;
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
}
