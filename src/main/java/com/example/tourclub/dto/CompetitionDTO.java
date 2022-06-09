package com.example.tourclub.dto;

import com.example.tourclub.entity.Competition;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Setter
@Builder
@JsonDeserialize(builder = CompetitionDTO.CompetitionDTOBuilder.class)
public class CompetitionDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sport")
    private Integer sport;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("place")
    private String place;

    @JsonProperty("payment")
    private Integer payment;

    @JsonProperty("supervisor")
    private Integer supervisor;

}
