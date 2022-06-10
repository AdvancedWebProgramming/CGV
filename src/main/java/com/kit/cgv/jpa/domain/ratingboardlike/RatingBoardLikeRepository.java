package com.kit.cgv.jpa.domain.ratingboardlike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingBoardLikeRepository extends JpaRepository<RatingBoardLike, Long> {

    @Query("Select 1 from RatingBoardLike rbl WHERE rbl.member.memberID = :memberId AND rbl.ratingBoard.ratingBoardId = :ratingBoardId")
    Integer intRatingBoardLikeWithmemberIdAndMovieId(Long memberId, Long ratingBoardId);

    @Query("Select rbl from RatingBoardLike rbl WHERE rbl.member.memberID = :memberId AND rbl.ratingBoard.ratingBoardId = :ratingBoardId")
    RatingBoardLike getRatingBoardLikeWithmemberIdAndMovieId(Long memberId, Long ratingBoardId);


}
