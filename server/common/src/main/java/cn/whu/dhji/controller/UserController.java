package cn.whu.dhji.controller;


import cn.whu.dhji.config.RestResult;
import cn.whu.dhji.entity.User;
import cn.whu.dhji.enums.ResultCode;
import cn.whu.dhji.service.UserService;
import cn.whu.dhji.utils.Md5Utils;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘泽彬
 * @since 2019-05-21
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserByName.do")
    public RestResult getUserByName(String username){
        Subject subject = SecurityUtils.getSubject();
        if (!username.equals(subject.getPrincipal().toString())){
            return RestResult.error(ResultCode.AUTH_NOT_ENOUGH);
        }
        User user = userService.getByUsername(username);
        if (user == null){
            return RestResult.error(ResultCode.USER_NOT_EXIST);
        }
        return RestResult.successData(user);
    }

    @PostMapping("/login.do")
    public RestResult login(String username, String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return RestResult.error(ResultCode.WRONG_PARAM);
        }
        log.info("用户：{}，登陆，输入密码：{}", username, Md5Utils.md5(password));
        Subject subject = SecurityUtils.getSubject();   // 用户对象，session的实现部分
        if (subject.isAuthenticated() || username.equals(subject.getPrincipal())){
            log.warn("重复登录:" + subject.getPrincipal());
            return RestResult.error(ResultCode.REPEATED_LOGIN);
        } else {
            // 未登录或者是登录用户名不同的话，就需要首先进行登出
            subject.logout();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            usernamePasswordToken.setRememberMe(true);
            try {
                if (userService.getByUsername(username) == null || userService.getByUsername(username).getEnable() == 0){
                    return RestResult.error(ResultCode.USER_NOT_EXIST);
                } else {
                        subject.login(usernamePasswordToken);
                }
            } catch (AuthenticationException e){
                log.warn("登陆失败：", e);
                return RestResult.error(ResultCode.USER_PASSWORD_ERROR);
            }
        }
        return null;
    }

}

