package com.kit.cgv.jpa.domain.moive;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.trailer.Trailer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="MOVIE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "ADVANCESALERATE")
    private Double advanceSaleRate;

    @Column(name = "RELEASEDATE")
    private Timestamp releaseDate;

    @Lob
    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "DIRECTORS")
    private String directors;

    @Column(name = "ACTORS", length = 255)
    private String actors;

    @Column(name = "GENRES")
    private String genres;

    @Lob
    @Column(name = "TRAILER_ID")
    private Trailer trailer;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "GRADE")
    private Double grade;
}
