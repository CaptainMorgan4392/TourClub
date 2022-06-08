package com.example.tourclub.auth.registration;

import com.example.tourclub.auth.User;
import com.example.tourclub.auth.UserRole;
import com.example.tourclub.auth.dto.authentication.RegisterRequestDTO;
import com.example.tourclub.auth.dto.token.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    SignUpRepository signUpRepository;

    TokenResponseDTO registerUser(RegisterRequestDTO registerRequestDTO) {
        boolean alreadyExistsByEmail = signUpRepository.findByEmail(registerRequestDTO.getEmail()).isPresent();
        boolean alreadyExistsByLogin = signUpRepository.findByLogin(registerRequestDTO.getLogin()).isPresent();
        boolean alreadyExistsByPhone = signUpRepository.findByPhone(registerRequestDTO.getPhone()).isPresent();

        if (alreadyExistsByLogin || alreadyExistsByEmail || alreadyExistsByPhone) {
            return null;
        }

        User user = new User(
            null,
            registerRequestDTO.getEmail(),
            registerRequestDTO.getPassword(),
            registerRequestDTO.getName(),
            registerRequestDTO.getSurname(),
            registerRequestDTO.getPatronymic(),
            registerRequestDTO.getBirthday(),
            registerRequestDTO.getPhone(),
            registerRequestDTO.getEmail(),
            registerRequestDTO.getGender(),
            UserRole.USER.name()
        );

        signUpRepository.save(user);

        return new TokenResponseDTO(registerRequestDTO.getEmail());
    }

}
