package com.kit.cgv.jpa.domain.member;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Manager extends BaseTimeEntity {
    @Id
    @Column(name="MANAGER_ID")
    private String managerId;

    @Column(name="PASSWORD")
    private String password;
}
