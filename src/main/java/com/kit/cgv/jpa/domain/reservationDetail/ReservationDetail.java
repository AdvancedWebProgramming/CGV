package com.kit.cgv.jpa.domain.reservationDetail;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
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
    @Column(name = "RESERVATION_DETAIL_ID")
    private Long reservationDetailID;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Long reservationID;

    @Column(name = "ROW_NUM")
    private Long rowNum;
    @Column(name = "COLUMN_NUM")
    private Long columnNum;
}
