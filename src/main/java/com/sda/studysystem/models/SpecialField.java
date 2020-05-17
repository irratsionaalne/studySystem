package com.sda.studysystem.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
@Data
public class SpecialField {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialFieldId;
    private String name;
    @OneToOne
    private Category category;
    private boolean isActive;
}
