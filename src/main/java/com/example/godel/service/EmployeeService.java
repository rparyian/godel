package com.example.godel.service;

import com.example.godel.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee getById (Long id);
    void save (Employee employee);
    void delete (Long id);
    List<Employee> getAll();
}
