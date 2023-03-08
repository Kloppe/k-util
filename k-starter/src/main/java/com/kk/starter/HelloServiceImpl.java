package com.test.api.impl;

import com.test.api.HelloService;
import org.springframework.stereotype.Component;

/**
 * HelloServiceImpl
 *
 * @author juejin
 * @datetime 2022/12/26
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello world!";
    }
}
