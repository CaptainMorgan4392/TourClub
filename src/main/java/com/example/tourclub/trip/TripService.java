package com.example.tourclub.trip;

import com.example.tourclub.trip.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    List<TripDTO> getAllTrips() {
        return tripRepository.findAll()
            .stream()
            .map(trip -> new TripDTO(trip.getId(), trip.getName()))
            .collect(Collectors.toList());
    }

}
