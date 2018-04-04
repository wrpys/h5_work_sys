package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewCourse;
import com.shirokumacafe.archetype.entity.ViewCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewCourseMapper {
    @SelectProvider(type=ViewCourseSqlProvider.class, method="countByExample")
    int countByExample(ViewCourseExample example);

    @SelectProvider(type=ViewCourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="c_attend_addr", property="cAttendAddr", jdbcType=JdbcType.INTEGER),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="aa_name", property="aaName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewCourse> selectByExampleWithRowbounds(ViewCourseExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewCourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="c_attend_addr", property="cAttendAddr", jdbcType=JdbcType.INTEGER),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="aa_name", property="aaName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewCourse> selectByExample(ViewCourseExample example);
}