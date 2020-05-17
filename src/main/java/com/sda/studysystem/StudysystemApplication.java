package com.sda.studysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "com.sda.studysystem.models")
//@EnableJpaRepositories(basePackages = "com.sda.studysystem.repositories")
public class StudysystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudysystemApplication.class, args);
    }

}
