package com.example.tourclub.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Builder
@JsonDeserialize(builder = AuthRequestDTO.AuthRequestDTOBuilder.class)
public class AuthRequestDTO {

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

}
