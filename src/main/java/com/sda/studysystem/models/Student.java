package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Student {

    @Id
    private String studentId;
    private String name;
    private String school;
    private LocalDate joinDate;
    private String grade;
    private boolean isActive;
}
