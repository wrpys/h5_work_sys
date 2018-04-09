package com.shirokumacafe.archetype.service;

import com.github.pagehelper.PageHelper;
import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.MessageExt;
import com.shirokumacafe.archetype.entity.QuestionMessage;
import com.shirokumacafe.archetype.repository.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @since 2018/4/8
 */
@Service
@Transactional
public class MessageService {

    // 消息类型
    public static final Integer MSG_TYPE_QUESTION = 1;
    public static final Integer MSG_TYPE_DISCUSS = 2;

    // 消息发送者的角色
    public static final Integer OPER_ROLE_TEACHER = 1;
    public static final Integer OPER_ROLE_STUDENT = 2;

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private Users sessionUsers;

    public void addMessage(Message message) {
        if (OPER_ROLE_TEACHER == message.getOperRole().intValue()) {
            message.setOperId(sessionUsers.getCurrentUser().getUserId());
        } else if (OPER_ROLE_STUDENT == message.getOperRole().intValue()) {
            message.setOperId(sessionUsers.getStudent().getsId());
        }
        message.setCreateTime(new Date());
        messageMapper.insertSelective(message);
    }

    public Page<QuestionMessage> questionMessagePage(QuestionMessage questionMessage, Page page) {
        questionMessage.setTeacherId(sessionUsers.getCurrentUser().getUserId());
        com.github.pagehelper.Page pageHelper = PageHelper.startPage(page.getPageIndex(), page.getLimit());
        List<QuestionMessage> list = messageMapper.selectQuestionMessageByParams(questionMessage);
        page.setRows(list);
        page.setResults(Integer.valueOf(String.valueOf(pageHelper.getTotal())));
        return page;
    }

    public Page<MessageExt> messagePage(MessageExt messageExt, Page page) {
        com.github.pagehelper.Page pageHelper = PageHelper.startPage(page.getPageIndex(), page.getLimit());
        List<MessageExt> list = null;
        if (OPER_ROLE_TEACHER == messageExt.getOperRole().intValue()) {
            list = messageMapper.selectMessageTeacherExtByParams(messageExt);
        } else if (OPER_ROLE_STUDENT == messageExt.getOperRole().intValue()) {
            list = messageMapper.selectMessageStudentExtByParams(messageExt);
        }
        page.setRows(list);
        page.setResults(Integer.valueOf(String.valueOf(pageHelper.getTotal())));
        return page;
    }


}
