package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.*;
import com.shirokumacafe.archetype.repository.*;
import com.shirokumacafe.archetype.repository.terminal.MyXMLMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: wrp
 * Date: 15-1-3
 * Time: 下午8:52
 * 学生选课
 */
@Service
@Transactional
public class CourseStudentService {

    @Autowired
    private CourseStudentMapper courseStudentMapper;
    @Autowired
    private ViewCourseStudentMapper viewCourseStudentMapper;
    @Autowired
    private CourseInfoMapper courseInfoMapper;
    @Autowired
    private CourseTimeMapper courseTimeMapper;
    @Autowired
    private MyXMLMapper myXMLMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ViewCourseInfoMapper viewCourseInfoMapper;
    /**
     * 根据课程ID获取选课学生
     * @param cId
     * @return
     */
    public List<ViewCourseStudent>  getCourseStudentByCId(Integer cId){
        ViewCourseStudentExample example = new ViewCourseStudentExample();
        ViewCourseStudentExample.Criteria criteria = example.createCriteria();
        criteria.andCIdEqualTo(cId);
        return viewCourseStudentMapper.selectByExample(example);
    }

    /**
     * 选课学生
     * @param ids
     * @param cId
     */
    public void update(List<Integer>ids,Integer cId){
        //找出数据库课程ID拥有的学生,删除修改完不存在的
        CourseStudentExample example = new CourseStudentExample();
        CourseStudentExample.Criteria criteria = example.createCriteria();
        criteria.andCIdEqualTo(cId);
        List<CourseStudent> courseStudents = courseStudentMapper.selectByExample(example);


        List<Integer> oldSIds = new ArrayList<Integer>();
        for (CourseStudent courseStudent : courseStudents){
            Integer oldSId = courseStudent.getsId();
            for (Integer nowSId : ids){
                if (oldSId.equals(nowSId)){
                    oldSIds.add(oldSId);
                }
            }
        }
        if (oldSIds.size()>0){
            example = new CourseStudentExample();
            criteria = example.createCriteria();
            criteria.andCIdEqualTo(cId);
            criteria.andSIdNotIn(oldSIds);
            courseStudentMapper.deleteByExample(example);
        }

        List<Integer> nowIds = new ArrayList<Integer>();
        if(courseStudents.size()>0){
            int len = courseStudents.size();
            for (Integer nowSId : ids){
                int i=0;
                for (;i<len;i++){
                    Integer oldSId = courseStudents.get(i).getsId();
                    if (oldSId.equals(nowSId)){
                        break;
                    }
                }
                if(i==len){
                    nowIds.add(nowSId);
                }
            }
        }else{
            nowIds.addAll(ids);
        }

        for (Integer sId : nowIds){
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setcId(cId);
            courseStudent.setsId(sId);
            courseStudentMapper.insert(courseStudent);
        }
    }

    /**
     * 根据课程上课时间ID获取课程选课学生
     * @param cId
     * @return
     */
    public List<CourseStudent> getCourseStudentByCId2(Integer cId){
        CourseStudentExample example = new CourseStudentExample();
        CourseStudentExample.Criteria criteria = example.createCriteria();
        criteria.andCIdEqualTo(cId);
        return courseStudentMapper.selectByExample(example);
    }

