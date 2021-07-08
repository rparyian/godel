package com.example.godel.mqactive;

import com.example.godel.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMQConsumer {
    @JmsListener(destination = "myQueue")
    public void processEmployee(Employee employee){
        log.info("Recieved "+employee);
    }
}
