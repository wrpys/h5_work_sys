package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.DateTimes;
import com.shirokumacafe.archetype.entity.Test;
import com.shirokumacafe.archetype.entity.TestExample;
import com.shirokumacafe.archetype.repository.TestMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * User: wrp
 * Date: 14-12-25
 * Time: 下午10:07
 * 题目
 */
@Service
@Transactional
public class TestService {

    @Autowired
    private TestMapper testMapper;

    /**
     * 添加题目
     * @param test
     */
    public void add(Test test){
        test.setAddTime(new Date());
        if (test.getTestAnswer()==null){
            test.setTestAnswer(0);
        }
        testMapper.insert(test);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void delete(List<Integer> ids){
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdIn(ids);
        testMapper.deleteByExample(example);
    }

    /**
     * 修改题目
     * @param test
     */
    public void update(Test test){
        testMapper.updateByPrimaryKeySelective(test);
    }

    /**
     * 列表
     * @param test
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    public Page<Test> list(Test test,Date startDate,Date endDate,Page page){
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNoneBlank(test.getTestTitle())){
            criteria.andTestTitleLike("%"+test.getTestTitle()+"%");
        }
        if (startDate!=null){
            criteria.andAddTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate!=null){
            criteria.andAddTimeLessThan(DateTimes.addDate(endDate,1));
        }
        if(test.getTestAnswer()!=null){
            criteria.andTestAnswerEqualTo(test.getTestAnswer());
        }

        List<Test> rows = testMapper.selectByExampleWithRowbounds(example,page.createRowBounds());
        int results = testMapper.countByExample(example);
        page.setRows(rows);
        page.setResults(results);
        return page;
    }

    /*********************************学生端****************************************************/

    /**
     * 根据ID查找题目
     * @param ids
     * @return
     */
    public List<Test> getTestByIds(List<Integer> ids) {
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        criteria.andTestIdIn(ids);
        return testMapper.selectByExample(example);
    }

    /**
     *根据ID查找题目
     * @param testId
     * @return
     */
    public Test getTestById(Integer testId){
        return testMapper.selectByPrimaryKey(testId);
    }
}
