package com.kit.cgv.jpa.domain.reservation;

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

public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationID;// 예매번호

    @ManyToOne
    @JoinColumn(name = "SCREEN_ID")
    private Long screenID; // 상영번호

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private String memberID;

    @Column(name = "COUNT")
    private Long count;//인원수
    @Column(name = "SCREEN_NUM")
    private Long screenNum;//상영회차(영화 몇번째(시작시간, 끝시간 순서))
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PRICE")
    private Long price;
}
