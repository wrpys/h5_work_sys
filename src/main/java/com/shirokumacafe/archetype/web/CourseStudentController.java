package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.CourseInfo;
import com.shirokumacafe.archetype.entity.ViewCourseInfo;
import com.shirokumacafe.archetype.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wrp
 * Date: 15-1-3
 * Time: 下午8:47
 * 学生选课
 */
@Controller
@RequestMapping("/courseStudent")
public class CourseStudentController {

    @Autowired
    private CourseStudentService courseStudentService;

    /**
     * 根据课程ID获取选课学生
     *
     * @param cId
     * @return
     */
    @RequestMapping(value = "getCourseStudentByCId", method = RequestMethod.POST)
    @ResponseBody
    public String getCourseStudentByCId(Integer cId) {
        return Responses.writeJson(courseStudentService.getCourseStudentByCId(cId));
    }

    /**
     * 更改选课。
     *
     * @param ids
     * @param cId
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map update(@RequestParam(value = "ids") List<Integer> ids, Integer cId) {
        courseStudentService.update(ids, cId);
        return Responses.writeSuccess();
    }

    /**
     * 点名。
     *
     * @param request
     * @param cId
     */
    @RequestMapping(value = "attendance", method = RequestMethod.POST)
    @ResponseBody
    public Map attendance(HttpServletRequest request, Integer cId, Integer ctId) {
        courseStudentService.attendanceOrWork(request, cId, ctId, 0);
        return Responses.writeSuccess();
    }

    /**
     * 作业提交。
     *
     * @param request
     * @param cId
     */
    @RequestMapping(value = "work", method = RequestMethod.POST)
    @ResponseBody
    public Map work(HttpServletRequest request, Integer cId, Integer ctId) {
        courseStudentService.attendanceOrWork(request, cId, ctId, 1);
        return Responses.writeSuccess();
    }

/*****************出勤和作业提交统计****************************************************************/
    /**
     * 点名列页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "attendanceInit", method = RequestMethod.GET)
    public String attendanceInit(Model model) {
        return "attendanceWork";
    }

    /**
     * 出勤列表
     *
     * @param
     * @param page
     * @return
     */
    @RequestMapping(value = "attendanceList", method = RequestMethod.GET)
    @ResponseBody
    public String attendanceList(Integer cId, String sNo, Page page) {
        return Responses.writeJson(courseStudentService.getAttendanceInfoByCId(cId, sNo, page));
    }

