package com.example.tourclub.dto;

import com.example.tourclub.entity.RoutePoint;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoutePointResponseDTO {

    private Integer id;

    private String name;

    public RoutePointResponseDTO(RoutePoint routePoint) {
        this.setId(routePoint.getId());
        this.setName(routePoint.getName());
    }

}
