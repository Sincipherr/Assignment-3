package com.geekster.WeeklyTest_Instagram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String instagramName;
    private LocalDate DOB;
    private String email;
    private String phoneNumber;
    private String password;
    private String bio;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean blueTick; // will not be sent through dto

}
