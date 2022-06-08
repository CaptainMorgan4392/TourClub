package com.example.tourclub.admin;

import com.example.tourclub.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
}
