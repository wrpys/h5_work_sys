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
import com.shirokumacafe.archetype.repository.ClzssMapper;
import com.shirokumacafe.archetype.repository.StudentMapper;
import com.shirokumacafe.archetype.repository.WorkInfoMapper;
import com.shirokumacafe.archetype.repository.WorkMapper;

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
    private StudentMapper studentMapper;
    
    @Autowired
    private ClzssMapper clzssMapper;
    
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
     * @param workInfo
     * @return
     */
    public WorkInfo getWorkInfoByWiIdAndStuId(WorkInfo workInfo){
        return workInfoMapper.getWorkInfoByWiIdAndStuId(workInfo);
    }
    
	public List<Student> getWorkAnalysis(Work work) {
        List<Student> stuList = studentMapper.getWorkAnalysis(work);
        return stuList;
    }
    /**
     * 获取所有要做作业的学生列表信息:clzssId来获取所有应该提交的studentId
     * @author CZX
     * @param work
     * @return
     */
	public List<Student> getAllToDoWorkList(Work work) {
        Student student = new Student();
        student.setClzssId(work.getClzssId());
		List<Student> stuList = studentMapper.selectByParams(student);
		return stuList;
	}

    public Work getWork(Integer wId) {
        return workMapper.selectByPrimaryKey(wId);
    }

}
