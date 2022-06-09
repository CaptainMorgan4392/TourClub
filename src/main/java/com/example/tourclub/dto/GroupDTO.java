package com.example.tourclub.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Setter
@Builder
@JsonDeserialize(builder = GroupDTO.GroupDTOBuilder.class)
public class GroupDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sport")
    private Integer sport;

    @JsonProperty("coach")
    private Integer coach;

    @JsonProperty("timetable")
    private String timetable;

}
