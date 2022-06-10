package com.kit.cgv.service.impl;

import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoard;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoardRepository;
import com.kit.cgv.jpa.domain.ratingboardlike.RatingBoardLike;
import com.kit.cgv.jpa.domain.ratingboardlike.RatingBoardLikeRepository;
import com.kit.cgv.service.RatingBoardLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class RatingBoardLikeServiceImpl implements RatingBoardLikeService {

    private final RatingBoardLikeRepository ratingBoardLikeRepository;

    private final RatingBoardRepository ratingBoardRepository;

    private final MemberRepository memberRepository;

    @Override
    public Boolean isLiked(Long ratingBoardId, Long memberId) {
        return ratingBoardLikeRepository.intRatingBoardLikeWithmemberIdAndMovieId(memberId, ratingBoardId) == 1;
    }

    @Override
    public Boolean toggleLike(Long ratingBoardId, Long memberId) {
        RatingBoardLike ratingBoardLike = ratingBoardLikeRepository.getRatingBoardLikeWithmemberIdAndMovieId(memberId, ratingBoardId);
        RatingBoard ratingBoard = ratingBoardRepository.getById(ratingBoardId);
        Member member = memberRepository.getById(memberId);
        if(ratingBoardLike == null){
            ratingBoardLikeRepository.save(RatingBoardLike.builder().ratingBoard(ratingBoard).member(member).build());
            ratingBoard.increaseLikeCount();
            ratingBoardRepository.save(ratingBoard);
        }else{
            ratingBoardLikeRepository.delete(ratingBoardLike);
            ratingBoard.decreaseLikeCount();
            ratingBoardRepository.save(ratingBoard);
        }
        return null;
    }
}
