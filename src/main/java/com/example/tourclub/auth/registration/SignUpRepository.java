package com.example.tourclub.auth.registration;

import com.example.tourclub.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);

    Optional<User> findByPhone(String phone);

}
