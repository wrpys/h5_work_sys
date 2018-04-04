package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.CourseTime;
import com.shirokumacafe.archetype.entity.CourseTimeExample;
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

public interface CourseTimeMapper {
    @SelectProvider(type=CourseTimeSqlProvider.class, method="countByExample")
    int countByExample(CourseTimeExample example);

    @DeleteProvider(type=CourseTimeSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseTimeExample example);

    @Delete({
        "delete from t_course_time",
        "where ct_id = #{ctId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ctId);

    @Insert({
        "insert into t_course_time (c_id, ct_time, ",
        "is_attendance, is_work)",
        "values (#{cId,jdbcType=INTEGER}, #{ctTime,jdbcType=TIMESTAMP}, ",
        "#{isAttendance,jdbcType=INTEGER}, #{isWork,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="ctId", before=false, resultType=Integer.class)
    int insert(CourseTime record);

    @InsertProvider(type=CourseTimeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="ctId", before=false, resultType=Integer.class)
    int insertSelective(CourseTime record);

    @SelectProvider(type=CourseTimeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_time", property="ctTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_attendance", property="isAttendance", jdbcType=JdbcType.INTEGER),
        @Result(column="is_work", property="isWork", jdbcType=JdbcType.INTEGER)
    })
    List<CourseTime> selectByExampleWithRowbounds(CourseTimeExample example, RowBounds rowBounds);

    @SelectProvider(type=CourseTimeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_time", property="ctTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_attendance", property="isAttendance", jdbcType=JdbcType.INTEGER),
        @Result(column="is_work", property="isWork", jdbcType=JdbcType.INTEGER)
    })
    List<CourseTime> selectByExample(CourseTimeExample example);

    @Select({
        "select",
        "ct_id, c_id, ct_time, is_attendance, is_work",
        "from t_course_time",
        "where ct_id = #{ctId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_time", property="ctTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_attendance", property="isAttendance", jdbcType=JdbcType.INTEGER),
        @Result(column="is_work", property="isWork", jdbcType=JdbcType.INTEGER)
    })
    CourseTime selectByPrimaryKey(Integer ctId);

    @UpdateProvider(type=CourseTimeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CourseTime record, @Param("example") CourseTimeExample example);

    @UpdateProvider(type=CourseTimeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CourseTime record, @Param("example") CourseTimeExample example);

    @UpdateProvider(type=CourseTimeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseTime record);

    @Update({
        "update t_course_time",
        "set c_id = #{cId,jdbcType=INTEGER},",
          "ct_time = #{ctTime,jdbcType=TIMESTAMP},",
          "is_attendance = #{isAttendance,jdbcType=INTEGER},",
          "is_work = #{isWork,jdbcType=INTEGER}",
        "where ct_id = #{ctId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseTime record);
}