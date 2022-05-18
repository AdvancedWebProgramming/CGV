package com.kit.cgv.jpa.domain.member;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;



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
}
