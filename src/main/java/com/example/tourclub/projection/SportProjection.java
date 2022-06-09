package com.example.tourclub.projection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class SportProjection {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

}
