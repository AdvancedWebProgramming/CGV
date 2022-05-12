package com.kit.cgv.jpa.domain.review;

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

public class Review extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID", nullable = false)
    private Long reviewID;
    @Column(name = "MEMBER_ID", nullable = false)
    private String memberID;
    @Column(name = "RESERVATION_ID", nullable = false)
    private Long reservationID;
    @Column(name = "REVIEW_CONTENT", nullable = false)
    private String reviewContent;//리뷰내용
    @Column(name = "REVIEW_TITLE", nullable = false)
    private String reviewTitle;//리뷰제목
    @Column(name = "STAR_POINT", nullable = false)
    private Double starpoint;//리뷰점수
}