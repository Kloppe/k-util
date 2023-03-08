package com.kk.model.param;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * BaseParam
 *
 * @author juejin
 * @datetime 2023/3/8
 */
public class BaseParam implements Serializable {
    private static final long serialVersionUID = -6385852772880996507L;

    public BaseParam() {
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}