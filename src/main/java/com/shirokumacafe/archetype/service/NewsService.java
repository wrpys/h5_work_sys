package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.mybatis.PageFront;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.News;
import com.shirokumacafe.archetype.entity.NewsExample;
import com.shirokumacafe.archetype.entity.ViewNews;
import com.shirokumacafe.archetype.entity.ViewNewsExample;
import com.shirokumacafe.archetype.repository.NewsMapper;
import com.shirokumacafe.archetype.repository.ViewNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 新闻管理
 */
@Service
@Transactional
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private ViewNewsMapper viewNewsMapper;
    @Autowired
    private Users sessionUsers;

    /**
     * 查询列表
     *
     * @param viewNews
     * @return
     */
    public Page<ViewNews> list(ViewNews viewNews, Page page) {
        ViewNewsExample example = new ViewNewsExample();
        ViewNewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsTitleLike("%" + viewNews.getNewsTitle() + "%");
        example.setOrderByClause("add_time desc");
        List<ViewNews> newsList = viewNewsMapper.selectByExampleWithBLOBsWithRowbounds(example, page.createRowBounds());
        int count = viewNewsMapper.countByExample(example);
        page.setRows(newsList);
        page.setResults(count);
        return page;
    }

    /**
     * 添加
     *
     * @param news
     */
    public void add(News news) {
        news.setAddUser(sessionUsers.getCurrentUser().getUserId());
        news.setAddTime(new Date());
        newsMapper.insertSelective(news);
    }

    /**
     * 修改
     *
     * @param news
     */
    public void update(News news) {
        newsMapper.updateByPrimaryKeyWithBLOBs(news);
    }

    /**
     * 删除
     *
     * @param ids
     */
    public Map delete(List<Integer> ids) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsIdIn(ids);
        newsMapper.deleteByExample(example);
        return Responses.writeSuccess();
    }

    /**
     * 前台新闻
     *
     * @param pageFront
     * @return
     */
    public PageFront listFront(PageFront pageFront) {
        ViewNewsExample example = new ViewNewsExample();
        example.setOrderByClause("add_time desc");
        List<ViewNews> rows = viewNewsMapper.selectByExampleWithBLOBsWithRowbounds(example, pageFront.createRowBounds());
        int results = viewNewsMapper.countByExample(example);
        pageFront.setRows(rows);
        pageFront.setResults(results);
        pageFront.setTotalPage(results);
        return pageFront;
    }

    /**
     * 新闻详情
     *
     * @param newsId
     * @return
     */
    public ViewNews getNewsByNewsId(Integer newsId) {
        ViewNewsExample example = new ViewNewsExample();
        ViewNewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsIdEqualTo(newsId);
        return viewNewsMapper.selectByExampleWithBLOBs(example).get(0);

    }
}
