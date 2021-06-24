package com.example.godel.dao;

import com.example.godel.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public Employee getById(Long id) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        Employee employee=jdbcTemplate.queryForObject(sql,new Object[]{id},new EmployeeMapper());
        return employee;
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title," +
                "gender, date_of_birth) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),employee
        .getDepartmentId(),employee.getJobTitle(),employee.getGender().name(),employee.getDateOfBirth());
    }

    @Override
    public void delete(Long id) {
        String sql="DELETE FROM employee WHERE employee_id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        List employees = jdbcTemplate.query(sql,new EmployeeMapper());
        return employees;
    }

    @Override
    public void update(Employee employee) {
        String sql ="UPDATE employee SET first_name=?,last_name=?, department_id=?," +
                "job_title=?, gender=?,date_of_birth=? WHERE employee_id=?";
        jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),
                employee.getDepartmentId(),employee.getJobTitle(),employee.getGender().name(),
                employee.getDateOfBirth(),employee.getEmployeeId());
    }


}
