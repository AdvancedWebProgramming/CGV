package com.kit.cgv.service.impl;


import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.movie.MovieRepository;
import com.kit.cgv.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Page<Movie> listContents(Pageable pageable){
        return movieRepository.findAll(pageable);
    }

    @Override
    public Movie viewDetails (Long midx){
        return movieRepository.getById(midx);
    }
}
