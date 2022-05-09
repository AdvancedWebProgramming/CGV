package com.kit.cgv.jpa.domain.movie;

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

public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movieID;
    @Column(name = "TITLE")
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
    @Column(name = "ETC")
    private String etc;//부가설명
}
