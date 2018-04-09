package com.shirokumacafe.archetype.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.shirokumacafe.archetype.common.Configs;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.entity.Work;
import com.shirokumacafe.archetype.entity.WorkInfo;
import com.shirokumacafe.archetype.service.UserService;
import com.shirokumacafe.archetype.service.WorkService;

/**
 * 作业管理：出作业题，查看作业结果，统计分析作业情况
 * @author CZX
 *
 */
@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;
    @Autowired
    private UserService userService;
    
    @RequestMapping
    public String to(Model model){
    	List<User> users = userService.getUsersByRoleId(Configs.CUSTOMER_TEACHER);
    	users.addAll(userService.getUsersByRoleId(Configs.CUSTOMER_AMIN));
        model.addAttribute("users",users);
        return "work";
    }
    
    /**
     * 出作业题
     * @param work
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<?,?> add(Work work){
        workService.add(work);
        return Responses.writeSuccess();
    }
    
    /**
     * 查看所有作业发布情况
     * @author CZX
     * @param work
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Page<Work> list(Page<Work> page){
    	com.github.pagehelper.Page<?> pageHelper = PageHelper.startPage(page.getPageIndex(), page.getLimit());
    	List<Work> workList = workService.findAll();
    	page.setRows(workList);
        page.setResults((int)pageHelper.getTotal());
        return page;
    }
    
    /**
     * 修改作业
     * @author CZX
     * @param work
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map<?,?> update(Work work){
        workService.update(work);
        return Responses.writeSuccess();
    }
    
    /**
     * 删除作业
     * @author CZX
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value = "ids")List<Integer> ids){
        workService.delete(ids);
        return Responses.writeSuccess();
    }
    
    /**
     * 查看作业结果
     * @author CZX  
     * @param workInfo
     * @return
     */
    @RequestMapping(value = "getWorkResult",method = RequestMethod.POST)
    @ResponseBody
    public String getWorkResult(WorkInfo workInfo){
    	WorkInfo result = workService.getWorkInfoByWiIdAndStuId(workInfo);
        return Responses.writeJson(result);
    }
    
    
    
    
    /**
     * 跳转至作业分析
     * @author CZX
     * @param work
     * @return
     */
    @RequestMapping("toWorkAnalysis")
    public String toWorkAnalysis(Model model, Work work) {
        model.addAttribute("clzss_id", work.getClzssId());
        model.addAttribute("workId", work.getwId());
        return "getWorkAnalysis";
    }
    
    /**
     * 统计分析作业情况
     * @author CZX
     * @param work
     * @return
     */
    @RequestMapping(value = "getWorkAnalysis",method = RequestMethod.POST)
    @ResponseBody
    public Page<Student> getWorkAnalysis(Work work,Page<Student> page){
    	com.github.pagehelper.Page<?> pageHelper = PageHelper.startPage(page.getPageIndex(), page.getLimit());
    	List<Student> stuList = workService.getWorkAnalysis(work);
    	page.setRows(stuList);
        page.setResults((int)pageHelper.getTotal());
        return page;
    }
    
}
