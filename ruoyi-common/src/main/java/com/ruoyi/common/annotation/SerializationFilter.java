package com.ruoyi.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xw
 * @version 1.0
 * @date 2021/10/19 11:02
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializationFilter {
    /**
     * @return 需要过滤的类型
     */
    Class<?> target() default Object.class;

    /**
     * @return 需要过滤的字段
     */
    String[] fields() default {};

    /**
     * @return true:排除/false:包含 default true
     */
    boolean exclusive() default true;

    String datePattern()default "yyyy-MM-dd HH:mm:ss";
}
