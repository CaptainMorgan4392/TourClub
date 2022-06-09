package com.example.tourclub.dto;

import com.example.tourclub.entity.Trip;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Setter
@Builder
@JsonDeserialize(builder = TripDTO.TripDTOBuilder.class)
public class TripDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("category")
    private String category;

    @JsonProperty("routeId")
    private Integer routeId;

    @JsonProperty("daysCount")
    private Integer daysCount;

    @JsonProperty("difficulty")
    private Integer difficulty;

    @JsonProperty("maxParticipants")
    private Integer maxParticipants;

    @JsonProperty("type")
    private String type;

    @JsonProperty("physicalLevel")
    private String physicalLevel;

    @JsonProperty("gid")
    private Integer gid;

}
