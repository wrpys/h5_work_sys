package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewAttendanceWork;
import com.shirokumacafe.archetype.entity.ViewAttendanceWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewAttendanceWorkMapper {
    @SelectProvider(type=ViewAttendanceWorkSqlProvider.class, method="countByExample")
    int countByExample(ViewAttendanceWorkExample example);

    @SelectProvider(type=ViewAttendanceWorkSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance", property="attendance", jdbcType=JdbcType.INTEGER),
        @Result(column="work", property="work", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_attendance", property="isAttendance", jdbcType=JdbcType.INTEGER),
        @Result(column="is_work", property="isWork", jdbcType=JdbcType.INTEGER)
    })
    List<ViewAttendanceWork> selectByExampleWithRowbounds(ViewAttendanceWorkExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewAttendanceWorkSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance", property="attendance", jdbcType=JdbcType.INTEGER),
        @Result(column="work", property="work", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_attendance", property="isAttendance", jdbcType=JdbcType.INTEGER),
        @Result(column="is_work", property="isWork", jdbcType=JdbcType.INTEGER)
    })
    List<ViewAttendanceWork> selectByExample(ViewAttendanceWorkExample example);
}