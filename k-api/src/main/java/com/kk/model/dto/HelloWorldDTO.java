package com.kk.model.dto;

import com.kk.model.param.DefaultSerializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * HelloWorldDTO
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@Data
@Accessors(chain = true)
public class HelloWorldDTO extends DefaultSerializable {

    public String hello;


    @Override
    public String toString() {
        return "HelloWorldDTO{" +
                "hello='" + hello + '\'' +
                '}';
    }
}