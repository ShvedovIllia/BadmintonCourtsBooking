package com.badminton.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "coach")
@Getter
public class CoachEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "category", nullable = false)
    private String category;

}
