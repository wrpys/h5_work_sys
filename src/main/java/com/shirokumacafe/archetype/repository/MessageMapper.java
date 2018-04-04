package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface MessageMapper {
    @SelectProvider(type=MessageSqlProvider.class, method="countByExample")
    int countByExample(MessageExample example);

    @DeleteProvider(type=MessageSqlProvider.class, method="deleteByExample")
    int deleteByExample(MessageExample example);

    @Delete({
        "delete from t_message",
        "where msg_id = #{msgId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer msgId);

    @Insert({
        "insert into t_message (msg_id, msg_pid, ",
        "send__role, student_id, ",
        "user_id, msg_content, ",
        "msg_add_time, msg_is_reply, ",
        "msg_is_read)",
        "values (#{msgId,jdbcType=INTEGER}, #{msgPid,jdbcType=INTEGER}, ",
        "#{sendRole,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{msgContent,jdbcType=VARCHAR}, ",
        "#{msgAddTime,jdbcType=TIMESTAMP}, #{msgIsReply,jdbcType=INTEGER}, ",
        "#{msgIsRead,jdbcType=INTEGER})"
    })
    int insert(Message record);

    @InsertProvider(type=MessageSqlProvider.class, method="insertSelective")
    int insertSelective(Message record);

    @SelectProvider(type=MessageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="msg_pid", property="msgPid", jdbcType=JdbcType.INTEGER),
        @Result(column="send__role", property="sendRole", jdbcType=JdbcType.INTEGER),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_content", property="msgContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_add_time", property="msgAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="msg_is_reply", property="msgIsReply", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_is_read", property="msgIsRead", jdbcType=JdbcType.INTEGER)
    })
    List<Message> selectByExampleWithRowbounds(MessageExample example, RowBounds rowBounds);

    @SelectProvider(type=MessageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="msg_pid", property="msgPid", jdbcType=JdbcType.INTEGER),
        @Result(column="send__role", property="sendRole", jdbcType=JdbcType.INTEGER),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_content", property="msgContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_add_time", property="msgAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="msg_is_reply", property="msgIsReply", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_is_read", property="msgIsRead", jdbcType=JdbcType.INTEGER)
    })
    List<Message> selectByExample(MessageExample example);

    @Select({
        "select",
        "msg_id, msg_pid, send__role, student_id, user_id, msg_content, msg_add_time, ",
        "msg_is_reply, msg_is_read",
        "from t_message",
        "where msg_id = #{msgId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="msg_id", property="msgId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="msg_pid", property="msgPid", jdbcType=JdbcType.INTEGER),
        @Result(column="send__role", property="sendRole", jdbcType=JdbcType.INTEGER),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_content", property="msgContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_add_time", property="msgAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="msg_is_reply", property="msgIsReply", jdbcType=JdbcType.INTEGER),
        @Result(column="msg_is_read", property="msgIsRead", jdbcType=JdbcType.INTEGER)
    })
    Message selectByPrimaryKey(Integer msgId);

    @UpdateProvider(type=MessageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    @UpdateProvider(type=MessageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    @UpdateProvider(type=MessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Message record);

    @Update({
        "update t_message",
        "set msg_pid = #{msgPid,jdbcType=INTEGER},",
          "send__role = #{sendRole,jdbcType=INTEGER},",
          "student_id = #{studentId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "msg_content = #{msgContent,jdbcType=VARCHAR},",
          "msg_add_time = #{msgAddTime,jdbcType=TIMESTAMP},",
          "msg_is_reply = #{msgIsReply,jdbcType=INTEGER},",
          "msg_is_read = #{msgIsRead,jdbcType=INTEGER}",
        "where msg_id = #{msgId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Message record);
}