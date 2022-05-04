package com.kit.cgv.jpa.domain.user;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="STRING_ID", nullable = false)
    private String stringId;

    @Column(name="NICKNAME", nullable = false)
    private String nickname;

}
