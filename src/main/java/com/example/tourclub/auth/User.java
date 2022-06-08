package com.example.tourclub.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Table(name = "system_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
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

}
