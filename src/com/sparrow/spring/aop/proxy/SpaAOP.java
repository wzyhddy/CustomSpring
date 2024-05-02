package com.sparrow.spring.aop.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 10:19
 **/
public class SpaAOP {
    public static void before(Object proxy, Method method, Object[] args) {
        System.out.println("方法执行前-日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));
    }
    public static void after(Method method, Object[] args) {
        System.out.println("方法正常结束-日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));
    }
}