    /**
     * 点名和录入作业提交
     * @param
     */
    public void attendanceOrWork(HttpServletRequest request,Integer cId,Integer ctId,Integer flag){
        List<CourseStudent> courseStudentList = getCourseStudentByCId2(cId);
        CourseTime courseTime = courseTimeMapper.selectByPrimaryKey(ctId);
        //点名或录入作业提交。记录存在，可以重用
        if (courseTime.getIsAttendance().equals(0)&&courseTime.getIsWork().equals(0)){
            if(flag.equals(0)){
                for (int i=0,len=courseStudentList.size();i<len;i++){
                    Integer sId = courseStudentList.get(i).getsId();
                    String attendanceStr = request.getParameter(String.valueOf(sId));
                    if (StringUtils.isNotBlank(attendanceStr)){
                        CourseInfo courseInfo = new CourseInfo();
                        courseInfo.setcId(cId);
                        courseInfo.setCtId(ctId);
                        courseInfo.setsId(sId);
                        courseInfo.setAttendanceInfo(Integer.parseInt(attendanceStr));
                        courseInfo.setWorkInfo(0);
                        courseInfoMapper.insert(courseInfo);
                    }
                }
                courseTime.setIsAttendance(1);
                courseTimeMapper.updateByPrimaryKeySelective(courseTime);
            }else {
                for (int i=0,len=courseStudentList.size();i<len;i++){
                    Integer sId = courseStudentList.get(i).getsId();
                    String workStr = request.getParameter(String.valueOf(sId));
                    if (StringUtils.isNotBlank(workStr)){
                        CourseInfo courseInfo = new CourseInfo();
                        courseInfo.setcId(cId);
                        courseInfo.setCtId(ctId);
                        courseInfo.setsId(sId);
                        courseInfo.setAttendanceInfo(0);
                        courseInfo.setWorkInfo(Integer.parseInt(workStr));
                        courseInfoMapper.insert(courseInfo);
                    }
                }
                courseTime.setIsWork(1);
                courseTimeMapper.updateByPrimaryKeySelective(courseTime);
            }
        }else{
            CourseInfoExample example = new CourseInfoExample();
            CourseInfoExample.Criteria criteria = example.createCriteria();
            criteria.andCIdEqualTo(cId);
            criteria.andCtIdEqualTo(ctId);
            List<CourseInfo> courseInfoList = courseInfoMapper.selectByExample(example);
            if(flag.equals(0)){
                for (int i=0,len=courseStudentList.size();i<len;i++){
                    Integer sId = courseStudentList.get(i).getsId();
                    String attendanceStr = request.getParameter(String.valueOf(sId));
                    for (CourseInfo courseInfo : courseInfoList){
                        if(sId.equals(courseInfo.getsId())){
                            if (StringUtils.isNotBlank(attendanceStr)){
                                courseInfo.setAttendanceInfo(Integer.parseInt(attendanceStr));
                                courseInfoMapper.updateByPrimaryKeySelective(courseInfo);
                            }
                        }
                    }
                }
                courseTime.setIsAttendance(1);
                courseTimeMapper.updateByPrimaryKeySelective(courseTime);
            } else{
                for (int i=0,len=courseStudentList.size();i<len;i++){
                    Integer sId = courseStudentList.get(i).getsId();
                    String workStr = request.getParameter(String.valueOf(sId));
                    for (CourseInfo courseInfo : courseInfoList){
                        if(sId.equals(courseInfo.getsId())){
                            if (StringUtils.isNotBlank(workStr)){
                                courseInfo.setWorkInfo(Integer.parseInt(workStr));
                                courseInfoMapper.updateByPrimaryKeySelective(courseInfo);
                            }
                        }
                    }
                }
                courseTime.setIsWork(1);
                courseTimeMapper.updateByPrimaryKeySelective(courseTime);
            }
        }
    }

/************出勤和作业提交情况***************************************************/

    /**
     *出勤情况
     * @param cId
     * @param sNo
     * @param page
     * @return
     */
    public Page getAttendanceInfoByCId(Integer cId,String sNo,Page page){
        Map map = new HashMap();
        map.put("cId",cId);
        if (StringUtils.isBlank(sNo)){
            map.put("sId",null);
        }else{
            StudentExample example = new StudentExample();
            StudentExample.Criteria criteria = example.createCriteria();
            criteria.andSNoEqualTo(sNo);
            List<Student> students = studentMapper.selectByExample(example);
            if (students.size()>0){
                map.put("sId",students.get(0).getsId());
            }else{
                map.put("sId",null);
            }
        }

        List<AttendanceWorkInfo> attendanceWorkInfos = myXMLMapper.getAttendanceInfoByCId(map);
        page.setRows(attendanceWorkInfos);
        page.setResults(attendanceWorkInfos.size());
        return page;
    }

    /**
     *作业提交情况
     * @param cId
     * @param sNo
     * @param page
     * @return
     */
    public Page getWorkInfoByCId(Integer cId,String sNo,Page page){
        Map map = new HashMap();
        map.put("cId",cId);
        if (StringUtils.isBlank(sNo)){
            map.put("sId",null);
        }else{
            StudentExample example = new StudentExample();
            StudentExample.Criteria criteria = example.createCriteria();
            criteria.andSNoEqualTo(sNo);
            List<Student> students = studentMapper.selectByExample(example);
            if (students.size()>0){
                map.put("sId",students.get(0).getsId());
            }else{
                map.put("sId",null);
            }
        }

        List<AttendanceWorkInfo> attendanceWorkInfos = myXMLMapper.getWorkInfoByCId(map);
        page.setRows(attendanceWorkInfos);
        page.setResults(attendanceWorkInfos.size());
        return page;
    }


/**************出勤和作业提交学生列表。便于修改***********************************************************/

    /**
     *获取出勤和作业提交的学生列表
     * @param viewCourseInfo
     * @param page
     * @return
     */
    public Page viewCourseInfoList(ViewCourseInfo viewCourseInfo,Page page){
        ViewCourseInfoExample example = new ViewCourseInfoExample();
        ViewCourseInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(viewCourseInfo.getsNo())){
            criteria.andSNoEqualTo(viewCourseInfo.getsNo());
        }
        if(StringUtils.isNotBlank(viewCourseInfo.getsName())){
            criteria.andSNameLike("%"+viewCourseInfo.getsName()+"%");
        }
        if (StringUtils.isNotBlank(viewCourseInfo.getcName())){
            criteria.andCNameLike("%"+viewCourseInfo.getcName()+"%");
        }

        if (viewCourseInfo.getCtTime()!=null){
            criteria.andCtTimeEqualTo(viewCourseInfo.getCtTime());
        }
        page.setResults(viewCourseInfoMapper.countByExample(example));
        page.setRows(viewCourseInfoMapper.selectByExampleWithRowbounds(example,page.createRowBounds()));
        return page;
    }

    /**
     * 修改状态
     * @param courseInfo
     */
    public void update(CourseInfo courseInfo){
        courseInfoMapper.updateByPrimaryKeySelective(courseInfo);
    }


}
