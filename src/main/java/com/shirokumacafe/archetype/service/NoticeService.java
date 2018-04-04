package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.mybatis.PageFront;
import com.shirokumacafe.archetype.entity.Notice;
import com.shirokumacafe.archetype.entity.NoticeExample;
import com.shirokumacafe.archetype.entity.ViewNotice;
import com.shirokumacafe.archetype.entity.ViewNoticeExample;
import com.shirokumacafe.archetype.repository.NoticeMapper;
import com.shirokumacafe.archetype.repository.ViewNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 公告管理
 */
@Service
@Transactional
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private ViewNoticeMapper viewNoticeMapper;
    @Autowired
    private Users sessionUsers;

    /**
     * 查询公告列表
     *
     * @param viewNotice
     * @return
     */
    public Page<ViewNotice> list(ViewNotice viewNotice, Page page) {
        ViewNoticeExample example = new ViewNoticeExample();
        ViewNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeTitleLike("%" + viewNotice.getNoticeTitle() + "%");
        example.setOrderByClause("add_time desc");
        List<ViewNotice> noticeList = viewNoticeMapper.selectByExampleWithBLOBsWithRowbounds(example, page.createRowBounds());
        int count = viewNoticeMapper.countByExample(example);
        page.setRows(noticeList);
        page.setResults(count);
        return page;
    }

    /**
     * 添加公告
     *
     * @param notice
     */
    public void add(Notice notice) {
        notice.setAddUser(sessionUsers.getCurrentUser().getUserId());
        notice.setAddTime(new Date());
        noticeMapper.insertSelective(notice);
    }

    /**
     * 修改公告
     *
     * @param notice
     */
    public void update(Notice notice) {
        noticeMapper.updateByPrimaryKeyWithBLOBs(notice);
    }

    /**
     * 删除公告
     *
     * @param ids
     */
    public void delete(List<Integer> ids) {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeIdIn(ids);
        noticeMapper.deleteByExample(example);
    }


    /**
     * 前台公告
     *
     * @param pageFront
     * @return
     */
    public PageFront listFront(PageFront pageFront) {
        ViewNoticeExample example = new ViewNoticeExample();
        example.setOrderByClause("add_time desc");
        List<ViewNotice> rows = viewNoticeMapper.selectByExampleWithBLOBsWithRowbounds(example, pageFront.createRowBounds());
        int results = viewNoticeMapper.countByExample(example);
        pageFront.setResults(results);
        pageFront.setRows(rows);
        pageFront.setTotalPage(results);
        return pageFront;
    }

    /**
     * 公告详情
     *
     * @param noticeId
     * @return
     */
    public ViewNotice getNoticeById(Integer noticeId) {
        ViewNoticeExample example = new ViewNoticeExample();
        ViewNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeIdEqualTo(noticeId);
        return viewNoticeMapper.selectByExampleWithBLOBs(example).get(0);
    }

}
