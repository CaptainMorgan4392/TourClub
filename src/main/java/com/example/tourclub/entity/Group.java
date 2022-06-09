package com.example.tourclub.entity;

import com.example.tourclub.dto.GroupDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "section_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String number;

    @Column
    private String name;

    @Column(name = "sport_id")
    private Integer sportId;

    @Column(name = "coach_id")
    private Integer coachId;

    @Column
    private String timetable;

    public Group(GroupDTO groupDTO) {
        this.setId(groupDTO.getId());
        this.setNumber(groupDTO.getNumber());
        this.setName(groupDTO.getName());
        this.setSportId(groupDTO.getSport());
        this.setCoachId(groupDTO.getCoach());
        this.setTimetable(groupDTO.getTimetable());
    }

}
