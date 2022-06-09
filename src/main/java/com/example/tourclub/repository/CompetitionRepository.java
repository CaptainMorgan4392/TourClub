package com.example.tourclub.repository;

import com.example.tourclub.entity.Competition;
import com.example.tourclub.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

    List<Competition> findAll();


    List<Competition> findAllByIdIn(List<Integer> ids);

}
