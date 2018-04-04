package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Notice;
import com.shirokumacafe.archetype.entity.NoticeExample;
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

public interface NoticeMapper {
    @SelectProvider(type=NoticeSqlProvider.class, method="countByExample")
    int countByExample(NoticeExample example);

    @DeleteProvider(type=NoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(NoticeExample example);

    @Delete({
        "delete from t_notice",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer noticeId);

    @Insert({
        "insert into t_notice (notice_title, add_user, ",
        "add_time, notice_content)",
        "values (#{noticeTitle,jdbcType=VARCHAR}, #{addUser,jdbcType=INTEGER}, ",
        "#{addTime,jdbcType=TIMESTAMP}, #{noticeContent,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="noticeId", before=false, resultType=Integer.class)
    int insert(Notice record);

    @InsertProvider(type=NoticeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="noticeId", before=false, resultType=Integer.class)
    int insertSelective(Notice record);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Notice> selectByExampleWithBLOBsWithRowbounds(NoticeExample example, RowBounds rowBounds);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Notice> selectByExampleWithRowbounds(NoticeExample example, RowBounds rowBounds);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Notice> selectByExample(NoticeExample example);

    @Select({
        "select",
        "notice_id, notice_title, add_user, add_time, notice_content",
        "from t_notice",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    Notice selectByPrimaryKey(Integer noticeId);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update t_notice",
        "set notice_title = #{noticeTitle,jdbcType=VARCHAR},",
          "add_user = #{addUser,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "notice_content = #{noticeContent,jdbcType=LONGVARCHAR}",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Notice record);

    @Update({
        "update t_notice",
        "set notice_title = #{noticeTitle,jdbcType=VARCHAR},",
          "add_user = #{addUser,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
}