package com.example.tourclub.service;

import com.example.tourclub.dto.AuthRequestDTO;
import com.example.tourclub.dto.TokenResponseDTO;
import com.example.tourclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

    @Autowired
    UserRepository userRepository;

    public TokenResponseDTO authUser(AuthRequestDTO authRequestDTO) {
        return userRepository.findByLogin(authRequestDTO.getLogin())
            .map(user -> {
                if (user.getPassword().equals(authRequestDTO.getPassword())) {
                    return new TokenResponseDTO(user.getEmail());
                }

                return null;
            }).orElse(null);
    }

}
