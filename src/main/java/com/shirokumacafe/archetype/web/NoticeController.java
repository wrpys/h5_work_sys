package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Notice;
import com.shirokumacafe.archetype.entity.ViewNotice;
import com.shirokumacafe.archetype.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
* 公告管理
*/
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping
    public String to(){
        return "notice";
    }


    /**
     * 查询公告列表
     * @param viewNotice
     * @return
     */
    @RequestMapping(value="list",method = RequestMethod.GET)
    @ResponseBody
    public String list(ViewNotice viewNotice,Page page){
        Page<ViewNotice> noticeList = noticeService.list(viewNotice,page);
        return Responses.writeJson(noticeList);
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(Notice notice){
        noticeService.add(notice);
        return Responses.writeSuccess();
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @RequestMapping(value="update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(Notice notice){
        noticeService.update(notice);
        return Responses.writeSuccess();
    }

    /**
     * 删除公告
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@RequestParam(value="ids")List<Integer> ids){
        noticeService.delete(ids);
        return Responses.writeSuccess();
    }
}
