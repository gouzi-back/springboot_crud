package com.hyy.controller;/**
 * @Auther:haha
 * @Date:2021/4/25 - 04 - 25 21:56
 * @Description:com.hyy.config
 * @Version: 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * LoginController
 * <功能详细描述>
 *
 * @author 登录controller
 * @version [版本号, 2021/4/25 21:56]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class LoginController {

    @RequestMapping("user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //开始业务
        if (!StringUtils.isEmpty(username)&& "1".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html"; //重定项到dashboard.html页面中 具体转换看MyMvcConfig
        }else{
            //告诉用户登入失败
            model.addAttribute("msg","用户或密码错误");
            return "index";
        }

    }


    @RequestMapping("/user/loginOut")
    public String loginOUT(HttpSession session){
        session.invalidate();
        return "redircect:/index.html";
    }
}
