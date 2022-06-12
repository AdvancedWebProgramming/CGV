package com.kit.cgv.dto.screendetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScreenDetailDTO {
    private Long screen_detail_id;
    private Long movie_id;
    private Long theater;
    private String time;
    private Long seat;
}
