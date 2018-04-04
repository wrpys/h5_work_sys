package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewMenu;
import com.shirokumacafe.archetype.entity.ViewMenuExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ViewMenuMapper {
    @SelectProvider(type=ViewMenuSqlProvider.class, method="countByExample")
    int countByExample(ViewMenuExample example);

    @SelectProvider(type=ViewMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_pid", property="menuPid", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_link", property="menuLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="buttons", property="buttons", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewMenu> selectByExampleWithRowbounds(ViewMenuExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_pid", property="menuPid", jdbcType=JdbcType.INTEGER),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_link", property="menuLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="buttons", property="buttons", jdbcType=JdbcType.NVARCHAR)
    })
    List<ViewMenu> selectByExample(ViewMenuExample example);
}