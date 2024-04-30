package com.sparrow.spring.aop;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 8:28
 **/
public class A implements SmartAnimal {

    @Override
    public double getSum(double a, double b) {
        double result = a + b;
        System.out.println("方法内部打印result=" + result);

        return result;
    }

    @Override
    public double getSub(double a, double b) {
        return 0;
    }
}
