package com.shirokumacafe.archetype.web;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.News;
import com.shirokumacafe.archetype.entity.ViewNews;
import com.shirokumacafe.archetype.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 新闻管理
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping
    public String to(){
        return "news";
    }


    /**
     * 查询列表
     * @param viewNews
     * @return
     */
    @RequestMapping(value="list",method = RequestMethod.GET)
    @ResponseBody
    public String list(ViewNews viewNews,Page page){
        Page<ViewNews> newsList = newsService.list(viewNews,page);
        return Responses.writeJson(newsList);
    }

    /**
     * 添加
     * @param news
     * @return
     */
    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(News news){
        newsService.add(news);
        return Responses.writeSuccess();
    }

    /**
     * 修改
     * @param news
     * @return
     */
    @RequestMapping(value="update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(News news){
        newsService.update(news);
        return Responses.writeSuccess();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@RequestParam(value="ids")List<Integer> ids){
        return newsService.delete(ids);
    }
}
