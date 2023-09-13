package com.example.cmd.domain.user.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


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

    private String adress;

    public User(User user) {
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.adress = user.getAdress();
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
