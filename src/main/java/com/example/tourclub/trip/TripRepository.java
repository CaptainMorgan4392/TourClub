package com.example.tourclub.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip, Integer> {

    List<Trip> findAll();

}
