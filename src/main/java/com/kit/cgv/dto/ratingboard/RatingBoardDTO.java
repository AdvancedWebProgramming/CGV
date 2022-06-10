package com.kit.cgv.dto.ratingboard;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoard;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingBoardDTO {
    private Long ratingBoardId;
    private String content;
    private Long accountId;
    private String accountLoginId;
    private String name;
    private Double grade;
    private String title;
    private Long movieId;
    private Long likeCount;
    private Boolean isLiked;
    private Boolean isGood;


    public RatingBoard toWriteEntity(Movie movie, Member member){
        return RatingBoard.builder()
                .writer(member)
                .likeCount(0L)
                .grade(grade)
                .content(content)
                .isGood(isGood)
                .movie(movie).build();
    }
}
