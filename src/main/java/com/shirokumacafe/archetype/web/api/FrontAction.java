package com.shirokumacafe.archetype.web.api;

import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * /**
 * 前台入口
 */
@Controller
@RequestMapping(value = "/front")
public class FrontAction {

    @Autowired
    private StudentService studentService;
    @Autowired
    private Users sessionUsers;

    /**
     * 跳转登录页
     */
    @RequestMapping(value = "toLogin", method = RequestMethod.GET)
    public String toIndex(Model model) {
        return "front/login";
    }

    /**
     * 跳转登录页
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String sNo, String sPassword, Model model) {
        Map result = studentService.checkLogin(sNo, sPassword);
        boolean isSucess = Boolean.valueOf(String.valueOf(result.get("success")));
        if (isSucess) {
            return "redirect:front/work_list";
        } else {
            model.addAttribute("msg", result.get("msg"));
            return "front/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logput() {
        sessionUsers.removeStudent();
        return "front/login";
    }


}