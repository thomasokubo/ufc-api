package com.repnation.ufc.domain.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fighter {

    @Id
    @GeneratedValue
    private Long Id;

    @Value("first_name")
    private String firstName;

    @Value("last_name")
    private String lastName;

    private String nickname;

    @Value("holds_title")
    private boolean holdsTitle;

    @Value("weight_class")
    private String weightClass;

    private String stats;

    private int age;

    private String height;

    private String weight;

    private String summary;







}
