package com.kit.cgv.dto.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {
    private Long movieId;
    private String title;
    private Long runtime;
    private String openingDate;
    private Double evaluationRate;
    private String description;
    private List<String> directors = new LinkedList<>();
    private List<String> actors = new LinkedList<>();
    private Double saleRate;
    private Long moviePosterId;
    private List<String> genre = new LinkedList<>();
}
