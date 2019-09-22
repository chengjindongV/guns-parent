package com.stylefeng.guns.api.user;

/**
 * @Author: chengjindong
 * @Date: 2019/9/18 23:29
 */
public interface UserAPI {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
