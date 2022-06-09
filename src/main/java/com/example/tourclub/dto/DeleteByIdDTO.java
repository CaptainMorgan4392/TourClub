package com.example.tourclub.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
@JsonDeserialize(builder = DeleteByIdDTO.DeleteByIdDTOBuilder.class)
public class DeleteByIdDTO {

    @JsonProperty("id")
    private Integer id;

}
