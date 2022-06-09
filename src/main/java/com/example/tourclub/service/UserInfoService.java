package com.example.tourclub.service;

import com.example.tourclub.dto.UserResponseDTO;
import com.example.tourclub.token.Base64AuthenticationToken;
import com.example.tourclub.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public UserResponseDTO getUserInfoByToken(Base64AuthenticationToken token) {
        if (token == null) {
            return null;
        }

        return userInfoRepository.findByEmail(token.getEmail())
            .map(user -> new UserResponseDTO(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getPatronymic(),
                new SimpleDateFormat("yyyy-MM-dd")
                    .format(user.getBirthday()),
                user.getPhone(),
                user.getEmail(),
                user.getGender(),
                user.getRole()
            )).orElse(null);
    }

}
