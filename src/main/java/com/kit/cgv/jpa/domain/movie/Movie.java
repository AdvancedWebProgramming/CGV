package com.kit.cgv.jpa.domain.movie;

import com.kit.cgv.dto.movie.MovieDTO;
import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.movieposter.MoviePoster;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoard;
import com.kit.cgv.jpa.domain.screen.Screen;
import com.kit.cgv.jpa.domain.trailer.Trailer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Movie extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long movieId;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "RATE")
    private String rate;//상영등급
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "RUNTIME")
    private Long runtime;
    @Column(name = "OPENING_DATE")
    private LocalDate openingDate;
    @Column(name = "CLOSING_DATE")
    private LocalDate closingDate;
    @Column(name = "WATCHER_COUNT")
    private Long watcherCount;//관람객수

    @Column(name = "EVALUATION_RATE")
    private Double evaluationRate;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;//부가설명

    @OneToOne
    @JoinColumn(name = "MOVIE_POSTER_ID")
    private MoviePoster moviePoster;

    @Column(name = "SALE_RATE")
    private Double saleRate;//예매율

    @Column(name = "DIRECTORS")
    private String directors;

    @Column(name = "ACTORS")//length 디폴트가 255라고 되어있어서 뺌, 확실하지 않음
    private String actors;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY )
    private List<Screen> screens  = new LinkedList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Trailer> trailers  = new LinkedList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<RatingBoard> ratingBoards  = new LinkedList<>();

    public MovieDTO toDTO(){
        return MovieDTO.builder()
                .actors(Arrays.stream(actors.split(", ")).collect(Collectors.toList()))
                .description(description)
                .directors(Arrays.stream(directors.split(", ")).collect(Collectors.toList()))
                .movieId(movieId)
                .evaluationRate(evaluationRate)
                .openingDate(String.format("%d.%d.%d", openingDate.getYear(), openingDate.getMonthValue(), openingDate.getDayOfMonth()))
                .runtime(runtime)
                .title(title)
                .genre(Arrays.stream(genre.split(", ")).collect(Collectors.toList()))
                .moviePosterId(moviePoster.getId())
                .saleRate(saleRate).build();
    }
}
