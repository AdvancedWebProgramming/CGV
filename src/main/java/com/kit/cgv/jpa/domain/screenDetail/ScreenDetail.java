package com.kit.cgv.jpa.domain.screenDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ScreenDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "SCREEN_ID")
    private Long screenID;

    @Column(name = "SCREEN_NUM")
    private Long screenNum;//상영회차

    private int theaterNum;//상영관번호
    @Column(name= "SCREEN_TIME")
    private Time screenTime; //상영시간
    @Column(name = "PEOPLE")
    private Long people;//관람객수
}
