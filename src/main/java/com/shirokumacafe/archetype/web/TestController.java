package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Test;
import com.shirokumacafe.archetype.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: wrp
 * Date: 14-12-16
 * Time: 下午10:07
 * 题目
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping
    public String to(){
        return "test";
    }

    /**
     * 列表
     * @param test
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String list(Test test,Date startDate,Date endDate,Page page){
        return Responses.writeJson(testService.list(test,startDate,endDate,page));
    }

    /**
     * 添加
     * @param test
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(Test test){
        testService.add(test);
        return Responses.writeSuccess();
    }

    /**
     * 修改
     * @param test
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(Test test){
        testService.update(test);
        return Responses.writeSuccess();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map update(@RequestParam(value = "ids")List<Integer>ids){
        testService.delete(ids);
        return Responses.writeSuccess();
    }


}
