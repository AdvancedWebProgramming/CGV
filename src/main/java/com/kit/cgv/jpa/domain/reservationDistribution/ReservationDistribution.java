package com.kit.cgv.jpa.domain.reservationDistribution;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.moive.Movie;
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
    @Column(name = "RESERVATION_DISTRIBUTION")
    private Long advanceCode;

    @Column(name = "MAN")
    private Double man;

    @OneToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @Column(name = "WOMAN")
    private Double woman;

    @Column(name = "TEN")
    private Double ten;

    @Column(name = "TWENTY")
    private Double twenty;

    @Column(name = "THIRTY")
    private Double thirty;

    @Column(name = "FORTY")
    private Double forty;

    @Column(name = "FIFTY")
    private Double fifty;
}
