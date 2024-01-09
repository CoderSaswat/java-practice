package com.java.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {
    @Id
    private UUID id;
    private String name;
    private String jobTitle;
    private String phoneNumber;
    private String email;
    private Boolean isTrainingPending;
    private Boolean isNewJoinee;
}
