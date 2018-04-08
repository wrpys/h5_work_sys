package com.shirokumacafe.archetype.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
/**
 * 前台入口
 */
@Controller
@RequestMapping(value = "/front")
public class FrontAction {

    /**
     * 跳转登录页
     * @param model
     * @return
     */
    @RequestMapping(value = "toLogin",method=RequestMethod.GET)
    public String toIndex(Model model){
        return "front/login";
    }

    /**
     * 跳转登录页
     * @param model
     * @return
     */
    @RequestMapping(value = "login",method=RequestMethod.GET)
    public String login(Model model){
        return "front/login";
    }



}