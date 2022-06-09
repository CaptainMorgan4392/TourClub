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

    @Autowired
    UserService userService;

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

    @PostMapping(value = "/getTrips")
    public ResponseEntity<List<TripResponseDTO>> getUserTripsByToken(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        if (!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))) {
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.getTrips(mail),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/getCompetitions")
    public ResponseEntity<List<Competition>> getCompetitionsByToken(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.getCompetitions(mail),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/getGroups")
    public ResponseEntity<List<Group>> getGroupByToken(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.getGroups(mail),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/applyGroup")
    public ResponseEntity<List<Group>> applyUserToGroup(
        @RequestHeader("Authorization") String stringOfToken,
        @RequestBody Group group
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        Integer id = group.getId();
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.applyUserToGroup(mail, id),
            HttpStatus.OK
        );
    }
    @PostMapping(value = "/applyCompetition")
    public ResponseEntity<List<Competition>> applyUserToCompetition(
        @RequestHeader("Authorization") String stringOfToken,
        @RequestBody Competition competition
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        Integer id = competition.getId();
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.applyUserToCompetition(mail, id),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/applyTrip")
    public ResponseEntity<List<TripResponseDTO>> applyUserToTrip(
        @RequestHeader("Authorization") String stringOfToken,
        @RequestBody Trip trip
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        Integer id = trip.getId();
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.applyUserToTrip(mail, id),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/getMaxTripDifficulty")
    public ResponseEntity<Integer> getMaxTripDifficulty(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.getMaxTripDifficulty(mail),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/getTripsCount")
    public ResponseEntity<Integer> getTripsCount(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        if(!userService.isValidToken(Base64AuthenticationToken.deserialize(stringOfToken))){
            return new ResponseEntity<>(
                null,
                HttpStatus.UNAUTHORIZED
            );
        }
        String mail = userService.getMailByToken(Base64AuthenticationToken.deserialize(stringOfToken));
        return new ResponseEntity<>(
            userService.getTripsCount(mail),
            HttpStatus.OK
        );
    }
}
