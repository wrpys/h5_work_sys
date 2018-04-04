package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.Configs;
import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.mybatis.PageFront;
import com.shirokumacafe.archetype.common.utilities.DateTimes;
import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.MessageExample;
import com.shirokumacafe.archetype.entity.ViewMessage;
import com.shirokumacafe.archetype.entity.ViewMessageExample;
import com.shirokumacafe.archetype.repository.MessageMapper;
import com.shirokumacafe.archetype.repository.ViewMessageMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* 留言
*/
@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ViewMessageMapper viewMessageMapper;
    @Autowired
    private Users sessionUsers;

    /**
     * 新增留言
     * @param message
     */
    public void add(Message message){
        Message messageTemp = messageMapper.selectByPrimaryKey(message.getMsgId());
        message.setMsgPid(message.getMsgId());
        message.setSendRole(sessionUsers.getCurrentUser().getUserRole());
        message.setUserId(sessionUsers.getCurrentUser().getUserId());
        message.setStudentId(messageTemp.getStudentId());
        message.setMsgAddTime(new Date());
        message.setMsgIsRead(0);
        message.setMsgIsReply(0);
        message.setMsgId(null);
        messageMapper.insert(message);
        changeMessage(messageTemp,sessionUsers.getCurrentUser().getUserRole());
    }

    private void changeMessage(Message message,Integer roleId){
        List<Message> messages = new ArrayList<Message>();
        messages.add(message);
        recur2(message.getMsgPid(),messages,roleId);

        List<Integer> msgIds = new ArrayList<Integer>();
        for (Message messageTemp : messages){
            msgIds.add(messageTemp.getMsgId());
        }
        MessageExample example=new MessageExample();
        MessageExample.Criteria criteria=example.createCriteria();
        criteria.andMsgIdIn(msgIds);
        criteria.andSendRoleEqualTo(Configs.CUSTOMER_STUDENT);
        Message messageTemp = new Message();
        messageTemp.setMsgIsReply(1);
        messageMapper.updateByExampleSelective(messageTemp,example);
        //教师回复，将留言改为未读
        message.setMsgIsRead(0);
        messageMapper.updateByPrimaryKeySelective(message);
    }

    /**
     * 删除单条留言
     * @param msgId
     */
    public void delete(Integer msgId){
        messageMapper.deleteByPrimaryKey(msgId);
    }

    /**
     *删除多条留言
     * @param ids
     */
    public void deletes(List<Integer> ids){
        MessageExample example=new MessageExample();
        MessageExample.Criteria criteria=example.createCriteria();
        criteria.andMsgIdIn(ids);
        messageMapper.deleteByExample(example);
    }

    /**
     * 后台回复列表
     * @param viewMessage
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    public Page<ViewMessage> findMessageForPage(ViewMessage viewMessage,Date startDate,Date endDate,Page page){

        ViewMessageExample example=new ViewMessageExample();
        ViewMessageExample.Criteria criteria=example.createCriteria();

        if(StringUtils.isNotBlank(viewMessage.getsNo())){
            criteria.andSNoLike("%"+ viewMessage.getsNo() +"%");
        }
        if (StringUtils.isNotBlank(viewMessage.getStudentName())){
            criteria.andStudentNameLike("%"+viewMessage.getStudentName()+"%");
        }
        if (StringUtils.isNotBlank(viewMessage.getTeacherName())){
            criteria.andTeacherNameLike("%"+viewMessage.getTeacherName()+"%");
        }
        if (viewMessage.getMsgIsRead()!=null){
            criteria.andMsgIsReadEqualTo(viewMessage.getMsgIsRead());
        }
        if(startDate!=null){
            criteria.andMsgAddTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate!=null){
            criteria.andMsgAddTimeLessThan(DateTimes.addDate(endDate, 1));
        }
        criteria.andMsgPidEqualTo(0);
        if (!sessionUsers.getCurrentUser().getUserRole().equals(Configs.CUSTOMER_AMIN)){
            criteria.andUserIdEqualTo(sessionUsers.getCurrentUser().getUserId());
        }
        example.setOrderByClause("msg_add_time desc");
        int results=viewMessageMapper.countByExample(example);
        List<ViewMessage> rows=viewMessageMapper.selectByExampleWithRowbounds(example,page.createRowBounds());
        page.setResults(results);
        page.setRows(rows);
        return page;
    }

    /**
     * 留言回复列表
     * @param msgId
     * @return
     */
    public List<ViewMessage> getMessageByMsgId(Integer msgId){
        ViewMessageExample example = new ViewMessageExample();
        ViewMessageExample.Criteria criteria = example.createCriteria();
        criteria.andMsgIdEqualTo(msgId);
        ViewMessage viewMessage = viewMessageMapper.selectByExample(example).get(0);

        List<ViewMessage> viewMessages = new ArrayList<ViewMessage>();
        viewMessages.add(viewMessage);
        recur(viewMessage.getMsgId(), viewMessages);

        //设置为已读
        List<Integer> msgIds = new ArrayList<Integer>();
        for (ViewMessage viewMessageTemp : viewMessages){
            if(viewMessageTemp.getSendRole().equals(Configs.CUSTOMER_STUDENT)){
                msgIds.add(viewMessageTemp.getMsgId());
            }
        }
        MessageExample exampleTemp = new MessageExample();
        MessageExample.Criteria criteriaTemp = exampleTemp.createCriteria();
        criteriaTemp.andMsgIdIn(msgIds);
        Message message = new Message();
        message.setMsgIsRead(1);
        messageMapper.updateByExampleSelective(message,exampleTemp);
        return viewMessages;
    }

    /**
     * 统计未读留言条数
     * @return
     */
    public Integer countNotReadMessage(Integer studentId,Integer roleId){
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        if(studentId==null){
            criteria.andUserIdEqualTo(sessionUsers.getCurrentUser().getUserId());
        }else{
            criteria.andStudentIdEqualTo(studentId);
        }
        criteria.andMsgIsReadEqualTo(0);
        criteria.andSendRoleEqualTo(roleId);
        return messageMapper.countByExample(example);
    }

    /**
     * 迭代查找留言
     * @param msgPId
     * @param viewMessages
     */
    private void recur(Integer msgPId,List<ViewMessage> viewMessages){
        ViewMessageExample example = new ViewMessageExample();
        ViewMessageExample.Criteria criteria = example.createCriteria();
        criteria.andMsgPidEqualTo(msgPId);
        List<ViewMessage> viewMessageList = viewMessageMapper.selectByExample(example);
        viewMessages.addAll(viewMessageList);
        for (ViewMessage viewMessage : viewMessageList){
            recur(viewMessage.getMsgId(),viewMessages);
        }
    }

    /**
     *迭代查找留言（从后往前）
     * @param msgPId
     * @param messages
     */
    private void recur2(Integer msgPId,List<Message> messages,Integer roleId){
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andMsgIdEqualTo(msgPId);
        criteria.andSendRoleNotEqualTo(roleId);
        List<Message> messageList = messageMapper.selectByExample(example);
        messages.addAll(messageList);
        for (Message message : messageList){
            recur2(message.getMsgPid(), messages,roleId);
        }
    }
