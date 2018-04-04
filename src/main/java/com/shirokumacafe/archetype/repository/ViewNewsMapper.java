package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewNews;
import com.shirokumacafe.archetype.entity.ViewNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewNewsMapper {
    @SelectProvider(type=ViewNewsSqlProvider.class, method="countByExample")
    int countByExample(ViewNewsExample example);

    @SelectProvider(type=ViewNewsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="news_content", property="newsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ViewNews> selectByExampleWithBLOBsWithRowbounds(ViewNewsExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewNewsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="news_content", property="newsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ViewNews> selectByExampleWithBLOBs(ViewNewsExample example);

    @SelectProvider(type=ViewNewsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewNews> selectByExampleWithRowbounds(ViewNewsExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewNewsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewNews> selectByExample(ViewNewsExample example);
}