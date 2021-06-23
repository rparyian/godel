package com.example.godel.controllers;

import com.example.godel.model.Employee;
import com.example.godel.model.Gender;
import com.example.godel.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeRestControllerTest {
    @Autowired
    private EmployeeRestController employeeRestController;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @Test
    void getEmployee() throws Exception{
        when(employeeService.getById(anyLong())).thenReturn(
                new Employee(1l,"Ivan","Ivanov",23,"coder", Gender.MALE,
                        LocalDate.of(1990,3,23)));

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",
                       equalTo("Ivan")));
    }

    @Test
    void saveEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getAllEmployees() throws Exception {
        when(employeeService.getAll()).thenReturn(Arrays.asList(
                new Employee(1l,"Ivan","Ivanov",23,"coder",Gender.MALE,
                        LocalDate.of(1990,3,23)),
        new Employee(2l,"Volodya","Petrov",24,"tester",Gender.MALE,
                LocalDate.of(1993,2,13))));

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].firstName",
                        containsInAnyOrder("Ivan","Volodya")));
    }
}