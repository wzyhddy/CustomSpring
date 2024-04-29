package com.sparrow.spring.aop;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/29 21:49
 **/
public class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("汽车在路上running");
    }

    @Override
    public String fly(int height) {
        return "小汽车在飞行高度=" + height;
    }
}
