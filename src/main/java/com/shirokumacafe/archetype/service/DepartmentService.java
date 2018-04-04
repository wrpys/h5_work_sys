package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.entity.Department;
import com.shirokumacafe.archetype.entity.DepartmentExample;
import com.shirokumacafe.archetype.repository.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: wrp
 * Date: 14-12-20
 * Time: 下午10:07
 * 系别专业
 */
@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取全部系别专业
     * @return
     */
    public List<Department> findAll(){
        return departmentMapper.selectByExample(null);
    }

    /**
     * 添加系别或专业
     * @param department
     */
    public void add(Department department){
        departmentMapper.insert(department);
    }

    /**
     *修改系别或专业
     * @param department
     */
    public void update(Department department){
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    /**
     *删除系别或专业
     * @param dId
     */
    public Department delete(Integer dId){
        Department department = departmentMapper.selectByPrimaryKey(dId);
        departmentMapper.deleteByPrimaryKey(dId);
        return department;
    }

    /**
     *获取系别
     * @return
     */
    public List<Department> getParentDepartment(){
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDPidEqualTo(0);
        return departmentMapper.selectByExample(example);
    }

    /**
     * 根据系别查找对应专业
     * @param dPid
     * @return
     */
    public List<Department> getDepartmentByDPid(Integer dPid){
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDPidEqualTo(dPid);
        return departmentMapper.selectByExample(example);
    }

}
