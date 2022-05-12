package com.kit.cgv.jpa.domain.theater;

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

public class Theater extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_NUM", nullable = false)
    private Long theaterNum;//상영관번호
    @Column(name = "ROW", nullable = false)
    private Long rowMany;//행수
    @Column(name = "COLUMN", nullable = false)
    private Long columnMany;//열수
}
