package com.kk.api.impl;

import com.kk.api.HelloWorldApi;
import com.kk.domain.dto.HelloWorldDTO;
import com.kk.domain.param.HelloWorldParam;
import org.springframework.stereotype.Service;

/**
 * HelloWorldApiImpl
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@Service
public class HelloWorldApiImpl implements HelloWorldApi {

    @Override
    public HelloWorldDTO hello(HelloWorldParam param) {
        return new HelloWorldDTO().setHello("hello world!");
    }
}