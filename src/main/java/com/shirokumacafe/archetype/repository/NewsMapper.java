package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.News;
import com.shirokumacafe.archetype.entity.NewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface NewsMapper {
    @SelectProvider(type=NewsSqlProvider.class, method="countByExample")
    int countByExample(NewsExample example);

    @DeleteProvider(type=NewsSqlProvider.class, method="deleteByExample")
    int deleteByExample(NewsExample example);

    @Delete({
        "delete from t_news",
        "where news_id = #{newsId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer newsId);

    @Insert({
        "insert into t_news (news_title, add_user, ",
        "add_time, news_content)",
        "values (#{newsTitle,jdbcType=VARCHAR}, #{addUser,jdbcType=INTEGER}, ",
        "#{addTime,jdbcType=TIMESTAMP}, #{newsContent,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="newsId", before=false, resultType=Integer.class)
    int insert(News record);

    @InsertProvider(type=NewsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="newsId", before=false, resultType=Integer.class)
    int insertSelective(News record);

    @SelectProvider(type=NewsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="news_content", property="newsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<News> selectByExampleWithBLOBsWithRowbounds(NewsExample example, RowBounds rowBounds);

    @SelectProvider(type=NewsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="news_content", property="newsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<News> selectByExampleWithBLOBs(NewsExample example);

    @SelectProvider(type=NewsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<News> selectByExampleWithRowbounds(NewsExample example, RowBounds rowBounds);

    @SelectProvider(type=NewsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<News> selectByExample(NewsExample example);

    @Select({
        "select",
        "news_id, news_title, add_user, add_time, news_content",
        "from t_news",
        "where news_id = #{newsId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="news_id", property="newsId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="news_title", property="newsTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="news_content", property="newsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    News selectByPrimaryKey(Integer newsId);

    @UpdateProvider(type=NewsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    @UpdateProvider(type=NewsSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") News record, @Param("example") NewsExample example);

    @UpdateProvider(type=NewsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    @UpdateProvider(type=NewsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(News record);

    @Update({
        "update t_news",
        "set news_title = #{newsTitle,jdbcType=VARCHAR},",
          "add_user = #{addUser,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "news_content = #{newsContent,jdbcType=LONGVARCHAR}",
        "where news_id = #{newsId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(News record);

    @Update({
        "update t_news",
        "set news_title = #{newsTitle,jdbcType=VARCHAR},",
          "add_user = #{addUser,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where news_id = #{newsId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(News record);
}