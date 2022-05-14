package com.kit.cgv.jpa.domain.screen;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Screen extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID", nullable = false)
    private Long screenID;//상영id
    @Column(name = "SCREEN_DATE", nullable = false)
    private LocalDate screenDate;

    @JoinColumn(name="MOVIE_ID", nullable = false)
    @ManyToOne
    private Movie movie;
}
