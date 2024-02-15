package com.bulletinboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String login() {
        return "login";
        
    }

    /* ログインエラー画面 */
    @GetMapping(value = "/login", params = "error")
    public ModelAndView loginError() {
        ModelAndView mav = new ModelAndView();
        var errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        mav.setViewName("login");
        mav.addObject("errorMsg", errorInfo);
        return mav;
    }

}
