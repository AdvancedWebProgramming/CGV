package com.kit.cgv.jpa.domain.reservationdetail;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.reservation.Reservation;
import com.kit.cgv.jpa.domain.seat.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReservationDetail extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_DETAIL_ID", nullable = false)
    private Long reservationDetailID;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID", nullable = false)
    private Reservation reservationID;

    @OneToOne
    @JoinColumn(name="SEAT_ID", nullable = false)
    private Seat seat;
}
