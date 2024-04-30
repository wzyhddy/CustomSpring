package com.sparrow.spring.aop.proxy;
import com.sparrow.spring.aop.SmartAnimal;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 9:35
 **/
public class MyProxyProvider {
    private SmartAnimal target_obj;

    public MyProxyProvider(SmartAnimal target_obj) {
        this.target_obj = target_obj;
    }


    //目标对象执行前的方法
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("方法执行前-日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));
    }

    public void after(Method method, Object[] args) {
        System.out.println("方法正常结束-日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));

    }
    public SmartAnimal getProxy() {
        ClassLoader classLoader = target_obj.getClass().getClassLoader();
        Class<?>[] interfaces = target_obj.getClass().getInterfaces();
        SmartAnimal proxyInstance = (SmartAnimal)Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            Object result = null;

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    before(proxy, method, args);
                    result = method.invoke(target_obj, args);
                    after(method, args);
                    return result;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                return result;
            }
        });
        return  proxyInstance;
     }
}
