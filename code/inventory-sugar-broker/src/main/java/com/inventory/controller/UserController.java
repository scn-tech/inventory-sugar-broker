package com.inventory.controller;

import com.inventory.entity.User;
import com.inventory.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String redirectToUserLogin() {
        return "user-login";
    }

    @GetMapping("/forgot-password")
    public String redirectToUserForgotPassword() {
        return "user-forgot-password";
    }

    @PostMapping("/auth-user")
    public ModelAndView authenticateUser(User user) {
        ModelAndView mv = new ModelAndView();
        User validUser = service.authUser(user);
        if(Objects.nonNull(validUser) && validUser.getId()>0) {
            mv.setViewName("redirect:/home");
        } else {
            log.info("Invalid User name or password");
            mv.addObject("code","401");
            mv.setViewName("user-login");
        }

        /*if("Admin".equals(user.getUserName()) && "Admin@123".equals(user.getPassword())) {
            mv.setViewName("redirect:/home");
        } else {
            log.info("Invalid User name or password");
            mv.addObject("code","401");
            mv.setViewName("user-login");
        }*/
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView redirectToUserLogout() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("code","204");
        mv.setViewName("redirect:/login");
        return mv;
    }

}
