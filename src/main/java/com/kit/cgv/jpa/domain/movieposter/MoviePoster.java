package com.kit.cgv.jpa.domain.movieposter;

import com.kit.cgv.dto.MoviePosterDTO;
import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="MOVIEPOSTERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MoviePoster extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MOVIE_POSTER")
    private Long id;

    @Column(name = "PATH", nullable = false)
    private String path;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @JoinColumn(name = "MOVIE_ID")
    @OneToOne
    private Movie movie;

    public MoviePosterDTO toDTO(){
        return MoviePosterDTO.builder()
                .id(id)
                .path("http://kitcapstone.iptime.org:8080/static/images/"+fileName).build();
    }
}
