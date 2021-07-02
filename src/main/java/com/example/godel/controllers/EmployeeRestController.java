package com.example.godel.controllers;

import com.example.godel.model.Employee;
import com.example.godel.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/api/employees")
@Api(value = "employee rest controller")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "{id}", produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get employee by id", response = Employee.class)
    public Employee getEmployee(@PathVariable Long id ) throws Exception {
            return this.employeeService.getById(id);
    };

    @PostMapping(value = "", produces =
    MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create employee", response = Employee.class)
    public Employee saveEmployee ( @Valid Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PutMapping(value = "", produces =
    MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@Valid Employee employee){
        employeeService.update(employee);
        return employee;
    }

    @DeleteMapping(value = "{id}",produces =
    MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        this.employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "",produces =
    MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all employees", response = Iterable.class)
    public Iterable<Employee> getAllEmployees(){

        return this.employeeService.getAll();
    }
}
