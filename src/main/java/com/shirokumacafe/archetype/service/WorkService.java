package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.Work;
import com.shirokumacafe.archetype.entity.WorkInfo;
import com.shirokumacafe.archetype.repository.StudentMapper;
import com.shirokumacafe.archetype.repository.terminal.WorkInfoMapper;
import com.shirokumacafe.archetype.repository.terminal.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    
    /**
     * 添加作业
     * @author CZX
     * @param work
     */
    public void add(Work work){
        work.setwAddTime(new Date());
        workMapper.insert(work);
    }
    
    /**
     * 获取所有发布的作业
     * @return
     */
    public List<Work> findAll(){
        return workMapper.findAll();
    }
    
    /**
     * 修改作业
     * @author CZX
     * @param work
     */
    public void update(Work work){
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
//        List<Student> stuList = studentMapper.getWorkAnalysis(work);
//        return stuList;
        return null;
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
