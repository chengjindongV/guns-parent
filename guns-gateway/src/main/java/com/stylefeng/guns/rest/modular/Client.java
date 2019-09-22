package com.stylefeng.guns.rest.modular;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @Author: chengjindong
 * @Date: 2019/9/20 22:19
 */
@Component
public class Client {

    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    public void run(){
        userAPI.login("admin","password");
    }
}