    /**
     * 作业提交列表
     *
     * @param
     * @param page
     * @return
     */
    @RequestMapping(value = "workList", method = RequestMethod.GET)
    @ResponseBody
    public String workList(Integer cId, String sNo, Page page) {
        return Responses.writeJson(courseStudentService.getWorkInfoByCId(cId, sNo, page));
    }

//    /**
//     * 导出数据出勤情况
//     * @param cId
//     * @return
//     */
//    @RequestMapping(value = "exportAttendance",method = RequestMethod.POST)
//    @ResponseBody
//    public Map exportAttendance(Integer cId,Page page){
//        page = courseStudentService.getAttendanceInfoByCId(cId, null, page);
//        List<AttendanceWorkInfo> list = page.getRows();
//        try {
//            String path = System.getProperty("h5_work_sys.root")+"File/temp/";
//            String fileName = "出勤情况_"+new Date().getTime()+".xls";
//            WritableWorkbook wwb = Workbook.createWorkbook(new File(path+fileName));
//            //建立工作簿
//            WritableSheet ws = wwb.createSheet("出勤情况", 0);
//            Label label0 = new Label(0,0,"学号");
//            Label label1 = new Label(1,0,"姓名");
//            Label label2 = new Label(2,0,"未点名");
//            Label label3 = new Label(3,0,"出勤");
//            Label label4 = new Label(4,0,"旷课");
//            Label label5 = new Label(5,0,"迟到");
//            Label label6 = new Label(6,0,"早退");
//            Label label7 = new Label(7,0,"是否满勤");
//            //  将定义好的单元格添加到工作表中
//            ws.addCell(label0);
//            ws.addCell(label1);
//            ws.addCell(label2);
//            ws.addCell(label3);
//            ws.addCell(label4);
//            ws.addCell(label5);
//            ws.addCell(label6);
//            ws.addCell(label7);
//            //设置格式（单元格的大小）
//            ws.setColumnView(0, 20);
//            ws.setColumnView(1, 20);
//            ws.setColumnView(2, 20);
//            ws.setColumnView(3, 20);
//            ws.setColumnView(4, 20);
//            ws.setColumnView(5, 20);
//            ws.setColumnView(6, 20);
//            ws.setColumnView(7, 20);
//            for (int i=1,len=list.size();i<=len;i++){
//                AttendanceWorkInfo attendanceWorkInfo = list.get(i-1);
//                label0 = new Label(0,i,attendanceWorkInfo.getsNo());
//                label1 = new Label(1,i,attendanceWorkInfo.getsName());
//                label2 = new Label(2,i,showAttendance(0,attendanceWorkInfo.getAttendances(),attendanceWorkInfo.getAttendanceInfos()));
//                label3 = new Label(3,i,showAttendance(1,attendanceWorkInfo.getAttendances(),attendanceWorkInfo.getAttendanceInfos()));
//                label4 = new Label(4,i,showAttendance(2,attendanceWorkInfo.getAttendances(),attendanceWorkInfo.getAttendanceInfos()));
//                label5 = new Label(5,i,showAttendance(3,attendanceWorkInfo.getAttendances(),attendanceWorkInfo.getAttendanceInfos()));
//                label6 = new Label(6,i,showAttendance(4,attendanceWorkInfo.getAttendances(),attendanceWorkInfo.getAttendanceInfos()));
//                label7 = new Label(7,i,isAttendanceOver(attendanceWorkInfo.getAttendances(),attendanceWorkInfo.getAttendanceInfos()));
//                ws.addCell(label0);
//                ws.addCell(label1);
//                ws.addCell(label2);
//                ws.addCell(label3);
//                ws.addCell(label4);
//                ws.addCell(label5);
//                ws.addCell(label6);
//                ws.addCell(label7);
//            }
//            //写入Excel工作表
//            wwb.write();
//            //关闭Excel工作簿对象
//            wwb.close();
//            return Responses.writeSuccess(fileName,"fileName");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return Responses.writeFail();
//    }
//
//    /**
//     * 导出数据作业提交情况
//     * @param cId
//     * @return
//     */
//    @RequestMapping(value = "exportWork",method = RequestMethod.POST)
//    @ResponseBody
//    public Map exportWork(Integer cId,Page page){
//        page = courseStudentService.getWorkInfoByCId(cId, null, page);
//        List<AttendanceWorkInfo> list = page.getRows();
//        try {
//            String path = System.getProperty("h5_work_sys.root")+"File/temp/";
//            String fileName = "作业提交情况_"+new Date().getTime()+".xls";
//            WritableWorkbook wwb = Workbook.createWorkbook(new File(path+fileName));
//            //建立工作簿
//            WritableSheet ws = wwb.createSheet("作业提交情况", 0);
//            Label label0 = new Label(0,0,"学号");
//            Label label1 = new Label(1,0,"姓名");
//            Label label2 = new Label(2,0,"未录入");
//            Label label3 = new Label(3,0,"已交");
//            Label label4 = new Label(4,0,"未交");
//            Label label5 = new Label(5,0,"漏交");
//            Label label6 = new Label(6,0,"是否满交");
//            //  将定义好的单元格添加到工作表中
//            ws.addCell(label0);
//            ws.addCell(label1);
//            ws.addCell(label2);
//            ws.addCell(label3);
//            ws.addCell(label4);
//            ws.addCell(label5);
//            ws.addCell(label6);
//            //设置格式（单元格的大小）
//            ws.setColumnView(0, 20);
//            ws.setColumnView(1, 20);
//            ws.setColumnView(2, 20);
//            ws.setColumnView(3, 20);
//            ws.setColumnView(4, 20);
//            ws.setColumnView(5, 20);
//            ws.setColumnView(6, 20);
//            for (int i=1,len=list.size();i<=len;i++){
//                AttendanceWorkInfo attendanceWorkInfo = list.get(i-1);
//                label0 = new Label(0,i,attendanceWorkInfo.getsNo());
//                label1 = new Label(1,i,attendanceWorkInfo.getsName());
//                label2 = new Label(2,i,showWork(0,attendanceWorkInfo.getWorks(),attendanceWorkInfo.getWorkInfos()));
//                label3 = new Label(3,i,showWork(1,attendanceWorkInfo.getWorks(),attendanceWorkInfo.getWorkInfos()));
//                label4 = new Label(4,i,showWork(2,attendanceWorkInfo.getWorks(),attendanceWorkInfo.getWorkInfos()));
//                label5 = new Label(5,i,showWork(3,attendanceWorkInfo.getWorks(),attendanceWorkInfo.getWorkInfos()));
//                label6 = new Label(6,i,isWorkOver(attendanceWorkInfo.getWorks(),attendanceWorkInfo.getWorkInfos()));
//                ws.addCell(label0);
//                ws.addCell(label1);
//                ws.addCell(label2);
//                ws.addCell(label3);
//                ws.addCell(label4);
//                ws.addCell(label5);
//                ws.addCell(label6);
//            }
//            //写入Excel工作表
//            wwb.write();
//            //关闭Excel工作簿对象
//            wwb.close();
//            return Responses.writeSuccess(fileName,"fileName");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return Responses.writeFail();
//    }

