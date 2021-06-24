package com.example.godel.dao;

import com.example.godel.model.Employee;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDao {
    void setDataSource(DataSource dataSource);
    Employee getById (Long id);
    void save (Employee employee);
    void delete (Long id);
    List<Employee> getAll();
    void update(Employee employee);
}
