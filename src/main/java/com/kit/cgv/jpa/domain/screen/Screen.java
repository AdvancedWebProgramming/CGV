package com.kit.cgv.jpa.domain.screen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Screen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long screenID;//상영id
    @Column(name = "SCREEN_DATE")
    private LocalDate screenDate;
    @Column(name = "MOVIE_ID")
    private Long movieID;
}
