package com.kit.cgv.jpa.domain.member;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Member extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberID;
    @Column(name = "MEMBER_StringID", nullable = false)
    private String memberStringID;
    @Column(name = "MEMBER_PWD", nullable = false)
    private String memberPWD;
    @Column(name ="NICKNAME", nullable = false)
    private String nickname;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name = "REGISTER_DAY")
    private LocalDate registerDay;//가입일
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MANAGEMENT")
    private boolean management;//관리자 권한
}
