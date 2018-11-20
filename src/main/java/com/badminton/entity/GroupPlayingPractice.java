package com.badminton.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="group_playing_practice")

public class GroupPlayingPractice {

    @Column (name = "title", nullable = false)
    private String title;
    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(5,2)")
    private BigDecimal price;
}
