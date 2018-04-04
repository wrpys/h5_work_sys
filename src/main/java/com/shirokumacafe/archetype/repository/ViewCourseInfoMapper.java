package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewCourseInfo;
import com.shirokumacafe.archetype.entity.ViewCourseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewCourseInfoMapper {
    @SelectProvider(type=ViewCourseInfoSqlProvider.class, method="countByExample")
    int countByExample(ViewCourseInfoExample example);

    @SelectProvider(type=ViewCourseInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ci_id", property="ciId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance_info", property="attendanceInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="work_info", property="workInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct_time", property="ctTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ViewCourseInfo> selectByExampleWithRowbounds(ViewCourseInfoExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewCourseInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ci_id", property="ciId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance_info", property="attendanceInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="work_info", property="workInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct_time", property="ctTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ViewCourseInfo> selectByExample(ViewCourseInfoExample example);
}