package com.example.godel.controllers;

import com.example.godel.model.Employee;
import com.example.godel.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/api/employees")
@Api(value = "employee rest controller")
@Slf4j
@Validated
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "{id}", produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get employee by id", response = Employee.class)
    public Employee getEmployee(@PathVariable @Min(value = 1) Long id ) throws Exception {
        log.info("Getting employee by id- "+ id);
        return this.employeeService.getById(id);
    };

    @PostMapping(value = "", produces =
    MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create employee", response = Employee.class)
    public Employee saveEmployee ( @RequestBody @Valid Employee employee){
        log.info("creating new employee ");
        employeeService.save(employee);
        return employee;
    }

    @PutMapping(value = "{id}", produces =
    MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@PathVariable @Min(value = 1)Long id,
                                   @RequestBody @Valid Employee employee){
        log.info("editing employee");
        employeeService.update(employee);
        return employee;
    }

    @DeleteMapping(value = "{id}",produces =
    MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable @Min(value = 1) Long id){
        this.employeeService.delete(id);
        log.info("deleting employee by id- "+id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "",produces =
    MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all employees", response = Iterable.class)
    public Iterable<Employee> getAllEmployees(){
        log.info("getting list of all employees");
        return this.employeeService.getAll();
    }
}
