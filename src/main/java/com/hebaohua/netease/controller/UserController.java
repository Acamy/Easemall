package com.hebaohua.netease.controller;

import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.entity.User;
import com.hebaohua.netease.service.ProductService;
import com.hebaohua.netease.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Hebh
 * @date 2018/2/3
 * @description:
 */
@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public String index(HttpSession session, ModelMap map) throws Exception{
        User user = (User)session.getAttribute("user");
        if( user!=null){
            map.addAttribute("user", user);
        }
        List<Product> products= productService.listProducts();
        map.addAttribute("productList", products);
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap map) throws Exception{
        return "login";
    }

    @RequestMapping(value = "/api/login")
    public void loginSubmit(@RequestParam("userName") String userName,
                              @RequestParam("password") String password,
                              HttpServletRequest request,
                              ModelMap map) throws Exception{
        User user = userService.getUserByName(userName);
        if(user != null && password.equals(user.getUserPwd())){
            map.addAttribute("result", true);
            map.addAttribute("code", 200);
            request.getSession().setAttribute("user", user);
        } else {
            map.addAttribute("result", "用户密码错误");
            map.addAttribute("code", 500);
        }
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, ModelMap map) throws Exception{
        session.removeAttribute("user");
        return "login";
    }
}
