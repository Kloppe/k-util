package com.kk.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldContoller
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    /**
     * curl -X get 'localhost:8080/hello/world'
     * @return
     */
    @RequestMapping("/world")
    public String helloWorld(){
        return "hello world";
    }
}