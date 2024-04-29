package com.sparrow.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 诉衷情の麻雀
 * @Description: 返回一个代理对象
 * @DateTime: 2024/4/29 21:50
 **/
public class VehicleProxyProvider {
    //定义一个属性
    //target_vehicle表示真正要执行的对象
    //
    private Vehicle target_vehicle;

    public VehicleProxyProvider(Vehicle target_vehicle) {
        this.target_vehicle = target_vehicle;
    }

    /**
     *编写一个方法，可以返回一个代理对象
     *
     * public static Object newProxyInstance(ClassLoader loader,
     * Class<?>[] interfaces,InvocationHandler 调用处理器对象)
     */
    public Vehicle getProxy() {
        //1.得到类加载器
        ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
        //2.得到要代理的对象/被执行对象的接口信息
        Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();
        Vehicle proxy = (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            /**
             * proxy表示代理对象
             * @param proxy the proxy instance that the method was invoked on
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             * method就是通过代理对象调用方法时的那个方法
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             * args表示调用代理对象.run(xx)传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了...");
                //反射基础 通过方法反向调用对象
                Object result = method.invoke(target_vehicle, args);
                System.out.println("交通工具停止运行了....");
                return result;
            }
        });
        return proxy;
    }
}
