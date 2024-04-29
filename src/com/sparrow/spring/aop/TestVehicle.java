package com.sparrow.spring.aop;

import org.junit.Test;
/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/29 22:21
 **/
public class TestVehicle {

    @Test
    public void proxyRun() {
        Vehicle vehicle = new Ship();
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(vehicle);
        Vehicle proxy = vehicleProxyProvider.getProxy();
        System.out.println(proxy.getClass());
        String result = proxy.fly(100);
        System.out.println("result = " + result);

        //所以当执行run方法时会执行到代理对象的invoke
        proxy.run();
    }
}
