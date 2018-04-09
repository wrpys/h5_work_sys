package com.shirokumacafe.archetype.repository.terminal;

import java.util.List;

import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.Work;

public interface StuMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	List<Student> getWorkAnalysis(Work work);
}