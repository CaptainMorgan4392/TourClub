package com.example.tourclub.service;

import com.example.tourclub.entity.User;
import com.example.tourclub.common.UserRole;
import com.example.tourclub.dto.RegisterRequestDTO;
import com.example.tourclub.dto.TokenResponseDTO;
import com.example.tourclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    UserRepository userRepository;

    public TokenResponseDTO registerUser(RegisterRequestDTO registerRequestDTO) {
        boolean alreadyExistsByEmail = userRepository.findByEmail(registerRequestDTO.getEmail()).isPresent();
        boolean alreadyExistsByLogin = userRepository.findByLogin(registerRequestDTO.getLogin()).isPresent();
        boolean alreadyExistsByPhone = userRepository.findByPhone(registerRequestDTO.getPhone()).isPresent();

        if (alreadyExistsByLogin || alreadyExistsByEmail || alreadyExistsByPhone) {
            return null;
        }

        User user = new User(
            null,
            registerRequestDTO.getLogin(),
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

        userRepository.save(user);

        return new TokenResponseDTO(registerRequestDTO.getEmail());
    }

}
