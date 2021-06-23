package com.example.godel.service;

import com.example.godel.dao.EmployeeDao;
import com.example.godel.model.Employee;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }

    public void delete(Long id) {
        employeeDao.delete(id);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }
}
