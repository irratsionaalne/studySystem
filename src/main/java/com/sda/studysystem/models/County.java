package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * County model
 *
 * @author Tanel
 */
@Entity
@Data
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countyId;
    private String name;
}
