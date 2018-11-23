package com.badminton.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CoachDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String category;
}
