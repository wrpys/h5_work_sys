package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.ViewNotice;
import com.shirokumacafe.archetype.common.Configs;
import com.shirokumacafe.archetype.repository.terminal.MyXMLMapper;
import com.shirokumacafe.archetype.service.MenuService;
import com.shirokumacafe.archetype.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 主界面 根据角色构建菜单
 * @author wrp
 */
@Controller
public class CenterController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private MyXMLMapper myMapper;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/center")
    public String to(Model model){
        model.addAttribute("menus", Responses.writeJson(menuService.buildMenu()) );
        return "center";
    }

    @RequestMapping(value = "/toIndex")
    public String toIndex(Model model){
        ViewNotice viewNotice = myMapper.getNoticeNow();
        model.addAttribute("notice",viewNotice);
        model.addAttribute("notReadMessage", messageService.countNotReadMessage(null,Configs.CUSTOMER_STUDENT));
        model.addAttribute("sysTime",new Date());
        return "index";
    }

}
