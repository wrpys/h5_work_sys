package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Department;
import com.shirokumacafe.archetype.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/**
 * User: wrp
 * Date: 14-12-20
 * Time: 下午10:07
 * 系别管理
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     *跳转页面
     * @param model
     * @return
     */
    @RequestMapping
    public String to(Model model){
        model.addAttribute("departments", Responses.writeJson(departmentService.findAll()));
        return "department";
    }

    /**
     *添加
     * @param department
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map  add(Department department){
        departmentService.add(department);
        return Responses.writeSuccess(department,"department");
    }

    /**
     *修改
     * @param department
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(Department department){
        departmentService.update(department);
        return Responses.writeSuccess(department,"department");
    }

    /**
     * 删除
     * @param dId
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(Integer dId){
        return Responses.writeSuccess(departmentService.delete(dId),"department");
    }

    /**
     * 获取对应专业
     * @param dPid
     * @return
     */
    @RequestMapping(value = "getDepartmentByDPid",method = RequestMethod.POST)
    @ResponseBody
    public String getDepartmentByDPid(Integer dPid){
        return Responses.writeJson(departmentService.getDepartmentByDPid(dPid));
    }

}
