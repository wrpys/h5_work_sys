package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Course;
import com.shirokumacafe.archetype.entity.CourseExample;
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

public interface CourseMapper {
    @SelectProvider(type=CourseSqlProvider.class, method="countByExample")
    int countByExample(CourseExample example);

    @DeleteProvider(type=CourseSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseExample example);

    @Delete({
        "delete from t_course",
        "where c_id = #{cId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cId);

    @Insert({
        "insert into t_course (c_name, t_id, ",
        "c_attend_time, c_attend_addr)",
        "values (#{cName,jdbcType=VARCHAR}, #{tId,jdbcType=INTEGER}, ",
        "#{cAttendTime,jdbcType=TIMESTAMP}, #{cAttendAddr,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="cId", before=false, resultType=Integer.class)
    int insert(Course record);

    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="cId", before=false, resultType=Integer.class)
    int insertSelective(Course record);

    @SelectProvider(type=CourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="c_attend_addr", property="cAttendAddr", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectByExampleWithRowbounds(CourseExample example, RowBounds rowBounds);

    @SelectProvider(type=CourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="c_attend_addr", property="cAttendAddr", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectByExample(CourseExample example);

    @Select({
        "select",
        "c_id, c_name, t_id, c_attend_time, c_attend_addr",
        "from t_course",
        "where c_id = #{cId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_id", property="tId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_attend_time", property="cAttendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="c_attend_addr", property="cAttendAddr", jdbcType=JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(Integer cId);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    @Update({
        "update t_course",
        "set c_name = #{cName,jdbcType=VARCHAR},",
          "t_id = #{tId,jdbcType=INTEGER},",
          "c_attend_time = #{cAttendTime,jdbcType=TIMESTAMP},",
          "c_attend_addr = #{cAttendAddr,jdbcType=INTEGER}",
        "where c_id = #{cId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}