package com.example.tourclub.dto;

import com.example.tourclub.entity.Trip;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TripResponseDTO {

    private Integer id;

    private String name;

    private String date;

    private String category;

    private Integer routeId;

    private Integer daysCount;

    private Integer difficulty;

    private Integer maxParticipants;

    private String type;

    private String physicalLevel;

    private Integer gid;

    public TripResponseDTO(Trip trip) {
        this.setId(trip.getId());
        this.setName(trip.getName());
        this.setDate(
            new SimpleDateFormat("yyyy-MM-dd")
                .format(trip.getDate())
        );
        this.setCategory(trip.getCategory());
        this.setRouteId(trip.getRouteId());
        this.setDaysCount(trip.getDaysCount());
        this.setDifficulty(trip.getDifficulty());
        this.setMaxParticipants(trip.getMaxParticipants());
        this.setType(trip.getType());
        this.setPhysicalLevel(trip.getPhysicalLevel());
        this.setGid(trip.getGid());
    }

}
