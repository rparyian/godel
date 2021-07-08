package com.example.godel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Component
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="department_id")
    private Integer departmentId;
    @Column(name="job_title")
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_of_birth")
    @Adult
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
