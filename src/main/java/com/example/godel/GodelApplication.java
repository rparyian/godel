package com.example.godel;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableAdminServer
public class GodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GodelApplication.class, args);
    }
}
