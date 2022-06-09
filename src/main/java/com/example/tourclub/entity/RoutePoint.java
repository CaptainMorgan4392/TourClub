package com.example.tourclub.entity;

import com.example.tourclub.dto.RoutePointDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "stop_point")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoutePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public RoutePoint(RoutePointDTO routePointDTO) {
        this.setId(routePointDTO.getId());
        this.setName(routePointDTO.getName());
    }

}
