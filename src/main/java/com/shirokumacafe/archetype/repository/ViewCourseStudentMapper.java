package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewCourseStudent;
import com.shirokumacafe.archetype.entity.ViewCourseStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewCourseStudentMapper {
    @SelectProvider(type=ViewCourseStudentSqlProvider.class, method="countByExample")
    int countByExample(ViewCourseStudentExample example);

    @SelectProvider(type=ViewCourseStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cs_id", property="csId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewCourseStudent> selectByExampleWithRowbounds(ViewCourseStudentExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewCourseStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cs_id", property="csId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewCourseStudent> selectByExample(ViewCourseStudentExample example);
}