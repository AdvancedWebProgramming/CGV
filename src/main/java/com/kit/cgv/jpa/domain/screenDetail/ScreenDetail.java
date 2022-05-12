package com.kit.cgv.jpa.domain.screenDetail;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ScreenDetail extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "SCREEN_ID")
    private Long screenID;

    @Column(name = "SCREEN_NUM")
    private Long screenNum;//상영회차

    private int theaterNum;//상영관번호
    @Column(name= "SCREEN_TIME")
    private LocalTime screenTime; //상영시간
    @Column(name = "PEOPLE")
    private Long people;//관람객수
}
