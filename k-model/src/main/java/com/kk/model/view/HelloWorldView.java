package com.kk.model.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * HelloWorldView
 *
 * @author juejin
 * @datetime 2023/2/21
 */
@Data
@ApiModel(value = "helloView")
public class HelloWorldView {

    @ApiModelProperty("姓名")
    public String name;
}