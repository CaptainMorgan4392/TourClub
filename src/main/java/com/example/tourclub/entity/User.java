package com.example.tourclub.entity;

import com.example.tourclub.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "system_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private Date birthday;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column
    private String gender;

    @Column
    private String role;

    public User(UserDTO userDTO) {
        this.setId(userDTO.getId());
        this.setLogin(userDTO.getLogin());
        this.setPassword("123123");
        this.setName(userDTO.getName());
        this.setSurname(userDTO.getSurname());
        this.setPatronymic(userDTO.getPatronymic());
        this.setBirthday(userDTO.getBirthday());
        this.setPhone(userDTO.getPhone());
        this.setEmail(userDTO.getEmail());
        this.setGender(userDTO.getGender());
        this.setRole(userDTO.getRole());
    }

}
