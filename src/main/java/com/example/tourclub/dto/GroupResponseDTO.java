package com.example.tourclub.dto;

import com.example.tourclub.entity.Group;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupResponseDTO {

    private Integer id;

    private String number;

    private String name;

    private Integer sport;

    private Integer coach;

    private String timetable;

    public GroupResponseDTO(Group group) {
        this.setId(group.getId());
        this.setNumber(group.getNumber());
        this.setName(group.getName());
        this.setSport(group.getSportId());
        this.setCoach(group.getCoachId());
        this.setTimetable(group.getTimetable());
    }

}
