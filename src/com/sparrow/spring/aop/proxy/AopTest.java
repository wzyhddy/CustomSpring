package com.sparrow.spring.aop.proxy;

import org.junit.Test;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 9:36
 **/
public class AopTest {

    @Test
    public void TestProxy() {
        SmartAnimal smartAnimal = new SmartDog();
        MyProxyProvider proxyProvider = new MyProxyProvider(smartAnimal);
        SmartAnimal proxy = proxyProvider.getProxy();
        proxy.getSum(10, 6);

    }
}
