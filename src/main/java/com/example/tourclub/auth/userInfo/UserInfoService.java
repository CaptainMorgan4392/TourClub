package com.example.tourclub.auth.userInfo;

import com.example.tourclub.auth.dto.token.UserResponseDTO;
import com.example.tourclub.auth.token.Base64AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    UserResponseDTO getUserInfoByToken(Base64AuthenticationToken token) {
        if (token == null) {
            return null;
        }

        return userInfoRepository.findByEmail(token.getEmail())
            .map(user -> new UserResponseDTO(
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getPatronymic(),
                user.getBirthday(),
                user.getPhone(),
                user.getEmail(),
                user.getGender(),
                user.getRole()
            )).orElse(null);
    }

}
