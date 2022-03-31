package com.ruoyi.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xw
 * @version 1.0
 * @date 2021/10/19 11:01
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializationFilters {
    /**
     * @return 注解集合
     */
    SerializationFilter[] filters();
}
