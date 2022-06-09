package com.example.tourclub.controller;

import com.example.tourclub.projection.CoachProjection;
import com.example.tourclub.service.UserService;
import com.example.tourclub.token.Base64AuthenticationToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/coach")
public class CoachController {
    @Autowired
    UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/fetchCoaches")
    public ResponseEntity<List<CoachProjection>> fetchCoaches(
        @RequestHeader("Authorization") String stringOfToken
    )  throws JsonProcessingException {
        if (!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))) {
            return new ResponseEntity<>(
                List.of(),
                HttpStatus.UNAUTHORIZED
            );
        }
        String sql="select id, name, surname, patronymic " +
            "from system_user where id in (select system_user_id from coach)";

        return new ResponseEntity<>(
            new ArrayList<>(
                new HashSet<>(
                    jdbcTemplate.query(
                        sql,
                        (rs, rowNum) -> new CoachProjection(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("patronymic")
                        )
                    )
                )
            ).stream().collect(Collectors.toList()),
            HttpStatus.OK
        );
    }
}
