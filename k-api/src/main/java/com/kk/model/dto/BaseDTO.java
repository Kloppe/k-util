package com.kk.model.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * BaseDTO
 *
 * @author juejin
 * @datetime 2023/3/8
 */
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = -4455495043333620488L;

    public BaseDTO() {
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}