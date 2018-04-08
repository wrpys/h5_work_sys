package com.shirokumacafe.archetype.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shirokumacafe.archetype.common.Configs;
import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.StudentExample;
import com.shirokumacafe.archetype.entity.ViewStudent;
import com.shirokumacafe.archetype.entity.ViewStudentExample;
import com.shirokumacafe.archetype.repository.StudentMapper;
import com.shirokumacafe.archetype.repository.ViewStudentMapper;

/**
 * 学生信息
 * User: wrp
 * Date: 14-12-18
 * Time: 下午10:51
 */
@Service
@Transactional
public class StudentService {

    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ViewStudentMapper viewStudentMapper;

    /**
     * 增加学生  默认密码123456
     *
     * @param student
     */
    public void add(Student student) {
        student.setUserRole(Configs.CUSTOMER_STUDENT);
        student.setsPassword(Configs.DEFAULT_PASSWORD);
        studentMapper.insert(student);
    }

    /**
     * 批量删除
     *
     * @param sIds
     */
    public void delete(List<Integer> sIds) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andSIdIn(sIds);
        studentMapper.deleteByExample(example);
    }

    /**
     * 修改
     *
     * @param student
     */
    public void update(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    /**
     * 分页查找
     *
     * @param student
     * @param page
     * @return
     */
    public Page<ViewStudent> findPage(Student student, Page page) {
        ViewStudentExample example = new ViewStudentExample();
        ViewStudentExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(student.getsNo())) {
            criteria.andSNoLike("%" + student.getsNo() + "%");
        }
        if (StringUtils.isNotBlank(student.getsName())) {
            criteria.andSNameLike("%" + student.getsName() + "%");
        }
        if (student.getsSex() != null) {
            criteria.andSSexEqualTo(student.getsSex());
        }
        if (student.getdId() != null) {
            criteria.andDIdEqualTo(student.getdId());
        }
        example.setOrderByClause("s_no asc");
        List<ViewStudent> rows = viewStudentMapper.selectByExampleWithRowbounds(example, page.createRowBounds());
        int results = viewStudentMapper.countByExample(example);
        page.setRows(rows);
        page.setResults(results);
        return page;
    }

    /**
     * 批量重置密码
     */
    public void resetPassword(List<Integer> ids) {
        Student student = new Student();
        student.setsPassword(Configs.DEFAULT_PASSWORD);
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andSIdIn(ids);
        studentMapper.updateByExampleSelective(student, example);
    }

/***************前台*****************************************************/

    /**
     * 登录
     *
     * @return
     */
    public Map login(String sNo, String sPassword, HttpSession session) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andSNoEqualTo(sNo);
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size() > 0) {
            Student student = students.get(0);
            if (!student.getsPassword().equals(sPassword)) {
                return Responses.writeFailAndMsg("账户名或密码错误!");
            } else {
                session.setAttribute("student", student);
                return Responses.writeSuccess();
            }
        } else {
            return Responses.writeFailAndMsg("该账户不存在！");
        }
    }


    /**
     * 学生信息
     *
     * @param sId
     * @return
     */
    public ViewStudent getStudentBySId(Integer sId) {
        ViewStudentExample example = new ViewStudentExample();
        ViewStudentExample.Criteria criteria = example.createCriteria();
        criteria.andSIdEqualTo(sId);
        return viewStudentMapper.selectByExample(example).get(0);
    }

}
