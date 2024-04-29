package com.sparrow.spring.component;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/22 9:14
 **/
@Controller
public class UserController {



    @Resource(name = "userService")
    private UserService userService;

    public void sayOk() {
        userService.sayOk();
    }
}
