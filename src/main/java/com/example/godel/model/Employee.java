package com.example.godel.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Integer departmentId;
    private String jobTitle;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Employee(long employeeId, String firstName, String lastName,
                    int departmentId, String jobTitle, Gender gender, LocalDate dateOfBirth) {
        this.employeeId=employeeId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.departmentId=departmentId;
        this.jobTitle=jobTitle;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
    }

    public Employee() {

    }
}
