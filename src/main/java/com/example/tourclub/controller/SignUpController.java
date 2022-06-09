package com.example.tourclub.controller;

import com.example.tourclub.dto.RegisterRequestDTO;
import com.example.tourclub.dto.TokenResponseDTO;
import com.example.tourclub.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping(value = "/register")
    public ResponseEntity<TokenResponseDTO> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        TokenResponseDTO tokenResponseDTO = signUpService.registerUser(registerRequestDTO);

        return new ResponseEntity<>(
            tokenResponseDTO,
            tokenResponseDTO == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK
        );
    }

}
