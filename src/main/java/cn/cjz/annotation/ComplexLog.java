package cn.cjz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Kam-Chou
 * @date: 2020/6/16 8:23
 * @description: 复杂的注解使用
 * @version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ComplexLog {

    String value() default "未知方法";

}
