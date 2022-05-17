package com.kit.cgv.jpa.domain.seat;


import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.theater.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="SEAT")
public class Seat extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SEAT_ID")
    private Long seatId;

    @Column(name="ROW_NUM")
    private Long rowNum;

    @Column(name="COL_NUM")
    private Long colNum;

    @Column(name="IS_ABLE")
    private Boolean isAble; //쓸수 있다 없다.

    @Column(name="SEAT_DESCRIPTION") //못쓰는 이유.
    private String seatDescription;

    @JoinColumn(name="Theater")
    @ManyToOne
    private Theater theater;

}
