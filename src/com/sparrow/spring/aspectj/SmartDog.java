package com.sparrow.spring.aspectj;


import com.sparrow.spring.aop.proxy.SmartAnimal;
import org.springframework.stereotype.Component;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/30 9:36
 **/
@Component
public class SmartDog implements SmartAnimal {


    public float getSum(float a, float b) {
        System.out.println("方法执行中打印result...");
        return a+b;
    }

    @Override
    public float getSub(float a, float b) {
        return a-b;
    }
}
