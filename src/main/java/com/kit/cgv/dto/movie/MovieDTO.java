package com.kit.cgv.dto.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kit.cgv.dto.poster.PosterDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {
    private Long movieId;
    private String name;
    private List<PosterDTO> poster;
    private String genre;
    private String rate;
}
