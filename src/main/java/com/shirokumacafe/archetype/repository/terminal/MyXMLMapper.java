package com.shirokumacafe.archetype.repository.terminal;

import com.shirokumacafe.archetype.entity.AttendanceWorkInfo;
import com.shirokumacafe.archetype.entity.ViewNotice;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-5
 * Time: 上午10:30
 * To change this template use File | Settings | File Templates.
 */
public interface MyXMLMapper {
    ViewNotice getNoticeNow();
    List<AttendanceWorkInfo> getAttendanceInfoByCId(Map map);
    List<AttendanceWorkInfo> getWorkInfoByCId(Map map);

    List<Map> getCourseBySId(Integer sId);

    List<Map> getAttendanceWorkByCIdAndSId(Map map);

    List<Map> getWorkBySId(Integer sId);

    List<Map> getCourseStudentByWId(Map map);
}
