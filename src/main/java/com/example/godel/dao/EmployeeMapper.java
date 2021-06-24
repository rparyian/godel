package com.example.godel.dao;

import com.example.godel.model.Employee;
import com.example.godel.model.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee=new Employee();
        employee.setEmployeeId(rs.getLong(1));
        employee.setFirstName(rs.getString(2));
        employee.setLastName(rs.getString(3));
        employee.setDepartmentId(rs.getInt(4));
        employee.setJobTitle(rs.getString(5));
        employee.setGender(Gender.valueOf(rs.getString(6).toUpperCase(Locale.ROOT)));
        employee.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        return employee;
    }
}
