package com.Test.Job.search.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Models {

    @Id
    private Long jobId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private Double salary;

    @Email(message = "plz enter valid email")
    private String companyEmail;

    @NotBlank
    private String companyName;

    @Enumerated(EnumType.STRING)
    private Type jobType;

    @NotBlank
    private String employerName;

    @NotNull
    private LocalDate appliedDate;

}
