package com.stylefeng.guns.rest.modular.example;

import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.common.SimpleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

    @RequestMapping("")
    public ResponseEntity hello() {
        System.out.println(CurrentUser.getCurrentUserId());

        // userId > key >reidis[userInfo] 失效时间 30分钟
        //第二次访问的时候检测redis中有没有，有就不动他，如果过了30分钟了，CurrentUser发现redis中没有，就会认为没有登录，或者登录已经失效，强制做一些操作

        // userId > 条件，去数据库取
        return ResponseEntity.ok("请求成功!");
    }
}
