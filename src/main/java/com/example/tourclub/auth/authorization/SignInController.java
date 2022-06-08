package com.example.tourclub.auth.authorization;

import com.example.tourclub.auth.dto.authentication.AuthRequestDTO;
import com.example.tourclub.auth.dto.token.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
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
