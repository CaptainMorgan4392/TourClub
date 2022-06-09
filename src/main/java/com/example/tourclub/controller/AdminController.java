package com.example.tourclub.controller;

import com.example.tourclub.dto.*;
import com.example.tourclub.entity.*;
import com.example.tourclub.service.AdminService;
import com.example.tourclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @PostMapping(value = "/trips/fetch")
    public ResponseEntity<List<TripResponseDTO>> getTrips() {
        return new ResponseEntity<>(
            adminService.getTrips(),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/trips/create")
    public ResponseEntity<List<TripResponseDTO>> createTrip(@RequestBody TripDTO tripDTO) {
        return new ResponseEntity<>(
            adminService.createTrip(tripDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/trips/update")
    public ResponseEntity<List<TripResponseDTO>> updateTrip(@RequestBody TripDTO tripDTO) {
        return new ResponseEntity<>(
            adminService.updateTrip(tripDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/trips/delete")
    public ResponseEntity<List<TripResponseDTO>> deleteTrip(@RequestBody DeleteByIdDTO deleteByIdDTO) {
        return new ResponseEntity<>(
            adminService.deleteTrip(deleteByIdDTO.getId()),
            HttpStatus.OK
        );
    }





    @PostMapping(value = "/users/fetch")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return new ResponseEntity<>(
            adminService.getUsers(),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/users/create")
    public ResponseEntity<List<UserResponseDTO>> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(
            adminService.createUser(userDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/users/update")
    public ResponseEntity<List<UserResponseDTO>> updateUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(
            adminService.updateUser(userDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/users/delete")
    public ResponseEntity<List<UserResponseDTO>> deleteUser(@RequestBody DeleteByIdDTO deleteByIdDTO) {
        return new ResponseEntity<>(
            adminService.deleteUser(deleteByIdDTO.getId()),
            HttpStatus.OK
        );
    }





    @PostMapping(value = "/competitions/fetch")
    public ResponseEntity<List<CompetitionResponseDTO>> getCompetitions() {
        return new ResponseEntity<>(
            adminService.getCompetitions(),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/competitions/create")
    public ResponseEntity<List<CompetitionResponseDTO>> createCompetition(@RequestBody CompetitionDTO competitionDTO) {
        return new ResponseEntity<>(
            adminService.createCompetition(competitionDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/competitions/update")
    public ResponseEntity<List<CompetitionResponseDTO>> updateCompetition(@RequestBody CompetitionDTO competitionDTO) {
        return new ResponseEntity<>(
            adminService.updateCompetition(competitionDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/competitions/delete")
    public ResponseEntity<List<CompetitionResponseDTO>> deleteCompetition(@RequestBody DeleteByIdDTO deleteByIdDTO) {
        return new ResponseEntity<>(
            adminService.deleteCompetition(deleteByIdDTO.getId()),
            HttpStatus.OK
        );
    }






    @PostMapping(value = "/groups/fetch")
    public ResponseEntity<List<GroupResponseDTO>> getGroups() {
        return new ResponseEntity<>(
            adminService.getGroups(),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/groups/create")
    public ResponseEntity<List<GroupResponseDTO>> createGroup(@RequestBody GroupDTO groupDTO) {
        return new ResponseEntity<>(
            adminService.createGroup(groupDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/groups/update")
    public ResponseEntity<List<GroupResponseDTO>> updateGroup(@RequestBody GroupDTO groupDTO) {
        return new ResponseEntity<>(
            adminService.updateGroup(groupDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/groups/delete")
    public ResponseEntity<List<GroupResponseDTO>> deleteGroup(@RequestBody DeleteByIdDTO deleteByIdDTO) {
        return new ResponseEntity<>(
            adminService.deleteGroup(deleteByIdDTO.getId()),
            HttpStatus.OK
        );
    }





    @PostMapping(value = "/routePoints/fetch")
    public ResponseEntity<List<RoutePointResponseDTO>> getRoutePoints() {
        return new ResponseEntity<>(
            adminService.getRoutePoints(),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/routePoints/create")
    public ResponseEntity<List<RoutePointResponseDTO>> createRoutePoint(@RequestBody RoutePointDTO routePointDTO) {
        return new ResponseEntity<>(
            adminService.createRoutePoint(routePointDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/routePoints/update")
    public ResponseEntity<List<RoutePointResponseDTO>> updateRoutePoint(@RequestBody RoutePointDTO routePointDTO) {
        return new ResponseEntity<>(
            adminService.updateRoutePoint(routePointDTO),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/routePoints/delete")
    public ResponseEntity<List<RoutePointResponseDTO>> deleteRoutePoint(@RequestBody DeleteByIdDTO deleteByIdDTO) {
        return new ResponseEntity<>(
            adminService.deleteRoutePoint(deleteByIdDTO.getId()),
            HttpStatus.OK
        );
    }





    @PostMapping(value = "/users/fetchUsersMoreThanOneTrip")
    public List<UserResponseDTO> fetchUsersWithMoreThanOneTrip() {
        return userService.getUsersWithMoreThanOneTrips();
    }

}
