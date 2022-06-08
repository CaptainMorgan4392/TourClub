package com.example.tourclub.auth.userInfo;

import com.example.tourclub.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
