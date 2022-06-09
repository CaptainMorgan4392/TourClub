package com.example.tourclub.repository;

import com.example.tourclub.entity.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip, Integer> {

    List<Trip> findAll();
    List<Trip> findAllByIdIn(List<Integer> ids);
}
