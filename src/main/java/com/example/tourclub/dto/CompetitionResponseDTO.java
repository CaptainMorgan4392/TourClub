package com.example.tourclub.dto;

import com.example.tourclub.entity.Competition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.text.SimpleDateFormat;

@Getter
@Setter
@AllArgsConstructor
public class CompetitionResponseDTO {

    private Integer id;

    private String name;

    private Integer sport;

    private String date;

    private String place;

    private Integer payment;

    private Integer supervisor;

    public CompetitionResponseDTO(Competition competition) {
        this.setId(competition.getId());
        this.setName(competition.getName());
        this.setSport(competition.getSport());
        this.setDate(new SimpleDateFormat("yyyy-MM-dd").format(competition.getDate()));
        this.setPlace(competition.getPlace());
        this.setPayment(competition.getPayment());
        this.setSupervisor(competition.getSupervisor());
    }

}
