package com.example.tourclub.controller;

import com.example.tourclub.projection.RouteProjection;
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
@RequestMapping(value = "/route")
public class RouteController {
    @Autowired
    UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/fetchRoutes")
    public ResponseEntity<List<RouteProjection>> fetchCoaches(
        @RequestHeader("Authorization") String stringOfToken
    )  throws JsonProcessingException {
        if (!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))) {
            return new ResponseEntity<>(
                List.of(),
                HttpStatus.UNAUTHORIZED
            );
        }
        String sql="select r.* from route r";
        return new ResponseEntity<>(
            new ArrayList<>(
                new HashSet<>(
                    jdbcTemplate.query(
                        sql,
                        ((rs, rowNum) -> new RouteProjection(
                            rs.getInt("id"),
                            rs.getString("name")
                        ))
                    )
                )
            ).stream().toList(),
            HttpStatus.OK
        );
    }
}
