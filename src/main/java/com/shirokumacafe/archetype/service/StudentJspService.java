package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.mybatis.PageFront;
import com.shirokumacafe.archetype.entity.StudentJsp;
import com.shirokumacafe.archetype.entity.StudentJspExample;
import com.shirokumacafe.archetype.repository.StudentJspMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: wrp
 * Date: 15-3-27
 * Time: 下午9:50
 * 学生管理，jsp检测使用
 */
@Service
@Transactional
public class StudentJspService {

    @Autowired
    private StudentJspMapper studentJspMapper;

    /**
     * 增加学生
     * @param studentJsp
     */
    public void add(StudentJsp studentJsp){
        studentJspMapper.insert(studentJsp);
    }

    /**
     * 修改学生
     * @param studentJsp
     */
    public void update(StudentJsp studentJsp){
        studentJspMapper.updateByPrimaryKeySelective(studentJsp);
    }

    /**
     * 删除学生
     * @param sId
     */
    public void delete(Integer sId){
        studentJspMapper.deleteByPrimaryKey(sId);
    }

    /**
     * 分页展示学生列表。提供sNo,sName的模糊查询。
     * @param studentJsp
     * @param pageFront
     * @return
     */
    public PageFront<StudentJsp> list(StudentJsp studentJsp,PageFront pageFront){
        StudentJspExample example = new StudentJspExample();
        StudentJspExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(studentJsp.getsNo())){
            criteria.andSNoLike("%"+studentJsp.getsNo()+"%");
        }
        if (StringUtils.isNotBlank(studentJsp.getsName())){
            criteria.andSNameLike("%" + studentJsp.getsName() + "%");
        }

        int result = studentJspMapper.countByExample(example);
        pageFront.setResults(result);
        pageFront.setTotalPage(result);
        pageFront.setRows(studentJspMapper.selectByExampleWithRowbounds(example,pageFront.createRowBounds()));

        return pageFront;
    }



}
