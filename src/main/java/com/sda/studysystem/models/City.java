package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;

/**
 * City model
 * @author Tanel
 */

@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    private String name;
    private boolean isActive;
    @OneToOne
    private County county;
    @OneToOne
    private Country country;
}
