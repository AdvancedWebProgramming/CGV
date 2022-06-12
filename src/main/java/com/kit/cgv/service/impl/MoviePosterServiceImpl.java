package com.kit.cgv.service.impl;

import com.kit.cgv.dto.MoviePosterDTO;
import com.kit.cgv.jpa.domain.movieposter.MoviePosterRepository;
import com.kit.cgv.service.MoviePosterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MoviePosterServiceImpl implements MoviePosterService {

    private final MoviePosterRepository moviePosterRepository;

    @Override
    public MoviePosterDTO getFileUrl(Long moviePosterId) {
        return moviePosterRepository.getById(moviePosterId).toDTO();
    }
}
