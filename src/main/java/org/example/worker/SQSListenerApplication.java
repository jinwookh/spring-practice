package org.example.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SQSListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SQSListenerApplication.class, args);
    }
}
