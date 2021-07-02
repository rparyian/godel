package com.example.godel.dao;

import com.example.godel.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee,Long> {
}
