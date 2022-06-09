package com.kit.cgv.jpa.domain.ratingboard;

import javax.persistence.*;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.member.Member;

import com.kit.cgv.jpa.domain.movie.Movie;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Table(name="RATINGBOARD")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
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

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ColumnDefault("0")
    @Column(name = "LIKE_COUNT", nullable = false)
    private Long likeCount;

    @Column(name = "GRADE")
    private Double grade;
}
