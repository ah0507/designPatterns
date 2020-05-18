package com.chensee.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gaohang
 * @title: AoundAnnotation
 * @projectName DesignPatterns
 * @date 2019/10/1216:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AoundAnnotation {
}