    @RequestMapping(value = "downFile", method = RequestMethod.GET)
    public String downFile(String fileName, HttpServletResponse response) throws Exception {
        String path = System.getProperty("h5_work_sys.root") + "File/temp/";
        File file = new File(path + fileName);
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
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
        file = new File(path + fileName);
        file.delete();
        return null;
    }

    //展示出勤
    private String showAttendance(int i, String attendances, String attendanceInfos) {
        int index = -1;
        String[] attendancesArray = attendances.split("\\,");
        for (int j = 0; j < attendancesArray.length; j++) {
            if (Integer.valueOf(attendancesArray[j]).equals(i)) {
                index = j;
            }
        }
        if (index == -1) {
            return 0 + "次";
        } else {
            String[] attendanceInfosArray = attendanceInfos.split("\\,");
            return attendanceInfosArray[index] + "次";
        }
    }

    //判断是否满勤
    private String isAttendanceOver(String attendances, String attendanceInfos) {
        int index = -1;
        String[] attendancesArray = attendances.split("\\,");
        for (int j = 0; j < attendancesArray.length; j++) {
            if (Integer.valueOf(attendancesArray[j]).equals(1)) {
                index = j;
            }
        }

        int sum = 0;
        String[] attendanceInfosArray = attendanceInfos.split("\\,");
        for (int i = 0; i < attendanceInfosArray.length; i++) {
            sum += Integer.valueOf(attendanceInfosArray[i]);
        }

        if (sum > 0) {
            if (index == -1) {
                return "未满勤";
            } else {
                if (Integer.valueOf(attendanceInfosArray[index]).equals(sum)) {
                    return "满勤";
                } else {
                    return "未满勤";
                }
            }
        }
        return "未满勤";
    }

    //展示作业提交
    private String showWork(int i, String works, String workInfos) {
        int index = -1;
        String[] worksArray = works.split("\\,");
        for (int j = 0; j < worksArray.length; j++) {
            if (Integer.valueOf(worksArray[j]).equals(i)) {
                index = j;
            }
        }
        if (index == -1) {
            return 0 + "次";
        } else {
            String[] workInfosArray = workInfos.split("\\,");
            return workInfosArray[index] + "次";
        }
    }

    //判断是否满交
    private String isWorkOver(String works, String workInfos) {
        int index = -1;
        String[] worksArray = works.split("\\,");
        for (int j = 0; j < worksArray.length; j++) {
            if (Integer.valueOf(worksArray[j]).equals(1)) {
                index = j;
            }
        }

        int sum = 0;
        String[] workInfosArray = workInfos.split("\\,");
        for (int i = 0; i < workInfosArray.length; i++) {
            sum += Integer.valueOf(workInfosArray[i]);
        }

        if (sum > 0) {
            if (index == -1) {
                return "未满交";
            } else {
                if (Integer.valueOf(workInfosArray[index]).equals(sum)) {
                    return "满交";
                } else {
                    return "未满交";
                }
            }
        }
        return "未满交";
    }

    /***************出勤和作业提交学生列表。便于修改***********************************************************/

    @RequestMapping(value = "toStudentAttendanceWork", method = RequestMethod.GET)
    public String toStudentAttendanceWork() {
        return "studentAttendanceWork";
    }

    @RequestMapping(value = "studentAttendanceWorkList", method = RequestMethod.GET)
    @ResponseBody
    public String studentAttendanceWorkList(ViewCourseInfo viewCourseInfo, Page page) {
        return Responses.writeJson(courseStudentService.viewCourseInfoList(viewCourseInfo, page));
    }

    /**
     * 修改状态
     *
     * @param courseInfo
     * @return
     */
    @RequestMapping(value = "updateAttendance", method = RequestMethod.POST)
    @ResponseBody
    public Map updateAttendance(CourseInfo courseInfo) {
        courseStudentService.update(courseInfo);
        return Responses.writeSuccess();
    }

}
