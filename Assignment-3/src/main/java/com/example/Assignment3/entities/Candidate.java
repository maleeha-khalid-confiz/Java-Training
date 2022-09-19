package com.example.Assignment3.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data //Replacement of getter and setter annotations from lambok
public class Candidate {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    String firstName;
    String lastName;
    int age;
    int expectedSalary;
}
