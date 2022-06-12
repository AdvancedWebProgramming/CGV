package com.kit.cgv.jpa.domain.screendetail;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.screen.Screen;
import com.kit.cgv.jpa.domain.theater.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ScreenDetail extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_DETAIL_ID", nullable = false)
    private Long screenDetailID;

    @ManyToOne
    @JoinColumn(name = "SCREEN_ID", nullable = false)
    private Screen screen;

    @Column(name = "SCREEN_NUM" , nullable = false)
    private Long screenNum;//상영회차

    @OneToOne
    @JoinColumn(name = "THEATER_ID" , nullable = false)
    private Theater theater;//상영관번호

    @Column(name= "SCREEN_TIME" , nullable = false)
    private LocalTime screenTime; //상영시간


    @Column(name = "PEOPLE" , nullable = false)
    private Long people;//관람객수

    @Column(name = "FIXED_RATE")
    private Long fixedRate;

    @Column(name = "DISCOUNT")
    private Long discount;

    @Column(name = "SEAT")
    private Long seat; //남은 좌석 수

    public void addPeople(Long people){
        this.people = people;
    }

    public void minusSeat(Long seat) { this.seat -= seat;}
    public void plusSeat(Long seat) { this.seat += seat;}
}
