package com.kit.cgv.service;

public interface RatingBoardLikeService {

    Boolean isLiked(Long ratingBoardId, Long memberId);

    Boolean toggleLike(Long ratingBoardId, Long memberId);
}
