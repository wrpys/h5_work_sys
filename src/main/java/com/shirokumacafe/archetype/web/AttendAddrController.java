package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.AttendAddr;
import com.shirokumacafe.archetype.service.AttendAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * User: wrp
 * Date: 14-12-16
 * Time: 下午10:07
 * 上课地址
 */
@Controller
@RequestMapping("/attendAddr")
public class AttendAddrController {

    @Autowired
    private AttendAddService attendAddService;

    /**
     *跳转页面
     * @param model
     * @return
     */
    @RequestMapping
    public String to(Model model){
        model.addAttribute("attendAddrs", Responses.writeJson(attendAddService.findAllAttendAddr()));
        return "attendAddr";
    }

    /**
     *添加
     * @param attendAddr
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map  add(AttendAddr attendAddr){
        attendAddService.addAttendAddr(attendAddr);
        return Responses.writeSuccess(attendAddr,"attendAddr");
    }

    /**
     *修改
     * @param attendAddr
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(AttendAddr attendAddr){
        attendAddService.updateAttendAddr(attendAddr);
        return Responses.writeSuccess(attendAddr,"attendAddr");
    }

    /**
     * 删除
     * @param aaId
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(Integer aaId){
        return Responses.writeSuccess(attendAddService.deleteAttendAddr(aaId),"attendAddr");
    }

    /**
     * 根据父类ID（教学楼）找教室
     * @param aaPid
     * @return
     */
    @RequestMapping(value = "getAttendAddrByAaPid",method = RequestMethod.POST)
    @ResponseBody
    public String getAttendAddrByAaPid(Integer aaPid){
        return Responses.writeJson(attendAddService.getAttendAddrByAaPid(aaPid));
    }

}
