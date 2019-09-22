package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chengjindong
 * @Date: 2019/9/22 20:22
 */
@RequestMapping("/user/")
@RestController
public class UserController {

    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    @RequestMapping(name="/register" ,method = RequestMethod.POST)
    public ResponseVO register(UserModel userModel){

        if (StringUtils.isBlank(userModel.getUsername())){ // userModel.getUsername() == null || userModel.getUsername().trim().length() == 0
            return ResponseVO.serviceFail("用户名不能为空");
        }

        if (StringUtils.isBlank(userModel.getPassword())){
            return ResponseVO.serviceFail("密码不能为空");
        }

        boolean register = userAPI.register(userModel);
        if (register){
            return ResponseVO.success("注册成功");
        }else {
            return ResponseVO.serviceFail("注册失败");
        }
    }

    @RequestMapping(name="/check" ,method = RequestMethod.POST)
    public ResponseVO check(String userName){

        if (StringUtils.isNotBlank(userName)){

            // 当返回true时表示用户名可用
            boolean isExits = userAPI.checkUsername(userName);
            if (isExits){
              return   ResponseVO.success("用户名不存在");
            }else {
              return   ResponseVO.serviceFail("用户名已存在");
            }
        }else{
            return ResponseVO.serviceFail("用户名不能为空");
        }
    }

    @RequestMapping(name="/logout" ,method = RequestMethod.GET)
    public ResponseVO logout(){
        /*
            应用：
                1、前端存储JWT 【七天】 ： JWT的刷新
                2、服务器端会存储活动用户信息【30分钟】
                3、JWT里的userId为key，查找活跃用户
            退出：
                1、前端删除掉JWT
                2、后端服务器删除活跃用户缓存
            现状：
                1、前端删除掉JWT
         */


        return ResponseVO.success("用户退出成功");
    }

    @RequestMapping(name="/getUserInfo" ,method = RequestMethod.GET)
    public ResponseVO getUserInfo(){

        // 获取当前登录用户

        String userId = CurrentUser.getCurrentUserId();
        if (StringUtils.isNotBlank(userId)){
            // 将用户id传入后端进行检查
            Integer uuid = Integer.parseInt(userId);
            UserInfoModel userInfo = userAPI.getUserInfo(uuid);

            if (userInfo != null){
                return ResponseVO.success(userInfo);
            }else{
                return ResponseVO.serviceFail("用户信息查询失败");
            }
        }else{
            return ResponseVO.serviceFail("用户未登录");
        }
    }

    @RequestMapping(name="/updateUserInfo" ,method = RequestMethod.POST)
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel){

        // 获取当前登录用户

        String userId = CurrentUser.getCurrentUserId();
        if (StringUtils.isNotBlank(userId)){
            // 将用户id传入后端进行检查
            Integer uuid = Integer.parseInt(userId);

            // 判断当前登陆人员的ID与修改的结果ID是否一致
            if(uuid != userInfoModel.getUuid()){
                return ResponseVO.serviceFail("请修改您个人的信息");
            }
            UserInfoModel userInfo = userAPI.updateUserInfo(userInfoModel);

            if (userInfo != null){
                return ResponseVO.success(userInfo);
            }else{
                return ResponseVO.serviceFail("用户信息修改失败");
            }
        }else{
            return ResponseVO.serviceFail("用户未登录");
        }
    }

}
