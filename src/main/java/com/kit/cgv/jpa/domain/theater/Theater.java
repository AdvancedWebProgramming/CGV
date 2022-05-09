package com.kit.cgv.jpa.domain.theater;

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
    private Long theaterNum;//상영관번호
    @Column(name = "ROW")
    private Long rowMany;//행수
    @Column(name = "COLUMN")
    private Long columnMany;//열수
}
