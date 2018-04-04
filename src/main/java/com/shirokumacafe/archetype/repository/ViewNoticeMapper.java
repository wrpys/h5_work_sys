package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewNotice;
import com.shirokumacafe.archetype.entity.ViewNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewNoticeMapper {
    @SelectProvider(type=ViewNoticeSqlProvider.class, method="countByExample")
    int countByExample(ViewNoticeExample example);

    @SelectProvider(type=ViewNoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ViewNotice> selectByExampleWithBLOBsWithRowbounds(ViewNoticeExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewNoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ViewNotice> selectByExampleWithBLOBs(ViewNoticeExample example);

    @SelectProvider(type=ViewNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewNotice> selectByExampleWithRowbounds(ViewNoticeExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER),
        @Result(column="notice_title", property="noticeTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_user", property="addUser", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewNotice> selectByExample(ViewNoticeExample example);
}