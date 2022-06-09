package com.example.tourclub.entity;

import com.example.tourclub.dto.CompetitionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "competition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer sport;

    @Column
    private Date date;

    @Column
    private String place;

    @Column
    private Integer payment;

    @Column
    private Integer supervisor;

    public Competition(CompetitionDTO competitionDTO) {
        this.setId(competitionDTO.getId());
        this.setName(competitionDTO.getName());
        this.setSport(competitionDTO.getSport());
        this.setDate(competitionDTO.getDate());
        this.setPlace(competitionDTO.getPlace());
        this.setPayment(competitionDTO.getPayment());
        this.setSupervisor(competitionDTO.getSupervisor());
    }

}
