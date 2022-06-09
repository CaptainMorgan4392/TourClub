package com.example.tourclub.controller;

import com.example.tourclub.service.SignInService;
import com.example.tourclub.dto.AuthRequestDTO;
import com.example.tourclub.dto.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class SignInController {

    @Autowired
    SignInService signInService;

    @PostMapping(value = "/auth")
    public ResponseEntity<TokenResponseDTO> authUser(@RequestBody AuthRequestDTO authRequestDTO) {
        TokenResponseDTO tokenResponseDTO = signInService.authUser(authRequestDTO);

        return new ResponseEntity<>(
            tokenResponseDTO,
            tokenResponseDTO == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK
        );
    }

}
