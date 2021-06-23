package com.example.godel.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AppConfiguration {
//    private static final String DB_DRIVER =
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/employeedb";
//    private static final String DB_USER = "postgres";
//    private static final String DB_PASSWORD = "1990";

    public static Connection getConnection() {
        FileInputStream fis;
        Properties property = new Properties();
        String driver=null;
        String url=null;
        String userName=null;
        String password=null;
        try {
            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
             driver = property.getProperty("spring.datasource.driver-class-name");
             url = property.getProperty("spring.datasource.url");
             userName = property.getProperty("spring.datasource.username");
             password = property.getProperty("spring.datasource.password");

        } catch (IOException e) {
            System.err.println("No properties file found");
        }
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection error");
        }
        return connection;
    }
}
