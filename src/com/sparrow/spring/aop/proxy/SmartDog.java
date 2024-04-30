package com.sparrow.spring.aop.proxy;



/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 9:36
 **/
public class SmartDog implements SmartAnimal {


    public float getSum(float a, float b) {
        return a+b;
    }

    @Override
    public float getSub(float a, float b) {
        return a-b;
    }
}
