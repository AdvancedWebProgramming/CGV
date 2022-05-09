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
    private int advanceCode;

    @Column
    private double man;

    @OneToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    @Column
    private double woman;

    @Column
    private double ten;

    @Column
    private double twenty;

    @Column
    private double thirty;

    @Column
    private double forty;

    @Column
    private double fifty;
}
