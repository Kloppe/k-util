package com.kk.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@SpringBootApplication(scanBasePackages = "com.kk")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("*********** project start success *********");
    }
}