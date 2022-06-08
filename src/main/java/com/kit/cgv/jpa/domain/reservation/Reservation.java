package com.kit.cgv.jpa.domain.reservation;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.screen.Screen;
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

public class Reservation extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID", nullable = false)
    private Long reservationID;// 예매번호

    @ManyToOne
    @JoinColumn(name = "SCREEN_ID", nullable = false)
    private Screen screen; // 상영번호

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "COUNT", nullable = false)
    private Long count;//인원수
    @Column(name = "SCREEN_NUM", nullable = false)
    private Long screenNum;//상영회차(영화 몇번째(시작시간, 끝시간 순서))
    @Column(name = "PRICE", nullable = false)
    private Long price;

}
