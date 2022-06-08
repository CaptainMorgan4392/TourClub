package com.example.tourclub.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping(value = "/getTripsCount")
    public ResponseEntity<Integer> getTripsCount(
        @RequestHeader("Authorization") String stringOfToken
    ) {

    }

}
