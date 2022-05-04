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

public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_NUM")
    private int theaterNum;//상영관번호
    @Column(name = "ROW")
    private int rowMany;//행수
    @Column(name = "COLUMN")
    private int columnMany;//열수
}
