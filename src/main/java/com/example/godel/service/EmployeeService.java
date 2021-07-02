package com.example.godel.service;

import com.example.godel.dao.EmployeeCrudRepository;
import com.example.godel.exception.EmployeeServiceException;
import com.example.godel.exception.EmployeeServiceNotFoundException;
import com.example.godel.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
public class EmployeeService {
    private EmployeeCrudRepository employeeCrudRepository;

    @Autowired
    public EmployeeService(EmployeeCrudRepository employeeCrudRepository)
    {
        this.employeeCrudRepository=employeeCrudRepository;
    }

    public Iterable<Employee> getAll() {
        return employeeCrudRepository.findAll();
    }

    public void save( Employee employee) {
        try {
            employeeCrudRepository.save(employee);
        }
        catch (Throwable throwable){
            throw new EmployeeServiceException();
        }
    }

    public Employee getById(Long id) throws Exception {
        return employeeCrudRepository.findById(id)
                .orElseThrow(()->new EmployeeServiceNotFoundException());
    }

    public void delete(Long id) {
        try{
        employeeCrudRepository.deleteById(id);
        }
        catch (Throwable throwable){
            throw new EmployeeServiceNotFoundException();
        }

    }

    public void update(Employee employee) {
        try {
            employeeCrudRepository.save(employee);
        }
        catch (Throwable throwable){
            throw new EmployeeServiceException();
        }
    }
}
