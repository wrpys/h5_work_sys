//package com.shirokumacafe.archetype.web.api;
//
//import com.shirokumacafe.archetype.common.mybatis.PageFront;
//import com.shirokumacafe.archetype.common.utilities.Responses;
//import com.shirokumacafe.archetype.entity.*;
//import com.shirokumacafe.archetype.common.Configs;
//import com.shirokumacafe.archetype.repository.terminal.MyXMLMapper;
//import com.shirokumacafe.archetype.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.OutputStream;
//import java.util.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: wrp
// * Date: 14-12-25
// * Time: 下午10:37
// * To change this template use FileService | Settings | FileService Templates.
// */
///**
// * 前台入口
// */
//@Controller
//@RequestMapping(value = "/front")
//public class FrontAction {
//
//    @Autowired
//    private TestService testService;
//    @Autowired
//    private FileService fileService;
//    @Autowired
//    private StudentService studentService;
//    @Autowired
//    private NoticeService noticeService;
//    @Autowired
//    private NewsService newsService;
//
//    @Autowired
//    private MyXMLMapper myMapper;
//    @Autowired
//    private MessageService messageService;
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 首页
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "toIndex",method=RequestMethod.GET)
//    public String toIndex(Model model){
//        PageFront pageFront = new PageFront();
//        pageFront.setLimit(5);
//        model.addAttribute("noticeList", noticeService.listFront(pageFront).getRows());
//        model.addAttribute("newsList",newsService.listFront(pageFront).getRows());
//        model.addAttribute("fileNewest",fileService.newestOrHottest("newest"));
//        model.addAttribute("fileHottest",fileService.newestOrHottest("hottest"));
//        return "front/index";
//    }
//
///******************************简介****************************************************************************/
//    @RequestMapping(value = "toBriefIntroduction",method=RequestMethod.GET)
//    public String toBriefIntroduction(Model model){
//        model.addAttribute("active","jianjie");
//        return "front/briefIntroduction";
//    }
//
///***********************资源下载******************************************************************************/
//    /**
//     * 资源下载页面
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "toFileIndex",method=RequestMethod.GET)
//    public String toFileIndex(Model model){
//        model.addAttribute("active","fileIndex");
//        List<ViewFileType> viewFileTypes = fileService.getViewFileTypeAll();
//        model.addAttribute("fileTypes",viewFileTypes);
//        model.addAttribute("files",fileService.getFileListFront(viewFileTypes));
//        return "front/fileIndex";
//    }
//
//    /**
//     * 下载文件
//     * @param
//     * @param response
//     */
//    @RequestMapping(value = "downFile",method=RequestMethod.GET)
//    public String downFile(Integer fileId,HttpServletResponse response) throws  Exception{
//        Files files = fileService.getFilesByFileId(fileId);
//        String realPath = System.getProperty("h5_work_sys.root") + files.getFileAddr();
//        File file = new File(realPath);
//        if (!file.exists()) {
//            response.sendError(404, "File not found!");
//            return null;
//        }
//        response.reset();
//        response.setContentType("application/x-msdownload");
//        response.setHeader("Content-Disposition","attachment; filename=" + new String(files.getFileName().getBytes(),"ISO-8859-1"));
//        byte[] buf = new byte[1024];
//        int len = 0;
//        BufferedInputStream br = null;
//        OutputStream out = null;
//        br = new BufferedInputStream(new FileInputStream(file));
//        out = response.getOutputStream();
//        while ((len = br.read(buf)) > 0) {
//            out.write(buf, 0, len);
//        }
//        out.flush();
//        if (br != null) {
//            br.close();
//            br = null;
//        }
//        if (out != null) {
//            out.close();
//            out = null;
//        }
//        files.setFileDownNum(files.getFileDownNum()+1);
//        fileService.updateFile(files);
//        return null;
//    }
//
//    /**                                                                                                                    .
//     * 资源类别查找
//     * @param ftId
//     * @return
//     */
//    @RequestMapping(value = "toFileTypeIndex",method=RequestMethod.GET)
//    public String toFileTypeIndex(Integer ftId,Model model,PageFront pageFront,HttpServletRequest request){
//        model.addAttribute("active","fileIndex");
//        model.addAttribute("fileType", fileService.getViewFileTypeByFtId(ftId));
//        model.addAttribute("fileList",fileService.getViewFileByFtId(ftId,pageFront).getRows());
//        pageFront.pagetoolFront(pageFront, request);
//        return "front/fileTypeIndex";
//    }
//
///*************个人中心*******************************************************************************/
//    /**
//     * 判断是否登陆
//     * @param request
//     * @return
//     */
//    private Boolean checkLogin(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        Student student = (Student)session.getAttribute("student");
//        if (student!=null){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 判断是否登录
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "isLogin",method=RequestMethod.GET)
//    @ResponseBody
//    public Map isLogin(HttpServletRequest request){
//        return Responses.writeSuccess(checkLogin(request),"isLogin");
//    }
//
//    /**
//     * 登陆
//     * @return
//     */
//    @RequestMapping(value = "studentLogin",method=RequestMethod.POST)
//    @ResponseBody
//    public Map studentLogin(String sNo,String sPassword,HttpSession session){
//        return studentService.login(sNo,sPassword,session);
//    }
//
//    /**
//     * 登出
//     * @return
//     */
//    @RequestMapping(value = "studentLogout",method=RequestMethod.GET)
//    public String studentLogout(HttpSession session){
//        session.removeAttribute("student");
//        return "redirect:toIndex";
//    }
//
//    @RequestMapping(value = "toStudentHome",method=RequestMethod.GET)
//    public String toStudentHome(HttpServletRequest request,Model model){
//        if (checkLogin(request)){
//            model.addAttribute("active","studentHome");
//            return "front/studentHome";
//        }else{
//            return "front/index";
//        }
//    }
//
//
///*****************答题********************************************************************************/
//    /**
//     * 考试页面
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "toTest",method=RequestMethod.GET)
//    public String toTest(Model model){
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//        ids.add(3);
//        ids.add(5);
//        ids.add(6);
//        model.addAttribute("testIds", Responses.writeJson(ids));
//        System.out.println("-------------------------------------------------");
//        System.out.println(Responses.writeJson(ids));
//        System.out.println("-------------------------------------------------");
//        model.addAttribute("testList",testService.getTestByIds(ids));
//        return "front/test";
//    }
//
//
//
//    /**
//     * 提交试卷
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "submitTest",method=RequestMethod.POST)
//    public String submitTest(Model model,HttpServletRequest request,String ids){
//        ids = ids.substring(1,ids.length()-1);
//        String[] testIdsArrayString = ids.split("\\,");
//
//        List<Test> tests = new ArrayList<Test>();
//        for(int i=0,len=testIdsArrayString.length;i<len;i++){
//            Test test = new Test();
//            test.setTestId(Integer.parseInt(testIdsArrayString[i]));
//            tests.add(test);
//        }
//        for (int i=0,len=tests.size();i<len;i++){
//            Integer trueAnswer = Integer.parseInt(request.getParameter(tests.get(i).getTestId().toString()));
//            Test test = testService.getTestById(tests.get(i).getTestId());
//            test.setTrueAnswer(trueAnswer);
//            tests.set(i,test);
//        }
//        model.addAttribute("testList",tests);
//        return "front/test";
//    }
//
///***********************************公告************************************************/
//
//    @RequestMapping(value = "toNoticeIndex",method=RequestMethod.GET)
//    public String toNoticeIndex(Model model,PageFront pageFront,HttpServletRequest request){
//        pageFront = noticeService.listFront(pageFront);
//        model.addAttribute("noticeList", pageFront.getRows());
//        pageFront.pagetoolFront(pageFront,request);
//        model.addAttribute("active","noticeIndex");
//        return "front/noticeIndex";
//    }
//
//    @RequestMapping(value = "noticeDetail",method = RequestMethod.GET)
//    public String noticeDetail(Model model,Integer noticeId){
//        model.addAttribute("notice",noticeService.getNoticeById(noticeId));
//        model.addAttribute("active","noticeIndex");
//        return "front/noticeDetail";
//    }
//
///********************************新闻******************************************************/
//    @RequestMapping(value = "toNewsIndex",method=RequestMethod.GET)
//    public String toNewsIndex(Model model,PageFront pageFront,HttpServletRequest request){
//        pageFront = newsService.listFront(pageFront);
//        model.addAttribute("newsList", pageFront.getRows());
//        pageFront.pagetoolFront(pageFront,request);
//        model.addAttribute("active","newsIndex");
//        return "front/newsIndex";
//    }
//
//    @RequestMapping(value = "newsDetail",method = RequestMethod.GET)
//    public String newsDetail(Model model,Integer newsId){
//        model.addAttribute("news",newsService.getNewsByNewsId(newsId));
//        model.addAttribute("active","newsIndex");
//        return "front/newsDetail";
//    }
//
///*******************个人中心********************************************************************/
//
//    @RequestMapping(value = "toHomeIndex",method = RequestMethod.GET)
//    public String toHomeIndex(Model model,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        ViewNotice viewNotice = myMapper.getNoticeNow();
//        model.addAttribute("notice",viewNotice);
//        Student student = (Student)session.getAttribute("student");
//        model.addAttribute("notReadMessage", messageService.countNotReadMessage(student.getsId(),Configs.CUSTOMER_TEACHER));
//        return "front/homeIndex";
//    }
//
//    /**
//     * 我的信息
//     * @param model
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "toStudentInfo",method = RequestMethod.GET)
//    public String toStudentInfo(Model model,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        model.addAttribute("studentInfo",studentService.getStudentBySId(student.getsId()));
//        return "front/studentInfo";
//    }
//
///********************留言****************************************************/
//
//    /**
//     * 我的消息
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "toMessageIndex",method = RequestMethod.GET)
//    public String toMessageIndex(Model model,PageFront pageFront,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        pageFront = messageService.forntList(pageFront,student.getsId());
//        model.addAttribute("messageList",pageFront.getRows());
//        pageFront.pagetoolFront(pageFront,request);
//        return "front/messageIndex";
//    }
//
//    /**
//     * 留言
//     * @return
//     */
//    @RequestMapping(value = "toStudentAddMessage",method = RequestMethod.GET)
//    public String toStudentAddMessage(Model model,Integer msgPid){
//        model.addAttribute("teachers",userService.getUsersByRoleId(Configs.CUSTOMER_TEACHER));
//        model.addAttribute("msgPid",msgPid);
//        return "front/studentAddMessage";
//    }
//
//    /**
//     * 学生留言
//     * @param message
//     * @return
//     */
//    @RequestMapping(value = "studentAdd",method = RequestMethod.POST)
//    public String studentAdd(Model model,Message message,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        message.setStudentId(student.getsId());
//
//        String toAction = "redirect:toMessageIndex";
//        if (message.getMsgPid()!=null){
//            model.addAttribute("msgId",message.getMsgId());
//            toAction = "redirect:messageDetail";
//        }
//        messageService.studentAdd(message);
//        return toAction;
//    }
//
//    /**
//     * 留言详情
//     * @param msgId
//     * @param model
//     * @param request
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "messageDetail",method = RequestMethod.GET)
//    public String messageDetail(Integer msgId,Model model,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        List<ViewMessage> viewMessages = messageService.frontReplyList(msgId);
//        for (ViewMessage viewMessage : viewMessages){
//            if (viewMessage.getSendRole().equals(Configs.CUSTOMER_TEACHER)){
//                Message message = new Message();
//                message.setMsgId(viewMessage.getMsgId());
//                message.setMsgIsRead(1);
//                messageService.update(message);
//            }
//        }
//        model.addAttribute("msgPid",messageService.getMsgPid(msgId));
//        model.addAttribute("msgId",msgId);
//        model.addAttribute("replyList",viewMessages);
//        return "front/messageDetail";
//    }
//
//
///****************课程查询********************************************************************/
//    @RequestMapping(value = "toCourseIndex",method = RequestMethod.GET)
//    public String toCourseIndex(Model model,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        model.addAttribute("courses",myMapper.getCourseBySId(student.getsId()));
//        return "front/courseIndex";
//    }
//
//    @RequestMapping(value = "toAttendanceWorkIndex",method = RequestMethod.GET)
//    public String toAttendanceWorkIndex(Integer cId,Model model,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        Map map = new HashMap();
//        map.put("cId",cId);
//        map.put("sId",student.getsId());
//        model.addAttribute("attendanceWorks",myMapper.getAttendanceWorkByCIdAndSId(map));
//        return "front/attendanceWorkIndex";
//    }
//
///********************作业提交*****************************************************************/
//
//    @Autowired
//    private WorkService workService;
//
//    /**
//     * 作业列表
//     * @param model
//     * @param request
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "toWorkIndex",method = RequestMethod.GET)
//    public String toWorkIndex(Model model,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        model.addAttribute("works",myMapper.getWorkBySId(student.getsId()));
//        return "front/workIndex";
//    }
//
//    /**
//     * 作业详情
//     * @param model
//     * @param wId
//     * @param request
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "toSubmitWork",method = RequestMethod.GET)
//    public String toSubmitWork(Model model,Integer wId,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        Student student = (Student)session.getAttribute("student");
//        model.addAttribute("wId",wId);
//        model.addAttribute("workInfo",workService.getWorkInfoByWId(wId,student.getsId()));
//        return "front/submitWork";
//    }
//
//    /**
//     * 提交作业
//     * @param workInfo
//     * @param request
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "submitWork",method = RequestMethod.POST)
//    public String submitWork(Model model,WorkInfo workInfo,HttpServletRequest request,HttpSession session){
//        if (!checkLogin(request)){
//            return "front/index";
//        }
//        if(workInfo.getWiId()!=null){
//            workService.updateWorkInfo(workInfo);
//        }else{
//            Student student = (Student)session.getAttribute("student");
//            workInfo.setsId(student.getsId());
//            workService.addWorkInfo(workInfo);
//            model.addAttribute("wId",workInfo.getwId());
//        }
//        return "redirect:toSubmitWork?wId="+workInfo.getwId();
//    }
//
//
//}