/************************前台个人中心 学生留言**************************************************************************/
    /**
     *迭代查找留言（从前往后）
     * @param message
     * @param messages
     */
    private void recur4(Message message,List<Message> messages,Integer roleId){
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
//        criteria.andMsgIdNotEqualTo(message.getMsgId());
        criteria.andMsgPidEqualTo(message.getMsgId());
        criteria.andSendRoleEqualTo(roleId);
        List<Message> messageList = messageMapper.selectByExample(example);
        messages.addAll(messageList);
        for (Message messageTemp : messageList){
            recur4(messageTemp, messages,roleId);
        }
    }
    /**
     * 获取要回复的父ID
     * @param msgId
     * @return
     */
    public Integer getMsgPid(Integer msgId){
        Message message = messageMapper.selectByPrimaryKey(msgId);
        List<Message> messages = new ArrayList<Message>();
        recur4(message,messages,Configs.CUSTOMER_TEACHER);
        return messages.get(messages.size()-1).getMsgId();
    }

    /**
     * 学生留言
     * @param message
     */
    public void studentAdd(Message message){
        if (message.getMsgPid()==null){
            message.setMsgPid(0);
        }else{
            Message messageTemp = messageMapper.selectByPrimaryKey(message.getMsgId());
            message.setUserId(messageTemp.getUserId());
            messageTemp.setMsgIsRead(0);
            messageMapper.updateByPrimaryKeySelective(messageTemp);
        }
        message.setMsgId(null);
        message.setMsgIsRead(0);
        message.setMsgIsReply(0);
        message.setMsgAddTime(new Date());
        message.setSendRole(Configs.CUSTOMER_STUDENT);
        messageMapper.insert(message);
    }

    /**
     *个人中心 学生留言
     * @param pageFront
     * @param studentId
     * @return
     */
    public PageFront forntList(PageFront pageFront,Integer studentId){
        ViewMessageExample example = new ViewMessageExample();
        ViewMessageExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        criteria.andMsgPidEqualTo(0);
        example.setOrderByClause("msg_add_time desc");
        int resules = viewMessageMapper.countByExample(example);
        pageFront.setResults(resules);
        pageFront.setTotalPage(resules);
        List<ViewMessage> rows = viewMessageMapper.selectByExampleWithRowbounds(example,pageFront.createRowBounds());
        pageFront.setRows(rows);

        //标记是否有未读留言
        for (ViewMessage viewMessage : rows){
            viewMessage.setMsgIsRead(isRead(viewMessage));
        }

        return pageFront;
    }
    //判断留言是否有未读
    public Integer isRead(ViewMessage viewMessage){
        List<Message> messages = new ArrayList<Message>();
        recur3(viewMessage.getMsgId(),messages);
        for (Message message : messages){
            if(message.getSendRole().equals(Configs.CUSTOMER_TEACHER)&&message.getMsgIsRead().equals(0)){
                return 0;
            }
        }
        return 1;
    }

    /**
     *迭代查找留言（从后往前）
     * @param msgPId
     * @param messages
     */
    private void recur3(Integer msgPId,List<Message> messages){
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andMsgIdEqualTo(msgPId);
        List<Message> messageList = messageMapper.selectByExample(example);
        messages.addAll(messageList);
        for (Message message : messageList){
            recur3(message.getMsgPid(), messages);
        }
    }

    /**
     * 根据留言ID查找所有回复
     * @param msgId
     * @return
     */
    public List<ViewMessage> frontReplyList(Integer msgId){
        ViewMessageExample example = new ViewMessageExample();
        ViewMessageExample.Criteria criteria = example.createCriteria();
        criteria.andMsgIdEqualTo(msgId);
        example.setOrderByClause("msg_add_time asc");
        List<ViewMessage> viewMessages = new ArrayList<ViewMessage>();
        viewMessages.addAll(viewMessageMapper.selectByExample(example));
        recur(msgId,viewMessages);
        return viewMessages;
    }

    /**
     * 修改为已读
     * @param message
     */
    public void update(Message message){
        messageMapper.updateByPrimaryKeySelective(message);
    }

}
