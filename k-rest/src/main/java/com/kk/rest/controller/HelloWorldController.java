package com.kk.rest.controller;

import com.kk.commons.Result;
import com.kk.commons.utils.ResultUtil;
import com.kk.domain.param.HelloWorldParam;
import com.kk.model.view.HelloWorldView;
import com.kk.service.hello.HelloWorldService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HelloWorldContoller
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Resource
    public HelloWorldService helloWorldService;

    /**
     * curl -X get 'localhost:8080/hello/world'
     * @return
     */
    @RequestMapping(value = "/world" ,method = RequestMethod.GET)
    @ApiOperation("hello world")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name ="hello", value = "输入")
    })
    public Result<HelloWorldView> helloWorld(String hello){
        HelloWorldParam param = new HelloWorldParam();
        HelloWorldView view = helloWorldService.hello(param);
        return ResultUtil.buildSuccessResult(view);
    }
}
