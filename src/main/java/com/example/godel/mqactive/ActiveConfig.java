package com.example.godel.mqactive;

import com.example.godel.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.Collections;

@Configuration
public class ActiveConfig {
    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        val messageConverter=new org.springframework.jms.support.converter.MappingJackson2MessageConverter();
        messageConverter.setObjectMapper(new ObjectMapper().registerModule(new JavaTimeModule()));
        messageConverter.setTypeIdPropertyName("Roman-type");
        messageConverter.setTypeIdMappings(Collections.singletonMap("employee", Employee.class));
        return messageConverter;
    }
}
