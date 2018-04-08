package com.shirokumacafe.archetype.web.api;

import com.shirokumacafe.archetype.common.mybatis.PageFront;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.*;
import com.shirokumacafe.archetype.common.Configs;
import com.shirokumacafe.archetype.repository.terminal.MyXMLMapper;
import com.shirokumacafe.archetype.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.*;

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