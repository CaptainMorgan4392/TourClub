package com.example.tourclub.auth.authorization;

import com.example.tourclub.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignInRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

}
