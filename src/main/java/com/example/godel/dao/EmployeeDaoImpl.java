package com.example.godel.dao;

import com.example.godel.model.Employee;
import com.example.godel.model.Gender;
import com.example.godel.config.AppConfiguration;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee getById(Long id) {
        Connection connection= AppConfiguration.getConnection();
    PreparedStatement preparedStatement=null;
    String sql="SELECT employee_id, first_name, last_name,department_id,job_title," +
            "gender,date_of_birth FROM employee WHERE employee_id=?";
    Employee employee=new Employee();
    ResultSet resultSet=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                fulfilEmployee(employee, resultSet);
                preparedStatement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closePS(preparedStatement);
            closeCon(connection);
        }
        return employee;
    }

    private void fulfilEmployee(Employee employee, ResultSet resultSet) throws SQLException {
        employee.setEmployeeId(resultSet.getLong(1));
        employee.setFirstName(resultSet.getString(2));
        employee.setLastName(resultSet.getString(3));
        employee.setDepartmentId(resultSet.getInt(4));
        employee.setJobTitle(resultSet.getString(5));
        employee.setGender(Gender.valueOf(resultSet.getString(6)));
        employee.setDateOfBirth(resultSet.getDate(7).toLocalDate());
    }

    @Override
    public void save(Employee employee) {
        Connection connection= AppConfiguration.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="INSERT INTO EMPLOYEE (first_name, last_name, department_id,job_title," +
                "gender,date_of_birth) VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setInt(3,employee.getDepartmentId());
            preparedStatement.setString(4,employee.getJobTitle());
            preparedStatement.setString(5,employee.getGender().name());
            preparedStatement.setDate(6, Date.valueOf(employee.getDateOfBirth()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement!=null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }

    @Override
    public void delete(Long id) {
        Connection connection= AppConfiguration.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="DELETE FROM employee WHERE employee_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement!=null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        Connection connection= AppConfiguration.getConnection();
        List<Employee> listOfAllEmployees = new ArrayList<>();
        Statement statement=null;
        String sql = "SELECT employee_id,first_name, last_name,department_id,job_title," +
                "gender,date_of_birth FROM employee";
        try {
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Employee employee=new Employee();
                fulfilEmployee(employee, resultSet);

                listOfAllEmployees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStat(statement);
            closeCon(connection);
        }
        return listOfAllEmployees;
    }

    @Override
    public void update(Employee employee) {
        Connection connection= AppConfiguration.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="UPDATE EMPLOYEE SET first_name=?,last_name=?,department_id=?,job_title=?," +
                "gender=?,date_of_birth=? WHERE employee_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setInt(3,employee.getDepartmentId());
            preparedStatement.setString(4,employee.getJobTitle());
            preparedStatement.setString(5,employee.getGender().name());
            preparedStatement.setDate(6, Date.valueOf(employee.getDateOfBirth()));
            preparedStatement.setLong(7, employee.getEmployeeId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          closePS(preparedStatement);
          closeCon(connection);
        }

    }
    private void closePS(PreparedStatement ps){
        if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    private void closeCon(Connection con){
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    private void closeStat(Statement statement){
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    private void closeResultSet(ResultSet resultSet){
        if (resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
