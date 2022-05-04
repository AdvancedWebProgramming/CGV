package com.kit.cgv.pbh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private String memberID;
    @Column(name = "MEMBER_PWD")
    private String memberPWD;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "REGISTER_DAY")
    private Date registerDay;//가입일
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MANAGEMENT")
    private boolean management;//관리자 권한
}
