package com.shirokumacafe.archetype.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.shirokumacafe.archetype.common.Users;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.entity.Clzss;
import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.entity.Work;
import com.shirokumacafe.archetype.entity.WorkInfo;
import com.shirokumacafe.archetype.repository.terminal.ClzssManagementMapper;
import com.shirokumacafe.archetype.repository.terminal.StuMapper;
import com.shirokumacafe.archetype.repository.terminal.WorkInfoMapper;
import com.shirokumacafe.archetype.repository.terminal.WorkMapper;

/**
 * 作业管理：出作业题，查看作业结果，统计分析作业情况
 * @author CZX
 *
 */
@Service
@Transactional
public class WorkService {

    @Autowired
    private WorkMapper workMapper;
    
    @Autowired
    private WorkInfoMapper workInfoMapper;
    
    @Autowired
    private StuMapper stuMapper;
    
    @Autowired
    private ClzssManagementMapper clzssMapper;
    
    @Autowired
    private Users sessionUsers;
    
    /**
     * 添加作业
     * @author CZX
     * @param work
     */
    public void add(Work work,String grade,String clzss){
    	User user = sessionUsers.getCurrentUser();
    	Clzss clz =  clzssMapper.selectClzssByGradeAndClzss(grade, clzss);
    	work.setUserTchId(user.getUserId());
        work.setwAddTime(new Date());
        work.setClzssId(clz.getId());
        workMapper.insert(work);
    }
    
    /**
     * 获取所有发布的作业
     * @return
     */
    public Page<Work> list(Work work, Page<Work> page){
    	com.github.pagehelper.Page<?> pageHelper = PageHelper.startPage(page.getPageIndex(), page.getLimit());
    	List<Work> workList = workMapper.selectByParams(work);
    	page.setRows(workList);
        page.setResults((int)pageHelper.getTotal());
        return page;
    }
    
    /**
     * 修改作业
     * @author CZX
     * @param work
     */
    public void update(Work work,String grade,String clzss){
    	User user = sessionUsers.getCurrentUser();
    	Clzss clz =  clzssMapper.selectClzssByGradeAndClzss(grade, clzss);
    	work.setUserTchId(user.getUserId());
        work.setwAddTime(new Date());
        work.setClzssId(clz.getId());
        workMapper.updateByPrimaryKeySelective(work);
    }
    
    /**
     * 删除作业
     * @author CZX
     * @param ids
     */
    public void delete(List<Integer> ids){
        workMapper.deleteWorkList(ids);
    }

    /**
     * 根据作业信息ID和studen_id获取
     * @author CZX
     * @param wiId
     * @return
     */
    public WorkInfo getWorkInfoByWiIdAndStuId(WorkInfo workInfo){
        return workInfoMapper.getWorkInfoByWiIdAndStuId(workInfo);
    }
    
    
	public List<Student> getWorkAnalysis(Work work) {
		List<Student> stuList = stuMapper.getWorkAnalysis(work);
		return stuList;
	}

    
//-----------------------------------------------------------------------------------------------------------------------------------    
    
    /*********前台*********************************************************/

    /**
     *作业提交详情
     * @param wId
     * @param sId
     * @return
     */
    /*public WorkInfo getWorkInfoByWId(Integer wId,Integer sId){
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
    

    *//**
     * 获取提交作业的学生
     * @param wId
     * @param sIds
     * @return
     *//*
    public List<WorkInfo> getWorkInfoByWIdInSId(Integer wId,List<Integer> sIds){
        WorkInfoExample example = new WorkInfoExample();
        WorkInfoExample.Criteria criteria = example.createCriteria();
        criteria.andWIdEqualTo(wId);
        criteria.andSIdIn(sIds);
        return workInfoMapper.selectByExample(example);
    }

    *//**
     *提交作业信息
     * @param workInfo
     *//*
    public void addWorkInfo(WorkInfo workInfo){
        workInfo.setWiAddTime(new Date());
        workInfoMapper.insert(workInfo);
    }

    *//**
     * 修改作业信息
     * @param workInfo
     *//*
    public void updateWorkInfo(WorkInfo workInfo){
        workInfoMapper.updateByPrimaryKeySelective(workInfo);
    }

    

    *//**
     * 根据作业信息ID获取
     * @param wiId
     * @return
     *//*
    public WorkInfo getWorkInfoByWiId(Integer wiId){
        return workInfoMapper.selectByPrimaryKey(wiId);
    }*/

}
