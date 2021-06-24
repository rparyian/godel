package com.example.godel.dao;

import com.example.godel.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getById (Long id);
    void save (Employee employee);
    void delete (Long id);
    List<Employee> getAll();
    void update(Employee employee);
}
