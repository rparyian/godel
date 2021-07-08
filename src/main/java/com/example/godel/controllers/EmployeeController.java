package com.example.godel.controllers;

import com.example.godel.model.Employee;
import com.example.godel.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "index";
    }
    @PostMapping("/")
    public String createEmployee( @Valid Employee employee){
        logger.error("Employee {}",employee);
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/{id}/show")
    public String showById(@PathVariable("id") Long id, Model model) throws Exception {
       model.addAttribute("employee",employeeService.getById(id));
       return "show";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) throws Exception {
        model.addAttribute("editEmployee",employeeService.getById(id));
        return "edit";
    }
    @PostMapping("/{id}")
    public String editEmployee(@PathVariable Long id, @Valid Employee employee){
        employeeService.update(employee);
        return "redirect:/";
    }
    @GetMapping("/create")
    public String create( Model model){
        model.addAttribute("newEmployee",new Employee());
        return "create";
    }

}
