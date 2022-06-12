package com.kit.cgv.jpa.domain.ratingboard;

import com.kit.cgv.dto.ratingboard.RatingBoardDTO;
import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.ratingboardlike.RatingBoardLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Table(name="RATINGBOARD")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Getter
public class RatingBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATING_BOARD_ID")
    private Long ratingBoardId;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "WRITER_ID", nullable = false)
    private Member writer;

    @Column(name = "IS_GOOD", nullable = false)
    private Boolean isGood;

    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "LIKE_COUNT", nullable = false)
    private Long likeCount;



    @OneToMany(mappedBy = "ratingBoard")
    private List<RatingBoardLike> ratingBoardLikeList = new LinkedList<>();

    public void increaseLikeCount(){
        likeCount++;
    }
    public void decreaseLikeCount(){
        likeCount--;
    }

    public RatingBoardDTO toDTO(Boolean isLiked){
        return RatingBoardDTO.builder()
                .ratingBoardId(ratingBoardId)
                .name(writer.getName())
                .accountId(writer.getMemberID())
                .movieId(movie.getMovieId())
                .isLiked(isLiked)
                .content(content)
                .build();
    }
}
