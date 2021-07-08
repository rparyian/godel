package com.example.godel.dao;

import com.example.godel.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee,Long> {
    public List<Employee> findEmployeeByFirstNameAndLastName(String name1, String name2);
}
