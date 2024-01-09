package com.java.practice.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String gender;
    private String city;
    private String occupation;
    private Double salary;

}
