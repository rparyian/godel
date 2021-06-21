package com.example.godel.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column (name ="job_title")
    private String jobTitle;
    @Column(name ="gender")
    private String gender;
    @Column(name ="date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Employee(long employeeId, String firstName, String lastName,
                    int departmentId, String jobTitle, String gender, LocalDate dateOfBirth) {
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
