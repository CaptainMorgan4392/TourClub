package com.example.tourclub.auth.authorization;

import com.example.tourclub.auth.dto.authentication.AuthRequestDTO;
import com.example.tourclub.auth.dto.token.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

    @Autowired
    SignInRepository signInRepository;

    TokenResponseDTO authUser(AuthRequestDTO authRequestDTO) {
        return signInRepository.findByLogin(authRequestDTO.getLogin())
            .map(user -> {
                if (user.getPassword().equals(authRequestDTO.getPassword())) {
                    return new TokenResponseDTO(user.getEmail());
                }

                return null;
            }).orElse(null);
    }

}
