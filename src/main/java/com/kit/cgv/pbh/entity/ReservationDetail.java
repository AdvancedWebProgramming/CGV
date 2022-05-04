package com.kit.cgv.pbh.entity;

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

public class ReservationDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Long reservationID;

    @Column(name = "ROW_NUM")
    private int rowNum;
    @Column(name = "COLUMN_NUM")
    private int columnNum;
}
