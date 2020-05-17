package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;

/**
 * School model
 * @author Tanel
 */

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;
    private String name;
    private String street;
    @OneToOne
    private City city;
    @OneToOne
    private County county;
    @OneToOne
    private Country country;
    private String zipcode;

}
