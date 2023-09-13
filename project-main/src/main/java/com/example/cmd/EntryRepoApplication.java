package com.example.cmd;

import com.example.cmd.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(JwtProperties.class)
@SpringBootApplication
public class EntryRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntryRepoApplication.class, args);
    }
}