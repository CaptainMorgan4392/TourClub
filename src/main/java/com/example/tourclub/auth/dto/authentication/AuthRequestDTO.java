package com.example.tourclub.auth.dto.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class AuthRequestDTO {

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

}
