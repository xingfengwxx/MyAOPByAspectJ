package com.wangxingxing.myaopbyaspectj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : 王星星
 * date : 2020/10/22 7:52
 * email : 1099420259@qq.com
 * description : 用于标记哪些方法是一个JoinPoint（切点）
 *               这些方法构成了一个PointCut（切面）
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BehaviorTrace {
    String value();
}
