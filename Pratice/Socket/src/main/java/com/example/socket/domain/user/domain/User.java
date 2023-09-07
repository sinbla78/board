package com.example.socket.domain.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String email;

    private String userName;

    private String password;

    private String number;

    public User(User user) {
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.number = user.getNumber();
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
