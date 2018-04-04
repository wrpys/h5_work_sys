package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewRole;
import com.shirokumacafe.archetype.entity.ViewRoleExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ViewRoleMapper {
    @SelectProvider(type=ViewRoleSqlProvider.class, method="countByExample")
    int countByExample(ViewRoleExample example);

    @SelectProvider(type=ViewRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sys", property="sys", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="permission", property="permission", jdbcType=JdbcType.NVARCHAR)
    })
    List<ViewRole> selectByExampleWithRowbounds(ViewRoleExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sys", property="sys", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="permission", property="permission", jdbcType=JdbcType.NVARCHAR)
    })
    List<ViewRole> selectByExample(ViewRoleExample example);
}