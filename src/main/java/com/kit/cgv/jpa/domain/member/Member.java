package com.kit.cgv.jpa.domain.member;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoard;
import com.kit.cgv.jpa.domain.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberID;
    @Column(name = "MEMBER_LOGIN_ID", nullable = false)
    private String memberLoginID;
    @Column(name = "MEMBER_PWD", nullable = false)
    private String memberPWD;
    @Column(name ="NAME", nullable = false)
    private String name;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Reservation> reservations  = new LinkedList<>();

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<RatingBoard> ratingBoards  = new LinkedList<>();
}
