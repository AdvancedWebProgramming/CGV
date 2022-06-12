package com.kit.cgv.service.impl;


import com.kit.cgv.dto.ratingboard.RatingBoardDTO;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.movie.MovieRepository;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoard;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoardRepository;
import com.kit.cgv.jpa.domain.ratingboardlike.RatingBoardLikeRepository;
import com.kit.cgv.service.RatingBoardLikeService;
import com.kit.cgv.service.RatingBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RatingBoardServiceImpl implements RatingBoardService {

    private final RatingBoardRepository ratingBoardRepository;
    private final MemberRepository memberRepository;
    private final MovieRepository movieRepository;

    private final RatingBoardLikeRepository ratingBoardLikeRepository;
    private final RatingBoardLikeService ratingBoardLikeService;

    @Override
    public ResponseEntity findAllWithMovieId(Long movieId) {
        Movie findMovie = movieRepository.getById(movieId);
        List<RatingBoard> findList = ratingBoardRepository.getRatingBoardsByMovie(findMovie);

        return ResponseEntity.status(HttpStatus.OK).body(findList.stream()
                .map(ratingBoard -> ratingBoard.toDTO(ratingBoardLikeService.isLiked(ratingBoard.getRatingBoardId(), ratingBoard.getWriter().getMemberID())))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity createRatingBoard(RatingBoardDTO dto) {
        Optional<Member> findMember = memberRepository.findById(dto.getAccountId());
        Optional<Movie> findMovie = movieRepository.findById(dto.getMovieId());

        if(findMovie.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("적절하지 않은 movieId 입니다");
        }
        RatingBoard ratingBoard = dto.toWriteEntity(findMovie.get(), findMember.get());
        ratingBoardRepository.save(ratingBoard);
        return ResponseEntity.status(HttpStatus.OK).body(ratingBoard.toDTO(false)); //default == false;
    }

    @Override
    public ResponseEntity updateRatingBoard(RatingBoardDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity deleteRatingBoard(Long ratingBoardId) {
        Optional<RatingBoard> findRatingBoard = ratingBoardRepository.findById(ratingBoardId);

        if(findRatingBoard.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("적절하지 않은 접근입니다.");
        }

        ratingBoardLikeRepository.deleteAll(findRatingBoard.get().getRatingBoardLikeList());
        ratingBoardRepository.delete(findRatingBoard.get());

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
