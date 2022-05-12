package com.kit.cgv.jpa.domain.movie;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.trailer.Trailer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Movie extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long movieID;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "RATE")
    private String rate;//상영등급
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "RUNTIME")
    private String runtime;
    @Column(name = "OPENING_DATE")
    private LocalDate openingDate;
    @Column(name = "CLOSING_DATE")
    private LocalDate closingDate;
    @Column(name = "WATCHER_COUNT")
    private Long watcherCount;//관람객수

    //moive에서 따온것들
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;//부가설명
    @Lob
    @Column(name = "PHOTO")
    private String photo;
    @Lob
    @Column(name = "TRAILER")
    private Trailer trailer;
    @Column(name = "GRADE")
    private Double grade;
    @Column(name = "ADVANCE_SALE_RATE")
    private Double advanceSaleRate;//뭔지모르겠음
    @Column(name = "DIRECTORS")
    private String directors;
    @Column(name = "ACTORS")//length 디폴트가 255라고 되어있어서 뺌, 확실하지 않음
    private String actors;


}
