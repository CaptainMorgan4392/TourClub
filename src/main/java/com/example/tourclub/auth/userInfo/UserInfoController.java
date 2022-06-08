package com.example.tourclub.auth.userInfo;

import com.example.tourclub.auth.dto.token.UserResponseDTO;
import com.example.tourclub.auth.token.Base64AuthenticationToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/getInfo")
    public ResponseEntity<UserResponseDTO> getUserInfoByToken(
        @RequestHeader("Authorization") String stringOfToken
    ) throws JsonProcessingException {
        UserResponseDTO userResponseDTO = userInfoService.getUserInfoByToken(
            Base64AuthenticationToken.deserialize(stringOfToken)
        );

        return new ResponseEntity<>(
            userResponseDTO,
            userResponseDTO == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK
        );
    }

}
