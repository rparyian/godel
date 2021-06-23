package com.example.godel.controllers;

import com.example.godel.model.Employee;
import com.example.godel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("employees", employeeService.getAll());
        employeeService.getAll().stream().forEach(System.out::println);
        return "index";
    }
    @PostMapping("/")
    public String createEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/{id}/show")
    public String showById(@PathVariable("id") Long id, Model model){
       model.addAttribute("employee",employeeService.getById(id));
       return "show";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("editEmployee",employeeService.getById(id));
        return "edit";
    }
    @PostMapping("/{id}")
    public String editEmployee(@PathVariable("id") Long id, Employee employee){
        employeeService.update(employee);
        return "redirect:/";
    }
    @GetMapping("/create")
    public String create( Model model){
        model.addAttribute("newEmployee",new Employee());
        return "create";
    }

}
