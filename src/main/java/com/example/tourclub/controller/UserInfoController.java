package com.example.tourclub.controller;

import com.example.tourclub.dto.TripDTO;
import com.example.tourclub.dto.TripResponseDTO;
import com.example.tourclub.dto.UserResponseDTO;
import com.example.tourclub.entity.Competition;
import com.example.tourclub.entity.Group;
import com.example.tourclub.entity.Trip;
import com.example.tourclub.service.UserService;
import com.example.tourclub.token.Base64AuthenticationToken;
import com.example.tourclub.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/getInfo")
    public ResponseEntity<UserResponseDTO> getUserInfoByToken(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        UserResponseDTO userResponseDTO = userInfoService.getUserInfoByToken(
            Base64AuthenticationToken.deserialize(stringOfToken)
        );

        return new ResponseEntity<>(
            userResponseDTO,
            userResponseDTO == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK
        );
    }

}
