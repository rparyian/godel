package com.example.godel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class AppConfiguration {
    @Bean
    public DataSource postgresDataSourse(){
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
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
}
