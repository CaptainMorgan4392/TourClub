package com.example.tourclub.dto;

import com.example.tourclub.entity.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UserResponseDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("role")
    private String role;

    public UserResponseDTO(User user) {
        this.setId(user.getId());
        this.setLogin(user.getLogin());
        this.setName(user.getName());
        this.setSurname(user.getSurname());
        this.setPatronymic(user.getPatronymic());
        this.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
        this.setPhone(user.getPhone());
        this.setEmail(user.getEmail());
        this.setGender(user.getGender());
        this.setRole(user.getRole());
    }

}
