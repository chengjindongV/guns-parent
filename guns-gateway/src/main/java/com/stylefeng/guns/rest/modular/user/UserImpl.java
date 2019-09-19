package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @Author: chengjindong
 * @Date: 2019/9/18 23:31
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl  implements  UserAPI{
    @Override
    public boolean login(String username, String password) {
        return true;
    }
}
