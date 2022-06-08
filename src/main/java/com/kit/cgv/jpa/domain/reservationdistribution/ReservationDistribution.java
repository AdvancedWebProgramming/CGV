package com.kit.cgv.jpa.domain.reservationdistribution;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;

import com.kit.cgv.jpa.domain.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="RESERVATIONDISTRIBUTION")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReservationDistribution extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_DISTRIBUTION_ID")
    private Long reservationDistributionId;

    @Column(name = "MAN")
    private Double man;

    @OneToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @Column(name = "WOMAN")
    private Long woman;

    @Column(name = "TEN")
    private Long ten;

    @Column(name = "TWENTY")
    private Long twenty;

    @Column(name = "THIRTY")
    private Long thirty;

    @Column(name = "FORTY")
    private Long forty;

    @Column(name = "FIFTY")
    private Long fifty;
}
