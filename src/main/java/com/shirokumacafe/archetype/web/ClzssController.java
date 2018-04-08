package com.shirokumacafe.archetype.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Clzss;
import com.shirokumacafe.archetype.service.ClzssService;

/**
 * 班级管理
 * @author CZX
 *
 */
@Controller
@RequestMapping("/clzss")
public class ClzssController {

    @Autowired
    private ClzssService clzssService;
    
    
    
    /*@RequestMapping
    public String to(Model model){
        model.addAttribute("attendAddrs",clzssService.getAttendAddrByAaPid(0));
        model.addAttribute("users",clzssService.getUsersByRoleId(Configs.CUSTOMER_TEACHER));
        model.addAttribute("departments",clzssService.getParentDepartment());
        return "course";
    }*/
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public String list(int pageNo,int pageSize) {
    	PageHelper.startPage(pageNo, pageSize);
    	List<Clzss> clzssList = clzssService.findAll();
        return Responses.writeJson(clzssList);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> add(Clzss clzss) {
        clzssService.add(clzss);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> update(Clzss clzss) {
        clzssService.update(clzss);
        return Responses.writeSuccess();
    }
    
    
    @RequestMapping(value = "deleteBatchs", method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> delete(@RequestParam(value = "ids") List<Integer> ids) {
        clzssService.delete(ids);
        return Responses.writeSuccess();
    }

}
