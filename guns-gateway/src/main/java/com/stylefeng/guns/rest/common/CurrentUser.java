package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.api.user.UserInfoModel;

/**
 * @Author: chengjindong
 * @Date: 2019/9/21 22:52
 * 每一个request都会创建一个线程变量
 */
public class CurrentUser {

    //线程绑定的存储空间
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void saveUserId(String userId){
        threadLocal.set(userId);
    }

    public static String getCurrentUserId(){
      return  threadLocal.get();
    }

//    // 将用户信息放入存储空间
//    public static void saveUserInfo(UserInfoModel userInfoModel){
//        threadLocal.set(userInfoModel);
//    }
//
//    // 从线程变量中取出用户信息
//    public static UserInfoModel getCurrentUser(){
//        return threadLocal.get();
//    }
}
