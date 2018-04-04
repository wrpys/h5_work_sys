package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.ViewMessage;
import com.shirokumacafe.archetype.common.Configs;
import com.shirokumacafe.archetype.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
* 留言管理
*/
@Controller
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping
    public String to(Model model){
        model.addAttribute("studentRole", Configs.CUSTOMER_STUDENT);
        model.addAttribute("teacherRole", Configs.CUSTOMER_TEACHER);
        return "message";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String list(ViewMessage viewMessage,Date startDate,Date endDate,Page page){
        Page<ViewMessage> viewMessagePage=messageService.findMessageForPage(viewMessage,startDate,endDate,page);
        return Responses.writeJson(viewMessagePage);
    }

    @RequestMapping(value = "getMessageByMsgId",method = RequestMethod.POST)
    @ResponseBody
    public String getMessageByMsgId(Integer msgId){
        return Responses.writeJson(messageService.getMessageByMsgId(msgId));

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(Message message){
        messageService.add(message);
        return Responses.writeSuccess();
    }


}
