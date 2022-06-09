package com.example.tourclub.controller;

import com.example.tourclub.projection.SportProjection;
import com.example.tourclub.repository.SportJdbcRepository;
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

@RestController
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    UserService userService;

    @Autowired
    SportJdbcRepository sportJdbcRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/fetchSports")
    public ResponseEntity<List<SportProjection>> fetchSports(
        @RequestHeader("Authorization") String stringOfToken
    )  throws JsonProcessingException  {
        if (!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))) {
            return new ResponseEntity<>(
                List.of(),
                HttpStatus.UNAUTHORIZED
            );
        }
        String sql="select s.* from sport s";
        return new ResponseEntity<>(
            new ArrayList<>(
                new HashSet<>(
                    jdbcTemplate.query(
                        sql,
                        (
                            (rs, rowNum) -> new SportProjection(
                                rs.getInt("id"),
                                rs.getString("name")
                            )
                        )
                    )
                )
            ).stream().toList(),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/fetchSportsWithoutSections")
    public List<SportProjection> getSportsWithoutSection() {
        return sportJdbcRepository.getSportsWithoutSection();
    }

}
