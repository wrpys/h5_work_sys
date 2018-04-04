//package com.shirokumacafe.archetype.web.api;
//
//import com.shirokumacafe.archetype.common.utilities.Responses;
//import com.shirokumacafe.archetype.entity.FileUploadStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//
///**
// * Created with IntelliJ IDEA.
// * User: wrp
// * Date: 15-1-5
// * Time: 下午2:47
// * To change this template use File | Settings | File Templates.
// */
//@Controller
//@RequestMapping(value = "/uploadDown")
//public class UploadDownController {
//
//    /**
//     * 上传进度获取
//     * @param session
//     * @return
//     */
//    @RequestMapping(value = "getProgress",method = RequestMethod.POST)
//    @ResponseBody
//    public String getProgress(HttpSession session){
//        FileUploadStatus status = (FileUploadStatus) session.getAttribute("status");
//        return Responses.writeJson(status);
//    }
//
//
//}
