package com.sparrow.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/22 9:13
 **/
@Service
public class UserService {

    @Autowired
    public void sayOk() {
        System.out.println("UserServiceOk。。。");
    }
}
