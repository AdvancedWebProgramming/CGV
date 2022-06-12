package com.kit.cgv.dto.screendetail;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScreenDetailUpdateDTO {
    private Long screen_detail_id;
    private Long discount;
    private Long fixedrate;
}
