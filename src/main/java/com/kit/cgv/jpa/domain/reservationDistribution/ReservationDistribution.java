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
    private Long advanceCode;

    @Column
    private Double man;

    @OneToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    @Column
    private Double woman;

    @Column
    private Double ten;

    @Column
    private Double twenty;

    @Column
    private Double thirty;

    @Column
    private Double forty;

    @Column
    private Double fifty;
}
