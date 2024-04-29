package com.sparrow.spring.aop;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/29 21:34
 **/
public class Ship implements Vehicle {

    @Override
    public void run() {
        System.out.println("轮船在海上running...");
    }

    @Override
    public String fly(int height) {
        System.out.println("飞船在飞行高度=" + height );
        return "飞船在飞行高度=" + height;
    }
}
