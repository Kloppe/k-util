package com.kk.api;

import com.kk.model.dto.HelloWorldDTO;
import com.kk.model.param.HelloWorldParam;

/**
 * @author juejin
 * @datetime 2023/2/21 3:22 下午
 */
public interface HelloWorldApi {

    public HelloWorldDTO hello(HelloWorldParam param);
}
