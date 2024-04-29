package com.sparrow.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author: 诉衷情の麻雀
 * @Description:
 * @DateTime: 2024/4/29 9:31
 **/

/**
 * @Target(ElementType.TYPE)指定我们的ComponentScan注解可以修饰Type程序元素
 * @Retention(RetentionPolicy.RUNTIME)指定ComponentScan 注解保留范围在运行时有效
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {
    String value() default "";//可以传入value属性
}
