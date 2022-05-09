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
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column
    private Double advanceSaleRate;

    @Column
    private Timestamp releaseDate;

    @Lob
    private String photo;

    @Column
    private String directors;

    @Column(length = 255)
    private String actors;

    @Column
    private String genres;

    @Lob
    private String trailer;

    @Lob
    private String description;

    @Column
    private Double grade;
}
