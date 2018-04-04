package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.ViewStudent;
import com.shirokumacafe.archetype.service.DepartmentService;
import com.shirokumacafe.archetype.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 学生信息管理
 * User: wrp
 * Date: 14-12-18
 * Time: 下午10:50
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping
    public String to(Model model) {
        model.addAttribute("departments", departmentService.getParentDepartment());
        return "student";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public String list(Student student, Page page) {
        Page<ViewStudent> studentPage = studentService.findPage(student, page);
        return Responses.writeJson(studentPage);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map add(Student student) {
        studentService.add(student);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(Student student) {
        studentService.update(student);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@RequestParam(value = "ids") List<Integer> ids) {
        studentService.delete(ids);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Map resetPassword(@RequestParam(value = "ids") List<Integer> ids) {
        studentService.resetPassword(ids);
        return Responses.writeSuccess();
    }

}
