package com.example.godel.service;

import com.example.godel.model.Employee;
import com.example.godel.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
        employeeRepository.flush();

    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(getById(id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
