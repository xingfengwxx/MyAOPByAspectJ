package com.wangxingxing.myaopbyaspectj.asepect;

import android.util.Log;

import com.wangxingxing.myaopbyaspectj.annotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * author : 王星星
 * date : 2020/10/22 7:54
 * email : 1099420259@qq.com
 * description :
 */
@Aspect
public class BehaviorAspect {

    private static final String TAG = "BehaviorAspect";

    //所有包和类的带有com.wangxingxing.myaopbyaspectj.annotation.BehaviorTrace注解的方法
    //都属于这个Pointcut
    @Pointcut("execution(@com.wangxingxing.myaopbyaspectj.annotation.BehaviorTrace * *(..))")
    public void methodAnnotatedWithBehaviorTrace() {
    }

    //针对Pointcut来进行处理，只能是一个一个JointPoint（切点）
    @Around("methodAnnotatedWithBehaviorTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            //方法前面
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            //注解
            BehaviorTrace behaviorTrace = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);
            String funcName = behaviorTrace.value();
            long begin = System.currentTimeMillis();
            result = joinPoint.proceed();
            long end = System.currentTimeMillis();

            //哪一个类的，哪一个方法被执行了
            String className = methodSignature.getDeclaringType().getSimpleName();
            String methodName = methodSignature.getName();

            Log.i(TAG, "weaveJoinPoint: " + String.format("功能：%s，%s类的%s方法，执行耗时：%d ms", funcName, className, methodName, end - begin));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
