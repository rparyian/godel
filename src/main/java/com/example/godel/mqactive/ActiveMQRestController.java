package com.example.godel.mqactive;

import com.example.godel.model.Employee;
import com.example.godel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/active")
public class ActiveMQRestController {

    private JmsTemplate jmsTemplate;
    private EmployeeService employeeService;
    @Autowired
    public ActiveMQRestController(JmsTemplate jmsTemplate, EmployeeService employeeService) {
        this.jmsTemplate = jmsTemplate;
        this.employeeService=employeeService;
    }
    @GetMapping(value = "/send/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendEmployee(@PathVariable Long id) throws Exception {
        Employee employee=employeeService.getById(id);
        jmsTemplate.convertAndSend("myQueue",employee);
        return "done. sent: "+employee;
    }
}
