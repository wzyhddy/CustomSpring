package com.sparrow.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: 诉衷情の麻雀
 * @Description: 切面类
 * @DateTime: 2024/4/30 11:12
 **/
@Aspect //表示是一个切面类
@Component//会注入SmartAnimalAspect到容器
public class SmartAnimalAspect {

    //希望将f1方法切入到SmartDog-getSum前执行

    /**
     * @Before 表示前置通知：即在我们的目标对象执行方法前执行
     * Value = "execution(public float com.sparrow.spring.aspectj.SmartDog.getSum(float, float))
     * 指定切入到哪个类的哪个方法 形式是：访问修饰符 返回类型 全类名.方法名(形参列表)
     * f1 方法可以理解成就是一个切入方法
     * @param joinPoint
     */
    @Before(value = "execution(public float com.sparrow.spring.aspectj.SmartDog.getSum(float, float))")
    public static void f1(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("方法执行前-日志-方法名-" + signature.getName() + "-参数-" + Arrays.asList(args));
    }
    public static void f2(Method method, Object[] args) {
        System.out.println("方法正常结束-日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));
    }
}
