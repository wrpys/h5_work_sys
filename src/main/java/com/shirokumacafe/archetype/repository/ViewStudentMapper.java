package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewStudent;
import com.shirokumacafe.archetype.entity.ViewStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewStudentMapper {
    @SelectProvider(type=ViewStudentSqlProvider.class, method="countByExample")
    int countByExample(ViewStudentExample example);

    @SelectProvider(type=ViewStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_password", property="sPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT),
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_class", property="sClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_name", property="dName", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_pid", property="dPid", jdbcType=JdbcType.INTEGER)
    })
    List<ViewStudent> selectByExampleWithRowbounds(ViewStudentExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_password", property="sPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT),
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_class", property="sClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_name", property="dName", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_pid", property="dPid", jdbcType=JdbcType.INTEGER)
    })
    List<ViewStudent> selectByExample(ViewStudentExample example);
}