package com.example.tourclub.auth.dto.token;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class TokenResponseDTO {

    @JsonProperty("email")
    private String email;

}
