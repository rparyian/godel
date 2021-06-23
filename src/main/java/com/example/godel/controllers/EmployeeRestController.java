package com.example.godel.controllers;

import com.example.godel.model.Employee;
import com.example.godel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable ("id") Long employeeId ){
            if (employeeId==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Employee employee=this.employeeService.getById(employeeId);

            if (employee==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Employee>( employee, HttpStatus.OK);
    };

    @RequestMapping(value = "", method = RequestMethod.POST,produces =
    MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> saveEmployee (@RequestBody Employee employee){
        if (employee==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces =
    MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        if (employee==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.update(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,produces =
    MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") Long id){
        Employee employee = this.employeeService.getById(id);
        if (employee==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "",method = RequestMethod.GET, produces =
    MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees= this.employeeService.getAll();
        if (employees.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
