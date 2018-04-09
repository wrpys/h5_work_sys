package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.QuestionMessage;
import com.shirokumacafe.archetype.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @since 2018/4/8
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("toQuestionMessage")
    public String toQuestionMessage() {
        return "questionMessage";
    }

    @RequestMapping(value = "questionMessageList", method = RequestMethod.GET)
    @ResponseBody
    public String questionMessageList(QuestionMessage questionMessage, Page page) {
        Page<QuestionMessage> questionMessagePage = messageService.questionMessagePage(questionMessage, page);
        return Responses.writeJson(questionMessagePage);
    }

    @RequestMapping(value = "replyQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Map replyQuestion(Message message) {
        message.setMsgType(MessageService.MSG_TYPE_DISCUSS);
        message.setOperRole(MessageService.OPER_ROLE_TEACHER);
        messageService.addMessage(message);
        return Responses.writeSuccess();
    }


}
