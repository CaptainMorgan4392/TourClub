package com.example.tourclub.auth.token;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class Base64AuthenticationToken implements Encodable {

    private static final int ENCODE_LOOPS = 3;

    @JsonProperty("email")
    private String email;

    @Override
    public Base64AuthenticationToken encode() {
        String result = this.email;

        for (int i = 0; i < ENCODE_LOOPS; ++i) {
            result = Arrays.toString(Base64.getEncoder().encode(result.getBytes(StandardCharsets.UTF_8)));
        }

        this.setEmail(result);

        return this;
    }

    @Override
    public Base64AuthenticationToken decode() {
        String result = this.email;

        for (int i = 0; i < ENCODE_LOOPS; ++i) {
            result = Arrays.toString(Base64.getDecoder().decode(result.getBytes(StandardCharsets.UTF_8)));
        }

        this.setEmail(result);

        return this;
    }

    public static Base64AuthenticationToken deserialize(String stringOfToken) throws JsonProcessingException {
        if (stringOfToken == null) {
            return null;
        }

        return new ObjectMapper().readValue(stringOfToken, Base64AuthenticationToken.class);
    }

}
