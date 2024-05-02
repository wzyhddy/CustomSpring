package com.sparrow.spring.aspectj;

import com.sparrow.spring.aop.SmartAnimalProvider;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 诉衷情の麻雀
 * @Description: 切面类，类似于MyProxyProvider
 * @DateTime: 2024/4/30 12:09
 **/
public class AOPAspectjTest {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Object bean = ioc.getBean(SmartAnimal.class);
        System.out.println(bean);
    }
}
