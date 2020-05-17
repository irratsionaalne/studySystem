package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;
    private String name;
    private LocalDate joinDate;
    private boolean isActive;
    @OneToOne
    private School school;
    @OneToMany
    private List<SpecialField> specialFields;
}
