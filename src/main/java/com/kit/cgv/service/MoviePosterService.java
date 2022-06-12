package com.kit.cgv.service;

import com.kit.cgv.dto.MoviePosterDTO;

public interface MoviePosterService {
    MoviePosterDTO getFileUrl(Long moviePosterId);
}
