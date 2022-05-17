package com.kit.cgv.jpa.domain.trailer;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TRAILER")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Trailer extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAILER_ID")
    private Long id;

    @Column(name="PATH",nullable = false)
    private String path;

    @Column(name="TYPE", nullable = false)
    private String type;

    @JoinColumn(name = "MOVIE_ID")
    @ManyToOne
    private Movie movie;
}
