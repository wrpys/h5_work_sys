package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Work;
import com.shirokumacafe.archetype.entity.WorkInfo;
import com.shirokumacafe.archetype.repository.terminal.MyXMLMapper;
import com.shirokumacafe.archetype.service.CourseService;
import com.shirokumacafe.archetype.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-18
 * Time: 下午2:44
 * 作业管理
 */
@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MyXMLMapper myXMLMapper;

    @RequestMapping
    public String to(Model model){
        model.addAttribute("courses",courseService.findAll());
        return "work";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String list(Work work,Date startDate,Date endDate,Page page){
            return Responses.writeJson(workService.list(work,startDate,endDate,page));
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(Work work){
        workService.add(work);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(Work work){
        workService.update(work);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@RequestParam(value = "ids")List<Integer> ids){
        workService.delete(ids);
        return Responses.writeSuccess();
    }

    /**
     * 获取学生作业提交
     * @param wId
     * @param page
     * @return
     */
    @RequestMapping(value = "getWorkInfoByWId",method = RequestMethod.GET)
    @ResponseBody
    public String getWorkInfoByWId(Integer wId,Page page){
        Map map = new HashMap();
        map.put("wId",wId);
        map.put("page",page);
        //由wId查找出需要提交作业的学生
        List<Map> courseStudents = myXMLMapper.getCourseStudentByWId(map);
        List<Integer> sIds = new ArrayList<Integer>();
        for (int i=0,len=courseStudents.size();i<len;i++){
            courseStudents.get(i).put("wiId","");
            courseStudents.get(i).put("wiAddTime","");
            courseStudents.get(i).put("wiFileName","");
            courseStudents.get(i).put("wiFileAddr","");
            courseStudents.get(i).put("wIDesc","");
            sIds.add((Integer)courseStudents.get(i).get("sId"));
        }
        List<WorkInfo> workInfos = workService.getWorkInfoByWIdInSId(wId,sIds);
        for (int i=0,len=courseStudents.size();i<len;i++){
            Integer sId = (Integer)courseStudents.get(i).get("sId");
            for (WorkInfo workInfo :workInfos){
                if (sId.equals(workInfo.getsId())){
                    courseStudents.get(i).put("wiId",workInfo.getWiId());
                    courseStudents.get(i).put("wiAddTime",workInfo.getWiAddTime());
                    courseStudents.get(i).put("wiFileName",workInfo.getWiFileName());
                    courseStudents.get(i).put("wiFileAddr",workInfo.getWiFileAddr());
                    courseStudents.get(i).put("wIDesc",workInfo.getwIDesc());
                }
            }
        }
        return Responses.writeJson(courseStudents);
    }

    /**
     * 下载作业文件
     * @param wiId
     * @return
     */
    @RequestMapping(value = "downWorkInfoFile",method = RequestMethod.GET)
    @ResponseBody
    public String downWorkInfoFile(Integer wiId,HttpServletResponse response) throws  Exception{
        WorkInfo workInfo = workService.getWorkInfoByWiId(wiId);
        String realPath = System.getProperty("h5_work_sys.root") + workInfo.getWiFileAddr();
        File file = new File(realPath);
        if (!file.exists()) {
            response.sendError(404, "File not found!");
            return null;
        }
        response.reset();
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition","attachment; filename=" + new String(workInfo.getWiFileName().getBytes(),"ISO-8859-1"));
        byte[] buf = new byte[1024];
        int len = 0;
        BufferedInputStream br = null;
        OutputStream out = null;
        br = new BufferedInputStream(new FileInputStream(file));
        out = response.getOutputStream();
        while ((len = br.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.flush();
        if (br != null) {
            br.close();
            br = null;
        }
        if (out != null) {
            out.close();
            out = null;
        }
        return null;
    }

}
