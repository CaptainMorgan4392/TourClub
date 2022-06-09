package com.example.tourclub.repository;

import com.example.tourclub.entity.RoutePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutePointRepository extends JpaRepository<RoutePoint, Integer> {

    List<RoutePoint> findAll();

}
