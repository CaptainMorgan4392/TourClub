package com.example.tourclub.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private Date date;

    @Column
    private String category;

    @Column
    private Integer routeId;

    @Column
    private Integer duration;

    @Column
    private Integer difficulty;

    @Column
    private Integer maxParticipants;

    @Column
    private String type;

    @Column
    private String physicalLevel;

    @Column
    private String status;

    @Column
    private Integer gid;

}
