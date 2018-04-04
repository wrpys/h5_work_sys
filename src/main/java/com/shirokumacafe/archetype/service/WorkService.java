package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.DateTimes;
import com.shirokumacafe.archetype.entity.*;
import com.shirokumacafe.archetype.repository.CourseMapper;
import com.shirokumacafe.archetype.repository.WorkInfoMapper;
import com.shirokumacafe.archetype.repository.WorkMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-18
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class WorkService {

    @Autowired
    private WorkMapper workMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private WorkInfoMapper workInfoMapper;

    public void add(Work work){
        work.setwAddTime(new Date());
        Course course = courseMapper.selectByPrimaryKey(work.getcId());
        work.setcName(course.getcName());
        workMapper.insert(work);
    }

    public void delete(List<Integer> ids){
        WorkExample example = new WorkExample();
        WorkExample.Criteria criteria = example.createCriteria();
        criteria.andWIdIn(ids);
        workMapper.deleteByExample(example);
    }

    public void update(Work work){
        Course course = courseMapper.selectByPrimaryKey(work.getcId());
        work.setcName(course.getcName());
        workMapper.updateByPrimaryKeySelective(work);
    }

    public Page list(Work work,Date startDate,Date endDate,Page page){

        WorkExample example = new WorkExample();
        WorkExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(work.getcName())){
            criteria.andCNameLike("%"+work.getcName()+"%");
        }
        if(startDate!=null){
            criteria.andWAddTimeGreaterThanOrEqualTo(startDate);
        }
        if(endDate!=null){
            criteria.andWAddTimeLessThan(DateTimes.addDate(endDate,1));
        }

        page.setResults(workMapper.countByExample(example));
        page.setRows(workMapper.selectByExampleWithRowbounds(example,page.createRowBounds()));
        return page;
    }

    /**
     * 获取提交作业的学生
     * @param wId
     * @param sIds
     * @return
     */
    public List<WorkInfo> getWorkInfoByWIdInSId(Integer wId,List<Integer> sIds){
        WorkInfoExample example = new WorkInfoExample();
        WorkInfoExample.Criteria criteria = example.createCriteria();
        criteria.andWIdEqualTo(wId);
        criteria.andSIdIn(sIds);
        return workInfoMapper.selectByExample(example);
    }

    /**
     * 根据作业信息ID获取
     * @param wiId
     * @return
     */
    public WorkInfo getWorkInfoByWiId(Integer wiId){
        return workInfoMapper.selectByPrimaryKey(wiId);
    }

    /*********前台*********************************************************/

    /**
     *作业提交详情
     * @param wId
     * @param sId
     * @return
     */
    public WorkInfo getWorkInfoByWId(Integer wId,Integer sId){
        WorkInfoExample example = new WorkInfoExample();
        WorkInfoExample.Criteria criteria = example.createCriteria();
        criteria.andWIdEqualTo(wId);
        criteria.andSIdEqualTo(sId);
        List<WorkInfo> workInfos = workInfoMapper.selectByExample(example);
        if(workInfos!=null&&workInfos.size()>0){
            return workInfos.get(0);
        }
        return null;
    }

    /**
     *提交作业信息
     * @param workInfo
     */
    public void addWorkInfo(WorkInfo workInfo){
        workInfo.setWiAddTime(new Date());
        workInfoMapper.insert(workInfo);
    }

    /**
     * 修改作业信息
     * @param workInfo
     */
    public void updateWorkInfo(WorkInfo workInfo){
        workInfoMapper.updateByPrimaryKeySelective(workInfo);
    }


}
