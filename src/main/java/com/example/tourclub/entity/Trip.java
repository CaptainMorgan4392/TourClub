package com.example.tourclub.entity;

import com.example.tourclub.dto.TripDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Date date;

    @Column
    private String category;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "days_count")
    private Integer daysCount;

    @Column
    private Integer difficulty;

    @Column(name = "max_participants")
    private Integer maxParticipants;

    @Column
    private String type;

    @Column(name = "physical_level")
    private String physicalLevel;

    @Column
    private Integer gid;

    public Trip(TripDTO tripDTO) {
        this.setName(tripDTO.getName());
        this.setDate(tripDTO.getDate());
        this.setCategory(tripDTO.getCategory());
        this.setRouteId(tripDTO.getRouteId());
        this.setDaysCount(tripDTO.getDaysCount());
        this.setDifficulty(tripDTO.getDifficulty());
        this.setMaxParticipants(tripDTO.getMaxParticipants());
        this.setType(tripDTO.getType());
        this.setPhysicalLevel(tripDTO.getPhysicalLevel());
        this.setGid(tripDTO.getGid());
    }

}
