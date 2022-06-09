package com.example.tourclub.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Setter
@Builder
@JsonDeserialize(builder = RoutePointDTO.RoutePointDTOBuilder.class)
public class RoutePointDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

}
