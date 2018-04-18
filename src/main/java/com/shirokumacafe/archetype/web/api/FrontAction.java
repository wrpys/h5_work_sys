package com.shirokumacafe.archetype.web.api;

import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.WorkExt;
import com.shirokumacafe.archetype.service.MessageService;
import com.shirokumacafe.archetype.service.StudentService;
import com.shirokumacafe.archetype.service.WorkService;
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
    @Autowired
    private WorkService workService;
    @Autowired
    private MessageService messageService;

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
            return "redirect:toWorkList";
        } else {
            model.addAttribute("msg", result.get("msg"));
            return "front/login";
        }
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logput() {
        sessionUsers.removeStudent();
        return "front/login";
    }

    /**
     * 作业列表
     *
     * @return
     */
    @RequestMapping(value = "toWorkList", method = RequestMethod.GET)
    public String toWorkList(Page<WorkExt> page, Model model) {
        if (page.getPageIndex() == 0) {
            page.setPageIndex(0);
        }
        Page<WorkExt> resultPage = workService.listExtAll(page);
        resultPage.setTotalPage(resultPage.getResults());
        boolean isPre = true;
        boolean isNext = true;
        if (resultPage.getPageIndex() == 1) {
            isPre = false;
        }
        if (resultPage.getPageIndex() >= resultPage.getTotalPage()) {
            isNext = false;
        }
        model.addAttribute("isPre", isPre);
        model.addAttribute("isNext", isNext);
        model.addAttribute("page", resultPage);
        return "front/work_list";
    }

    /**
     * 作业详情
     *
     * @return
     */
    @RequestMapping(value = "toWorkDetial", method = RequestMethod.GET)
    public String toWorkDetial(Integer wId, Model model) {
        workService.getWorkExt(wId, model);
        return "front/work_detial";
    }

    /**
     * 提问
     *
     * @return
     */
    @RequestMapping(value = "toQuestions", method = RequestMethod.GET)
    public String toQuestions(Integer wId, Model model) {
        return workService.getWorkReply(wId, model);
    }

    /**
     * 提问页面
     *
     * @return
     */
    @RequestMapping(value = "toQuestionsPage", method = RequestMethod.GET)
    public String toQuestionsPage(Integer wId, Model model) {
        model.addAttribute("work", workService.getWork(wId));
        return "front/work_questions";
    }

    /**
     * 提交提问
     *
     * @return
     */
    @RequestMapping(value = "submitQuestions", method = RequestMethod.POST)
    public String submitQuestions(Integer wId, String msgContent, Model model) {
        Message message = new Message();
        message.setwId(wId);
        message.setMsgContent(msgContent);
        message.setMsgPid(0);
        message.setMsgType(MessageService.MSG_TYPE_QUESTION);
        message.setOperRole(MessageService.OPER_ROLE_STUDENT);
        messageService.addMessage(message);
        model.addAttribute("work", workService.getWork(wId));
        return "redirect:toQuestions?wId=" + wId;
    }

}