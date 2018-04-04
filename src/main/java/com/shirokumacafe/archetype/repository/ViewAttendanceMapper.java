package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewAttendance;
import com.shirokumacafe.archetype.entity.ViewAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewAttendanceMapper {
    @SelectProvider(type=ViewAttendanceSqlProvider.class, method="countByExample")
    int countByExample(ViewAttendanceExample example);

    @SelectProvider(type=ViewAttendanceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="a_id", property="aId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="a_add_time", property="aAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="a_status", property="aStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ViewAttendance> selectByExampleWithRowbounds(ViewAttendanceExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewAttendanceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="a_id", property="aId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="a_add_time", property="aAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="a_status", property="aStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ViewAttendance> selectByExample(ViewAttendanceExample example);
}