package com.example.tourclub.repository;

import com.example.tourclub.entity.Competition;
import com.example.tourclub.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<Group> findAll();

    List<Group> findAllByIdIn(List<Integer> ids);
}
