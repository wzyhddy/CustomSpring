package com.sparrow.spring.aop;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 8:31
 **/
public class SmartAnimalProvider {
    private SmartAnimal target_animal;

    public SmartAnimalProvider(SmartAnimal target_animal) {
        this.target_animal = target_animal;
    }


    /**
     * @return 返回代理对象，该代理对象可以执行目标对象
     */
    public SmartAnimal getTarget_animal() {
        ClassLoader classLoader = target_animal.getClass().getClassLoader();
        Class<?>[] interfaces = target_animal.getClass().getInterfaces();
        SmartAnimal proxy = (SmartAnimal)Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("日志-" + "方法名-" + method.getName() + "-参数" + Arrays.toString(args));
                    result=method.invoke(target_animal, args);
                    System.out.println("日志-方法名-" + method.getName() + "结果result=" + result);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("方法执行异常-日志" + "异常类型" + e.getClass().getName());
                } finally {
                    System.out.println("方法最终结束-日志-方法名-" + method.getName());
                }
                return result;
            }
        });
        return proxy;
    }
}
