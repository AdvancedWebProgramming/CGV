package com.kit.cgv.jpa.domain.theater;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.seat.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Theater extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_Id", nullable = false)
    private Long theaterId;//상영관번호
    @Column(name = "ROW", nullable = false)
    private Long rowMany;//행수
    @Column(name = "COLUMN", nullable = false)
    private Long columnMany;//열수

    @OneToMany(mappedBy = "seatId")
    private List<Seat> seats = new LinkedList<>();
}
