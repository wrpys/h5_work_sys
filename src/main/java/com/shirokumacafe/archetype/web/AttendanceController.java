package com.shirokumacafe.archetype.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: wrp
 * Date: 15-1-3
 * Time: 上午12:10
 * 出勤管理
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {



    /**
     *添加
     * @param model
     * @return
     */
    @RequestMapping(value = "beginAttendance",method = RequestMethod.POST)
    @ResponseBody
    public String beginAttendance(Model model){

        return "beginAttendance";
    }




}
