package com.sda.studysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = "com.sda.studysystem.models")
//@EnableJpaRepositories(basePackages = "com.sda.studysystem.repositories")
public class StudysystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudysystemApplication.class, args);
    }

}
