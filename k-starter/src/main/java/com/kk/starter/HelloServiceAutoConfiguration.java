package com.kk.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * HelloServiceAutoConfiguration
 *
 * @author juejin
 * @datetime 2022/12/26
 */
@Configuration
@ComponentScan({"com.test.api"})
@ConditionalOnProperty(prefix = "study",name = "enable", havingValue = "true")
public class HelloServiceAutoConfiguration {

}

