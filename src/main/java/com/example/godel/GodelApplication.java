package com.example.godel;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableJms
public class GodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GodelApplication.class, args);
    }
}
