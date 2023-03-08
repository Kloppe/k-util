package com.kk.service.hello;

import com.kk.model.param.HelloWorldParam;
import com.kk.model.param.HelloWorldQueryParam;
import com.kk.model.view.HelloWorldView;
import org.springframework.stereotype.Service;

/**
 * HelloWorldService
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@Service
public class HelloWorldService {


    public HelloWorldView hello(HelloWorldQueryParam param){

        HelloWorldView view = new HelloWorldView();
        view.setName("hello");
        return view;

    }

}