package com.shirokumacafe.archetype.repository.terminal;

import java.util.List;

import com.shirokumacafe.archetype.entity.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer wId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer wId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

	void deleteWorkList(List<Integer> ids);
	
	List<Work> selectByParams(Work work);
}