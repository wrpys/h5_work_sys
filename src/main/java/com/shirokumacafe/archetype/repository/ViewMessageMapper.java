package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.ViewMessage;
import com.shirokumacafe.archetype.entity.ViewMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ViewMessageMapper {
    @SelectProvider(type=ViewMessageSqlProvider.class, method="countByExample")
    int countByExample(ViewMessageExample example);

    @SelectProvider(type=ViewMessageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_pid", property="msgPid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="send__role", property="sendRole", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_content", property="msgContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_add_time", property="msgAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="msg_is_read", property="msgIsRead", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_is_reply", property="msgIsReply", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewMessage> selectByExampleWithRowbounds(ViewMessageExample example, RowBounds rowBounds);

    @SelectProvider(type=ViewMessageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_pid", property="msgPid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="send__role", property="sendRole", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_content", property="msgContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_add_time", property="msgAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="msg_is_read", property="msgIsRead", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_is_reply", property="msgIsReply", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR)
    })
    List<ViewMessage> selectByExample(ViewMessageExample example);
}