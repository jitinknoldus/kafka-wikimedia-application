package org.knoldus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumerApplication.class);
        System.out.println("Hello world!");
    }
}