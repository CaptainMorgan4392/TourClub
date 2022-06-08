package com.example.tourclub.trip;

import com.example.tourclub.trip.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/trips")
public class TripController {

    @Autowired
    TripService tripService;

    @PostMapping(value = "/getTrips")
    public ResponseEntity<List<TripDTO>> getAllTrips() {
        return new ResponseEntity<>(
            tripService.getAllTrips(),
            HttpStatus.OK
        );
    }

}
